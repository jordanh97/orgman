package ac.za.cput.adp3.xyzcongolmerate.factory.demography;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import org.junit.Assert;
import org.junit.Test;

public class GenderFactoryTest {

    @Test
    public void buildGender() {
        Gender g = GenderFactory.buildGender("Female");
        Assert.assertNotNull(g.getGenderId());
        System.out.println(" Gender ID is: " + g.getGenderId());

    }
}