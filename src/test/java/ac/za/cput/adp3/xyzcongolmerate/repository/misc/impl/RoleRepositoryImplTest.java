package ac.za.cput.adp3.xyzcongolmerate.repository.misc.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.factory.misc.RoleFactory;
import ac.za.cput.adp3.xyzcongolmerate.repository.misc.RoleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleRepositoryImplTest {

    private RoleRepository repo;
    private Role role;

    private Role getSavedRole(){
        Set<Role> sR = this.repo.getAll();
        return sR.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repo = RoleRepositoryImpl.getrRepo();
        this.role = RoleFactory.buildRole("CEO");
    }

    @Test
    public void a_create() {
        Role created = this.repo.create(this.role);
        System.out.println(created);
        Assert.assertEquals(created, this.role);
        d_getAll();
    }

    @Test
    public void b_read() {
        Role savedRole = getSavedRole();
        System.out.println(savedRole.getRoleId());
        Role r = this.repo.read(savedRole.getRoleId());
        System.out.println(r);
        Assert.assertEquals(savedRole, r);
    }

    @Test
    public void c_update() {
        String newName = "MD";
        Role r = new Role.Builder().copy(getSavedRole()).roleName(newName).build();
        System.out.println(r);
        Role updated = this.repo.update(r);
        System.out.println(updated);
        Assert.assertEquals(newName, updated.getRoleName());
    }

    @Test
    public void e_delete() {
        Role sR = getSavedRole();
        this.repo.delete(sR.getRoleId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Role> all = this.repo.getAll();
        System.out.println(all);
        Assert.assertNotNull(role);
    }
}