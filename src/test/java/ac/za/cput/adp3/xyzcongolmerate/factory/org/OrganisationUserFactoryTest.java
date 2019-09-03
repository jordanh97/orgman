package ac.za.cput.adp3.xyzcongolmerate.factory.org;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import org.junit.Assert;
import org.junit.Test;

public class OrganisationUserFactoryTest {

    @Test
    public void buildOrganisationUser() {
        OrganisationUser orgUser = OrganisationUserFactory.buildOrganisationUser("Code for Organisation", "123333@gmail.com");
        System.out.println("User Role Email: " + orgUser.getUserEmail());
        Assert.assertNotNull(orgUser);

    }
}