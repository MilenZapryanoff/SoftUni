package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;

import java.util.List;
import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {
    int countByName(String name);

    int countById(Long id);

    Optional<Star> findById(Long id);

    @Query("SELECT s FROM Star s WHERE s.starType = 'RED_GIANT' AND s.observers.size = 0 order by s.lightYears")
    List<Star> findStarsByStarTypeOrderByLightYearsAsc();
}
