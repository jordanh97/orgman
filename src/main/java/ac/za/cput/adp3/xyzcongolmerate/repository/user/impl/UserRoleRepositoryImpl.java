package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRoleRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRoleRepositoryImpl implements UserRoleRepository {

    private Set<UserRole> usrRDBase;
    private static UserRoleRepository usrRRepo = null;

    private UserRoleRepositoryImpl() {
        this.usrRDBase = new HashSet<>();
    }


    public UserRole findUR(String uEMail){
        return this.usrRDBase.stream().filter(user -> user.getUserEmail().trim().equals(uEMail)).findAny().orElse(null);
    }

    public static UserRoleRepository getUsrRRepo() {
        if (usrRRepo == null) usrRRepo = new UserRoleRepositoryImpl();
        return usrRRepo;
    }

    @Override
    public UserRole create(UserRole uRole) {
        usrRDBase.add(uRole);
        return uRole;
    }

    @Override
    public UserRole read(UserRole uRole) { UserRole u = findUR(uRole.getUserEmail());
        return u;
    }

    @Override
    public UserRole update(UserRole uRole) { UserRole seo = findUR(uRole.getUserEmail());
        if(seo != null){
            this.usrRDBase.remove(seo);
            return create(uRole);
        }
        return null;
    }

    @Override
    public void delete(UserRole uRole) { UserRole user = findUR(uRole.getUserEmail());
        if (user != null) {
            usrRDBase.remove(user);

        }
    }

    @Override
    public Set<UserRole> getAll() {
        return this.usrRDBase;
    }
}
