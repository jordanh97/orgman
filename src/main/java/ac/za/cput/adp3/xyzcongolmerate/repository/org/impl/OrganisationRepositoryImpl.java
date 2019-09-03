package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationRepository;

import java.util.HashSet;
import java.util.Set;

public class OrganisationRepositoryImpl implements OrganisationRepository {

    private Set<Organisation> orgDBase;
    private static OrganisationRepository oRepo = null;

    public static OrganisationRepository getoRepo() {
        if (oRepo == null) oRepo = new OrganisationRepositoryImpl();
        return oRepo;
    }

    private Organisation findOrganisation(String orgID) {
        return this.orgDBase.stream()
                .filter(organisation -> organisation.getOrgCode().trim().equals(orgID))
                .findAny()
                .orElse(null);
    }

    private OrganisationRepositoryImpl() {
        this.orgDBase = new HashSet<>();
    }

    @Override
    public Organisation create(Organisation org) {
        this.orgDBase.add(org);
        return org;
    }

    @Override
    public Organisation read(String orgSoul) {
        Organisation o = findOrganisation(orgSoul);
        return o;
    }

    @Override
    public Organisation update(Organisation org) {
        Organisation del = findOrganisation(org.getOrgCode());
        if (del != null) {
            this.orgDBase.remove(del);
            return create(org);
        }
        return null;
    }

    @Override
    public void delete(String orgCode) {
        Organisation seo = findOrganisation(orgCode);
        if (seo != null){
            this.orgDBase.remove(seo);
        }
    }

    @Override
    public Set<Organisation> getAll() {
        return this.orgDBase;
    }
}