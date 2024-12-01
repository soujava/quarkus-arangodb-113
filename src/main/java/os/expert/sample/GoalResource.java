package os.expert.sample;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;
import java.util.logging.Logger;

@Path("/goals")
public class GoalResource {

    private static final Logger LOGGER = Logger.getLogger(GoalResource.class.getName());

    @GET
    public List<Goal> goals(@QueryParam("page") int page,@QueryParam("size") int size) {
        LOGGER.info("Listing goals, page: " + page + ", size: " + size);
        return List.of(new Goal("Learn Quarkus", "Learn Quarkus", List.of(new Task("Create a new project", "Create a new project"))));
    }

    @PUT
    public Goal create(Goal goal) {
        LOGGER.info("Creating a goal: " + goal);
        return goal;
    }
}
