package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserDemographyRepository;

import java.util.HashSet;
import java.util.Set;

public class UserDemographyRepositoryImpl implements UserDemographyRepository {

    private Set<UserDemography> usrDemDBase;
    private static UserDemographyRepository usrDemRepo = null;

    private UserDemographyRepositoryImpl() {
        this.usrDemDBase = new HashSet<>();
    }

    public UserDemography findUD(String userEmail){
        return this.usrDemDBase.stream().filter(user -> user.getUserEmail().trim().equals(userEmail)).findAny().orElse(null);
    }

    public static UserDemographyRepository getUsrDemRepo() {
        if (usrDemRepo == null) usrDemRepo = new UserDemographyRepositoryImpl();
        return usrDemRepo;
    }

    @Override
    public UserDemography create(UserDemography usrDem) {
        this.usrDemDBase.add(usrDem);
        return usrDem;
    }

    @Override
    public UserDemography read(String userEMail) {
        UserDemography u = findUD(userEMail);
        return u;
    }

    @Override
    public UserDemography update(UserDemography usrDem) {
        UserDemography del = findUD(usrDem.getUserEmail());
        if(del != null){
            this.usrDemDBase.remove(del);
            return create(usrDem);
        }
        return null;
    }

    @Override
    public void delete(String usrEMail) {
        UserDemography u = findUD(usrEMail);
        if (u != null) {
            usrDemDBase.remove(u);
        }
    }

    @Override
    public Set<UserDemography> getAll() {
        return this.usrDemDBase;
    }
}