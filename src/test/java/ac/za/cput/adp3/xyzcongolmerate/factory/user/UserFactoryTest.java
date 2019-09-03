package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import org.junit.Assert;
import org.junit.Test;

public class UserFactoryTest {

    @Test
    public void buildUser() {
        User u = UserFactory.buildUser("1233@gmail.com", "Jon", "Doe");
        System.out.println("EMail: " + u.getUserEmail());
        Assert.assertNotNull(u);

    }
}