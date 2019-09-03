package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;

public class UserRoleFactory {

    public static UserRole buildUserRole(String oCde, String usrEMail, String rleId) {
        UserRole usrRle = new UserRole(oCde, usrEMail, rleId);
        return usrRle;

    }
}
