package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.GenderFactory;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.GenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {
    private GenderRepository repo;
    private Gender gender;

    private Gender getSavedGender(){
        Set<Gender> savedGenders = this.repo.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repo = GenderRepositoryImpl.genderRepository();
        this.gender = GenderFactory.buildGender( "Male");
    }

    @Test
    public void a_create() {
        Gender built = this.repo.create(this.gender);
        System.out.println(built);
        Assert.assertEquals(built, this.gender);
        d_getAll();
    }

    @Test
    public void b_read() {
        Gender savedGender = getSavedGender();
        System.out.println(savedGender.getGenderId());
        Gender deed = this.repo.read(savedGender.getGenderId());
        System.out.println(deed);
        Assert.assertEquals(savedGender, deed);
    }

    @Test
    public void c_update() {
        String newName = "This";
        Gender f = new Gender.Builder().copy(getSavedGender()).genderDescription(newName).build();
        System.out.println(f);
        Gender g = this.repo.update(f);
        System.out.println(g);
        Assert.assertEquals(newName, g.getGenderDescription());
    }

    @Test
    public void e_delete() {
        Gender savedGender = getSavedGender();
        this.repo.delete(savedGender.getGenderId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Gender> all = this.repo.getAll();
        System.out.println(all);
        Assert.assertNotNull(gender);
    }
}