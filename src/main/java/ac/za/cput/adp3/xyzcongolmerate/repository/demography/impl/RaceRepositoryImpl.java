package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private Set<Race> rceDBse;
    private static RaceRepository rceRepo = null;

    private RaceRepositoryImpl() {
        this.rceDBse = new HashSet<>();
    }

    private Race findRace(String raceId) {
        return this.rceDBse.stream()
                .filter(race -> race.getRaceId().trim().equals(raceId))
                .findAny()
                .orElse(null);
    }

    public static RaceRepository getRaceRepository() {
        if (rceRepo == null) rceRepo = new RaceRepositoryImpl();
        return rceRepo;
    }

    @Override
    public Race create(Race race) {
        this.rceDBse.add(race);
        return race;
    }

    @Override
    public Race read(String raceId) {
        Race race = findRace(raceId);
        return race;
    }

    @Override
    public Race update(Race race) {
        Race del = findRace(race.getRaceId());
        if (del != null) {
            this.rceDBse.remove(del);
            return create(race);
        }
        return null;
    }

    @Override
    public void delete(String raceId) {
        Race race = findRace(raceId);
        if (race != null) this.rceDBse.remove(race);
    }

    @Override
    public Set<Race> getAll() {
        return this.rceDBse;
    }
}
