package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserFactory;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryImplTest {
    private UserRepository rePository;
    private User usr;

    private User getSavedUser(){
        Set<User> savedUsers = this.rePository.getAll();
        return savedUsers.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.rePository = UserRepositoryImpl.getUsrRepo();
        this.usr = UserFactory.buildUser("jondoe@gmail.com", "Jon", "Doe");
    }

    @Test
    public void a_create() {
        User ctd = this.rePository.create(this.usr);
        System.out.println(ctd);
        Assert.assertEquals(ctd, this.usr);
        d_getAll();
    }

    @Test
    public void b_read() {
        User sU = getSavedUser();
        System.out.println(sU.getUserEmail());
        User r = this.rePository.read(sU.getUserEmail());
        System.out.println(r);
        Assert.assertEquals(sU, r);
    }

    @Test
    public void c_update() {
        String newName = "James";
        User u = new User.Builder().copy(getSavedUser()).firstName(newName).build();
        System.out.println(u);
        User updated = this.rePository.update(u);
        System.out.println(updated);
        Assert.assertEquals(newName, updated.getFirstName());
    }

    @Test
    public void e_delete() {
        User sU = getSavedUser();
        this.rePository.delete(sU.getUserEmail());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<User> all = this.rePository.getAll();
        System.out.println(all);
        Assert.assertNotNull(usr);
    }
}