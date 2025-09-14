package co.edu.ucompensar.jpa.adapter;

import co.edu.ucompensar.jpa.common.PaginationMapper;
import co.edu.ucompensar.jpa.mapper.MovieDomainEntityMapper;
import co.edu.ucompensar.jpa.repository.MovieEntityRepository;
import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import co.edu.ucompensar.model.movie.entity.Movie;
import co.edu.ucompensar.model.movie.gateways.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieAdapter implements MovieRepository {

    private final MovieDomainEntityMapper mapper;
    private final MovieEntityRepository movieRepository;

    @Override
    @Transactional
    public Movie create(Movie movie) {
        var entity = mapper.toEntity(movie);
        var savedEntity = movieRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    @Transactional
    public Movie modify(Long id, Movie movie) {
        return movieRepository.findById(id).map(existingEntity -> {
            var updatedEntityData = mapper.toEntity(movie);
            updatedEntityData.setId(id);
            var savedEntity = movieRepository.save(updatedEntityData);
            return mapper.toDomain(savedEntity);
        }).orElseThrow(() -> new RuntimeException("Película no encontrada con ID: " + id));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Película no encontrada con ID: " + id);
        }
        movieRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findAll(Pageable pageable) {
        var springPageable = PaginationMapper.toSpringPageable(pageable);
        var springPage = movieRepository.findAll(springPageable);
        return PaginationMapper.toDomainPage(springPage, mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findNowPlaying(Pageable pageable) {
        var springPageable = PaginationMapper.toSpringPageable(pageable);
        var endDate = LocalDate.now();
        var startDate = endDate.minusMonths(1);
        var springPage = movieRepository.findNowPlaying(startDate, endDate, springPageable);
        return PaginationMapper.toDomainPage(springPage, mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findTopRated(Pageable pageable) {
        var springPageable = PaginationMapper.toSpringPageable(pageable);
        var springPage = movieRepository.findByOrderByVoteAverageDesc(springPageable);
        return PaginationMapper.toDomainPage(springPage, mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findUpcoming(Pageable pageable) {
        var springPageable = PaginationMapper.toSpringPageable(pageable);
        var springPage = movieRepository.findUpcoming(LocalDate.now(), springPageable);
        return PaginationMapper.toDomainPage(springPage, mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findPopular(Pageable pageable) {
        var springPageable = PaginationMapper.toSpringPageable(pageable);
        var springPage = movieRepository.findByOrderByPopularityDesc(springPageable);
        return PaginationMapper.toDomainPage(springPage, mapper::toDomain);
    }
}