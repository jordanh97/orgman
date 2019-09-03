package ac.za.cput.adp3.xyzcongolmerate.repository.misc.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.repository.misc.RoleRepository;

import java.util.HashSet;
import java.util.Set;

public class RoleRepositoryImpl implements RoleRepository {

    private static RoleRepository rRepo = null;
    private Set<Role> rleDBase;

    private RoleRepositoryImpl() {
        this.rleDBase = new HashSet<>();
    }

    public static RoleRepository getrRepo() {
        if (rRepo == null) rRepo = new RoleRepositoryImpl();
        return rRepo;
    }

    private Role searchForRole(String roleId) {
        return this.rleDBase.stream()
                .filter(role -> role.getRoleId().trim().equals(roleId))
                .findAny()
                .orElse(null);
    }

    public Role create(Role rle) {
        this.rleDBase.add(rle);
        return rle;
    }

    public Role read(String rleId) {
        Role role = searchForRole(rleId);
        return role;
    }

    public Role update(Role role) {
        Role del = searchForRole(role.getRoleId());
        if(del != null){
            this.rleDBase.remove(del);
            return create(role);
        }
        return null;
    }

    public void delete(String roleId) {
        Role del = searchForRole(roleId);
        if (del != null){
            this.rleDBase.remove(del);
        }
    }

    public Set<Role> getAll() {
        return this.rleDBase;
    }
}
