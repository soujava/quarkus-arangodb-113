package os.expert.sample;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Logger;

@Path("/goals")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
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
    public List<Goal> goals(@QueryParam("page") @DefaultValue("1") int page,
                            @QueryParam("size") @DefaultValue("10") int size) {
        LOGGER.info("Listing goals, page: " + page + ", size: " + size);
        return goalService.findGoals(page, size);
    }

    @POST
    public Goal create(Goal goal) {
        LOGGER.info("Creating a goal: " + goal);
        return goalService.save(goal);
    }

    @GET
    @Path("{id}")
    public Goal findById(@PathParam("id") String id) {
        LOGGER.info("Finding a goal by id: " + id);
        return goalService.findById(id).orElseThrow(() -> new WebApplicationException("Goal not found with id: " + id,
                Response.Status.NOT_FOUND));
    }
}
