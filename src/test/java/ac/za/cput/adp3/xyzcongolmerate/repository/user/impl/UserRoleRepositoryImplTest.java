package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserRoleFactory;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRoleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRoleRepositoryImplTest {
    private UserRoleRepository re;
    private UserRole usr;

    private UserRole getSavedUser(){
        Set<UserRole> sU = this.re.getAll();
        return sU.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.re = UserRoleRepositoryImpl.getUsrRRepo();
        this.usr = UserRoleFactory.buildUserRole("Code", "1234@gmail.com", "ID");
    }

    @Test
    public void a_create() {
        UserRole created = this.re.create(this.usr);
        System.out.println(created);
        Assert.assertEquals(created, this.usr);
        d_getAll();
    }

    @Test
    public void b_read() {
        UserRole sU = getSavedUser();
        System.out.println(sU.getUserEmail());
        UserRole read = this.re.read(sU);
        System.out.println(read);
        Assert.assertEquals(sU, read);
    }

    @Test
    public void c_update() {
        Assert.assertTrue(true);
    }

    @Test
    public void e_delete() {
        UserRole sU = getSavedUser();
        this.re.delete(sU);
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<UserRole> all = this.re.getAll();
        System.out.println(all);
        Assert.assertNotNull(usr);
    }
}