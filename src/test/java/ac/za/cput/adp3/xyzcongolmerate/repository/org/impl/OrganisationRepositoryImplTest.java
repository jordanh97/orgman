package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationFactory;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganisationRepositoryImplTest {
    private OrganisationRepository repo;
    private Organisation organisation;

    private Organisation getSavedOrg(){
        Set<Organisation> savedOrganisations = this.repo.getAll();
        return savedOrganisations.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repo = OrganisationRepositoryImpl.getoRepo();
        this.organisation = OrganisationFactory.buildOrganisation("DB Org");
    }


    @Test
    public void a_create() {
        Organisation created = this.repo.create(this.organisation);
        System.out.println(created);
        Assert.assertEquals(created, this.organisation);
    }

    @Test
    public void b_read() {
        Organisation savedOrg = getSavedOrg();
        System.out.println(savedOrg.getOrgCode());
        Organisation r = this.repo.read(savedOrg.getOrgCode());
        System.out.println(r);
        Assert.assertEquals(savedOrg, r);
    }

    @Test
    public void c_update() {
        String newName = "Big Company";
        Organisation org = new Organisation.Builder().copy(getSavedOrg()).orgName(newName).build();
        System.out.println(org);
        Organisation updte = this.repo.update(org);
        System.out.println(updte);
        Assert.assertEquals(newName, updte.getOrgName());
    }

    @Test
    public void e_delete() {
        Organisation org = getSavedOrg();
        this.repo.delete(org.getOrgCode());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Organisation> all = this.repo.getAll();
        System.out.println(all);
        Assert.assertNotNull(organisation);
    }
}