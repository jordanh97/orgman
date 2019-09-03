package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;

import java.util.Date;

public class UserDemographyFactory {

    public static UserDemography buildUserDemography(String usrTtle, String genId, String usrEMail, String rceId, Date dOB) {
        UserDemography usrDem = new UserDemography( usrTtle, genId, usrEMail, rceId, dOB);
        return usrDem;

    }
}
