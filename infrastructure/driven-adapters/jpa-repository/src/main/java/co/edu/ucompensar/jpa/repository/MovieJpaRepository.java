package co.edu.ucompensar.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MovieJpaRepository extends JpaRepository<MovieData, Long> {

    @Query("SELECT m FROM MovieData m WHERE m.status = 'Released' AND m.releaseDate BETWEEN :startDate AND :endDate")
    Page<MovieData> findNowPlaying(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);
    Page<MovieData> findByOrderByVoteAverageDesc(Pageable pageable);

    @Query("SELECT m FROM MovieData m WHERE m.releaseDate > :currentDate")
    Page<MovieData> findUpcoming(@Param("currentDate") LocalDate currentDate, Pageable pageable);
    Page<MovieData> findByOrderByPopularityDesc(Pageable pageable);

}