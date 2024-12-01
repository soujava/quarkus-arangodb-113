package os.expert.sample;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.List;

@Entity
public record Goal(@Id String title, @Column String description, @Column int priority, @Column List<Task> tasks) {
}
