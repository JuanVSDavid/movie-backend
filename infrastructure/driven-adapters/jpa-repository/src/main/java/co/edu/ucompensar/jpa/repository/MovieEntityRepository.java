package co.edu.ucompensar.jpa.repository;

import co.edu.ucompensar.jpa.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieEntityRepository extends CrudRepository<MovieEntity, Long> {
}
