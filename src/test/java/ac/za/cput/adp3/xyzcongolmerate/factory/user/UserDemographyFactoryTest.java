package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

public class UserDemographyFactoryTest {

    @Test
    public void buildUserDemography() {
        Date d = new Date();
        UserDemography uDem =
                UserDemographyFactory.buildUserDemography("Code", "Captain", "1234@gmail.com", "Code", d);
        System.out.println("User Email is: " + uDem.getUserEmail());
        Assert.assertNotNull(uDem);

    }
}