package ac.za.cput.adp3.xyzcongolmerate.factory.misc;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.util.Helper;

public class RoleFactory {

    private static final String SUFFIX = Helper.getSuffixFromClassName(RoleFactory.class); // Expecting RF from (R)ole(F)actory.

    public static Role buildRole(String rleNm) {
        return new Role.Builder().roleId(Helper.generateRandomGivenSuffix(SUFFIX)).roleName(rleNm).build();

        /**
         * Your implementation goes here
         * INSTRUCTIONS
         * 1. Remove line [//TODO: implement method body ONLY!]
         * 2. Remove line [throw new UnsupportedOperationException("Not supported yet.");]
         * 3. Generate random id using SUFFIX (Hint: call generateRandomGivenSuffix method in Helper class)
         * 4. Build and return an object of Role
         */
    }
}
