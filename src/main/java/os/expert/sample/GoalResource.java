package os.expert.sample;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;
import java.util.logging.Logger;

@Path("/goals")
public class GoalResource {

    private static final Logger LOGGER = Logger.getLogger(GoalResource.class.getName());

    private final GoalService goalService;

    @Inject
    public GoalResource(GoalService goalService) {
        this.goalService = goalService;
    }

    @Deprecated
    GoalResource() {
        this(null);
    }

    @GET
    public List<Goal> goals(@QueryParam("page") int page,@QueryParam("size") int size) {
        LOGGER.info("Listing goals, page: " + page + ", size: " + size);
        return goalService.findGoals(page, size);
    }

    @PUT
    public Goal create(Goal goal) {
        LOGGER.info("Creating a goal: " + goal);
        return goalService.save(goal);
    }
}
