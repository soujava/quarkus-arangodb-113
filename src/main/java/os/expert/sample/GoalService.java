package os.expert.sample;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.Database;
import org.eclipse.jnosql.mapping.DatabaseType;

import java.util.List;

@ApplicationScoped
public class GoalService {

    private final NewYearWishes newYearWishes;

    @Inject
    public GoalService(@Database(DatabaseType.DOCUMENT) NewYearWishes newYearWishes) {
        this.newYearWishes = newYearWishes;
    }

    @Deprecated
    GoalService() {
        this(null);
    }

    public List<Goal> findGoals(int page, int size) {
        return null;
    }

    public Goal save(Goal goal) {
        return newYearWishes.save(goal);
    }
}
