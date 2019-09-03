package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationUserRepository;

import java.util.HashSet;
import java.util.Set;

public class OrganisationUserRepositoryImpl implements OrganisationUserRepository {

    private static OrganisationUserRepository oURepo = null;
    private Set<OrganisationUser> oUDBase;

    private OrganisationUserRepositoryImpl() {
        this.oUDBase = new HashSet<>();
    }

    public static OrganisationUserRepository getoUR() {
        if (oURepo == null) oURepo = new OrganisationUserRepositoryImpl();
        return oURepo;
    }

    private OrganisationUser searchForOU(String o) {
        return this.oUDBase.stream()
                .filter(org -> org.getUserEmail().trim().equals(o))
                .findAny()
                .orElse(null);
    }


    @Override
    public OrganisationUser create(OrganisationUser oUS) {
        this.oUDBase.add(oUS);
        return oUS;
    }

    @Override
    public OrganisationUser read(String ogCode, String userEMail) {
        OrganisationUser o = searchForOU(userEMail);
        return o;
    }

    @Override
    public OrganisationUser update(OrganisationUser oU) {
        OrganisationUser del = searchForOU(oU.getUserEmail());
        if (del != null) {
            this.oUDBase.remove(del);
            return create(oU);
        }
        return null;
    }

    @Override
    public void delete(String ogCode, String userEMail) {
        OrganisationUser dep = searchForOU(userEMail);
        if (dep != null) this.oUDBase.remove(dep);
    }

    @Override
    public Set<OrganisationUser> getAll() {
        return this.oUDBase;
    }

}