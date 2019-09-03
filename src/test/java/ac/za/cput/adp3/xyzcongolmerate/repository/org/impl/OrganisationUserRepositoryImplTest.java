package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationUserFactory;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationUserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganisationUserRepositoryImplTest {
    private OrganisationUserRepository repo;
    private OrganisationUser organisation;

    private OrganisationUser getSavedOrg(){
        Set<OrganisationUser> savedOrganisationUsers = this.repo.getAll();
        return savedOrganisationUsers.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repo = OrganisationUserRepositoryImpl.getoUR();
        this.organisation = OrganisationUserFactory.buildOrganisationUser("Code", "123333@gmail.com");
    }

    @Test
    public void a_create() {
        OrganisationUser cD = this.repo.create(this.organisation);
        System.out.println(cD);
        Assert.assertEquals(cD, this.organisation);
        d_getAll();
    }

    @Test
    public void b_read() {
        OrganisationUser sU = getSavedOrg();
        System.out.println(sU.getUserEmail());
        OrganisationUser read = this.repo.read(sU.getOrgCode(), sU.getUserEmail());
        System.out.println(read);
        Assert.assertEquals(sU, read);
    }

    @Test
    public void c_update() {
        Assert.assertTrue(true);
    }

    @Test
    public void e_delete() {
        OrganisationUser sU = getSavedOrg();
        this.repo.delete(sU.getOrgCode(), sU.getUserEmail());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<OrganisationUser> all = this.repo.getAll();
        System.out.println(all);
        Assert.assertNotNull(organisation);
    }
}