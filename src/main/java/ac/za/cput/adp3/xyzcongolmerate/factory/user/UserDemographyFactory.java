package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;

import java.util.Date;

public class UserDemographyFactory {

    public static UserDemography buildUserDemography(String usrTtle, String genId, String usrEMail, String rceId, Date dOB) {
        UserDemography usrDem = new UserDemography( usrTtle, genId, usrEMail, rceId, dOB);
        return usrDem;

        /**
         * Your implementation goes here
         * INSTRUCTIONS
         * 1. Remove line [//TODO: implement method body ONLY!]
         * 2. Remove line [throw new UnsupportedOperationException("Not supported yet.");]
         * 3. Create and return an object of UserDemography
         */
    }
}
