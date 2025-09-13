package co.edu.ucompensar.jpa.repository;

import co.edu.ucompensar.jpa.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieEntityRepository extends JpaRepository<MovieEntity, Long> {
    @Query("SELECT m FROM MovieEntity m WHERE m.releaseDate <= CURRENT_DATE ORDER BY m.id DESC")
    Page<MovieEntity> findNowPlaying(Pageable pageable);

    @Query("SELECT m FROM MovieEntity m ORDER BY m.voteAverage DESC, m.id DESC")
    Page<MovieEntity> findTopRated(Pageable pageable);

    @Query("SELECT m FROM MovieEntity m WHERE m.releaseDate > CURRENT_DATE ORDER BY m.id DESC")
    Page<MovieEntity> findUpcoming(Pageable pageable);

    @Query("SELECT m FROM MovieEntity m ORDER BY m.popularity DESC, m.id DESC")
    Page<MovieEntity> findPopular(Pageable pageable);
}
