package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

    private Set<Gender> gnderDBase;
    private static GenderRepository gnderRepo = null;

    private GenderRepositoryImpl() {
        this.gnderDBase = new HashSet<>();
    }

    private Gender sourceGendr(String genId) {
        return this.gnderDBase.stream()
                .filter(gender -> gender.getGenderId().trim().equals(genId))
                .findAny()
                .orElse(null);
    }

    public static GenderRepository genderRepository() {
        if( gnderRepo == null) gnderRepo = new GenderRepositoryImpl();
        return gnderRepo;
    }

    @Override
    public Gender create(Gender gnder) {
        this.gnderDBase.add(gnder);
        return gnder;
    }

    @Override
    public Gender read(String gnderId) {
        Gender gnder = sourceGendr(gnderId);
        return gnder;
    }

    @Override
    public Gender update(Gender gnder) {
        Gender delete = sourceGendr(gnder.getGenderId());
        if (delete != null) {
            this.gnderDBase.remove(delete);
            return create(gnder);
        }
        return null;
    }

    @Override
    public void delete(String gnderId) {
        Gender gnder = sourceGendr(gnderId);
        if (gnder != null) this.gnderDBase.remove(gnder);
    }

    @Override
    public Set<Gender> getAll() {
        return this.gnderDBase;
    }
}
