package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepository usrRepo = null;
    private Set<User> usrDBase;

    private UserRepositoryImpl() {
        this.usrDBase = new HashSet<>();
    }

    public User findUser(String userEMail){
        return this.usrDBase.stream().filter(user -> user.getUserEmail().trim().equals(userEMail)).findAny().orElse(null);
    }

    public static UserRepository getUsrRepo() {
        if (usrRepo == null) usrRepo = new UserRepositoryImpl();
        return usrRepo;
    }

    @Override
    public User create(User u) {
        this.usrDBase.add(u);
        return u;
    }

    @Override
    public User read(String eMail) {
        User u = findUser(eMail);
        return u;
    }

    @Override
    public User update(User uu) {
        User so = findUser(uu.getUserEmail());
        if(so != null){
            this.usrDBase.remove(so);
            return create(uu);
        }
        return null;
    }

    @Override
    public void delete(String eMail) {
        User u = findUser(eMail);
        if (u != null) {
            usrDBase.remove(u);
        }
    }

    @Override
    public Set<User> getAll() {
        return this.usrDBase;
    }
}
