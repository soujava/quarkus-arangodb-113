package os.expert.sample;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.List;

@JsonbPropertyOrder({"id", "title", "description", "priority", "tasks"})
@Entity
public record Goal(
        @Id @JsonbProperty("id") String id,
        @JsonbProperty("title") @Column String title,
        @JsonbProperty("description") @Column String description,
        @JsonbProperty("priority") @Column int priority,
        @JsonbProperty("tasks") @Column List<String> tasks) {

}
