package os.expert.sample;

import java.util.List;

public record Goal(String title, String description, List<Task> tasks) {
}
