package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.RaceFactory;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.RaceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceRepositoryImplTest {

    private RaceRepository repo;
    private Race race;

    private Race getSavedRace(){
        Set<Race> savedRaces = this.repo.getAll();
        return savedRaces.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repo = RaceRepositoryImpl.getRaceRepository();
        this.race = RaceFactory.buildRace( "Black");
    }

    @Test
    public void a_create() {
        Race d = this.repo.create(this.race);
        System.out.println(d);
        Assert.assertEquals(d, this.race);
        d_getAll();
    }

    @Test
    public void b_read() {
        Race sR = getSavedRace();
        System.out.println(sR.getRaceId());
        Race read = this.repo.read(sR.getRaceId());
        System.out.println(read);
        Assert.assertEquals(sR, read);
    }

    @Test
    public void c_update() {
        String newName = "Indian";
        Race r = new Race.Builder().copy(getSavedRace()).raceDescription(newName).build();
        System.out.println(r);
        Race updated = this.repo.update(r);
        System.out.println(updated);
        Assert.assertEquals(newName, updated.getRaceDescription());
    }

    @Test
    public void e_delete() {
        Race savedRace = getSavedRace();
        this.repo.delete(savedRace.getRaceId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Race> all = this.repo.getAll();
        System.out.println(all);
        Assert.assertNotNull(race);
    }
}