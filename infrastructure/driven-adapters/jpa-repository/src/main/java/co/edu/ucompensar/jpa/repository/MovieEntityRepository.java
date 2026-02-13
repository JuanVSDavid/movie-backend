package co.edu.ucompensar.jpa.repository;

import co.edu.ucompensar.jpa.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MovieEntityRepository extends JpaRepository<MovieEntity, Long> {

    Page<MovieEntity> findByOrderByVoteAverageDesc(Pageable pageable);

    Page<MovieEntity> findByOrderByPopularityDesc(Pageable pageable);

    @Query("SELECT m FROM MovieEntity m WHERE m.releaseDate > :date")
    Page<MovieEntity> findUpcoming(@Param("date") LocalDate date, Pageable pageable);

    @Query("SELECT m FROM MovieEntity m WHERE m.releaseDate BETWEEN :startDate AND :endDate")
    Page<MovieEntity> findNowPlaying(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);
}