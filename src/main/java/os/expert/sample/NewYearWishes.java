package os.expert.sample;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;

@Repository
public interface NewYearWishes extends BasicRepository<Goal, String> {
}
