package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Part;

@Repository
public interface PartsRepository extends JpaRepository<Part, Long> {

    int countByPartName(String partName);
}
