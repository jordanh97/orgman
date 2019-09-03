package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;

public class UserFactory {

    public static User buildUser(String usrEMail, String fN, String lN) {
        return new User.Builder().userEmail(usrEMail).firstName(fN).lastName(lN).build();

    }
}
