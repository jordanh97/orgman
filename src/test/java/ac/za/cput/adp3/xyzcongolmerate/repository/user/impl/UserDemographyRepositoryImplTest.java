package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserDemographyFactory;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserDemographyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Date;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDemographyRepositoryImplTest {
    private UserDemographyRepository repo;
    private UserDemography user;

    private UserDemography getSavedUser(){
        Set<UserDemography> savedUsers = this.repo.getAll();
        return savedUsers.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        Date d = new Date();
        this.repo = UserDemographyRepositoryImpl.getUsrDemRepo();
        this.user = UserDemographyFactory.buildUserDemography("ID", "MD", "1234@gmail.com", "RaceIdTest", d );
    }

    @Test
    public void a_create() {
        UserDemography created = this.repo.create(this.user);
        System.out.println(created);
        Assert.assertEquals(created, this.user);
        d_getAll();
    }

    @Test
    public void b_read() {
        UserDemography savedUser = getSavedUser();
        System.out.println(savedUser.getUserEmail());
        UserDemography r = this.repo.read(savedUser.getUserEmail());
        System.out.println(r);
        Assert.assertEquals(savedUser, r);
    }

    @Test
    public void c_update() {
        Assert.assertTrue(true);
    }

    @Test
    public void e_delete() {
        UserDemography sU = getSavedUser();
        this.repo.delete(sU.getUserEmail());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<UserDemography> a = this.repo.getAll();
        System.out.println(a);
        Assert.assertNotNull(user);
    }
}