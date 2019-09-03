package ac.za.cput.adp3.xyzcongolmerate.factory.demography;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import org.junit.Assert;
import org.junit.Test;

public class RaceFactoryTest {

    @Test
    public void buildRace() {
        Race r = RaceFactory.buildRace("Black");
        Assert.assertNotNull(r.getRaceId());
        System.out.println("r ID is: " + r.getRaceId());

    }
}