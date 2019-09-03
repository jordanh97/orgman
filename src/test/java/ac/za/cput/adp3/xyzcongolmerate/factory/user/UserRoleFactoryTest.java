package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import org.junit.Assert;
import org.junit.Test;

public class UserRoleFactoryTest {

    @Test
    public void buildUserRole() {
        UserRole uR = UserRoleFactory.buildUserRole("Code", "123444@gmail.com", "ID");
        System.out.println("Email: " + uR.getUserEmail());
        Assert.assertNotNull(uR);

    }
}