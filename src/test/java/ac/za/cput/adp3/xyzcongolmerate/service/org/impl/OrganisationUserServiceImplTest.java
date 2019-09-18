package ac.za.cput.adp3.xyzcongolmerate.service.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.service.org.OrganisationUserService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ac.za.cput.adp3.xyzcongolmerate.service.org.OrganisationUserService;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganisationUserServiceImplTest {

    @Test
    public void a_create() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Test
    public void b_read() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Test
    public void c_update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Test
    public void g_delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Test
    public void d_getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Test
    public void e_getUserFullNamesInOrganisation() {

        Organisation o = new Organisation.Builder().orgCode("123").orgName("ABC").build();
        String k = o.getOrgCode();
        OrganisationUserService getOrganisationUserService = null;
       Set<String> s = getOrganisationUserService.getUserFullNamesInOrganisation(k);
        Set<String> v = getOrganisationUserService.getUserFullNamesInOrganisation(k);
       Assert.assertEquals(s, v);

    }

    @Test
    public void f_getUserOrganisations() {

        Organisation o = new Organisation.Builder().orgCode("123").orgName("ABC").build();

    }
}