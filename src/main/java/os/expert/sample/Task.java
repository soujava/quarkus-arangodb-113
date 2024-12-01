package os.expert.sample;

import jakarta.nosql.Column;
import jakarta.nosql.Embeddable;

@Embeddable(Embeddable.EmbeddableType.GROUPING)
public record Task(@Column String title, @Column String description) {
}
