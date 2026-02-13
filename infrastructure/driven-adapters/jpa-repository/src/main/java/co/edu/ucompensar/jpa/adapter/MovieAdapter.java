package co.edu.ucompensar.jpa.adapter;

import co.edu.ucompensar.jpa.entity.MovieEntity;
import co.edu.ucompensar.jpa.mapper.MovieDomainEntityMapper;
import co.edu.ucompensar.jpa.repository.MovieEntityRepository;
import co.edu.ucompensar.model.movie.gateways.MovieRepository;
import co.edu.ucompensar.model.movie.Movie;
import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MovieAdapter implements MovieRepository {

    private final MovieEntityRepository movieEntityRepository;
    private final MovieDomainEntityMapper mapper;

    @Override
    @Transactional
    public Movie create(Movie movie) {
        MovieEntity movieEntity = mapper.toEntity(movie);
        return mapper.toDomain(movieEntityRepository.save(movieEntity));
    }

    @Override
    @Transactional
    public Movie modify(Long id, Movie movie) {
        MovieEntity existingEntity = movieEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Película no encontrada con ID: " + id));

        existingEntity.setTitle(movie.getTitle());
        existingEntity.setOriginalTitle(movie.getOriginalTitle());
        existingEntity.setOverview(movie.getOverview());
        existingEntity.setReleaseDate(movie.getReleaseDate());
        existingEntity.setPosterPath(movie.getPosterPath());
        existingEntity.setBackdropPath(movie.getBackdropPath());
        existingEntity.setBudget(movie.getBudget());
        existingEntity.setRevenue(movie.getRevenue());
        existingEntity.setRuntime(movie.getRuntime());
        existingEntity.setStatus(movie.getStatus());
        existingEntity.setTagline(movie.getTagline());
        existingEntity.setVoteCount(movie.getVoteCount());
        existingEntity.setAdult(movie.getAdult());
        existingEntity.setVideo(movie.getVideo());
        existingEntity.setHomepage(movie.getHomepage());
        existingEntity.setImdbId(movie.getImdbId());
        existingEntity.setOriginalLanguage(movie.getOriginalLanguage());
        existingEntity.setVoteAverage(movie.getVoteAverage());
        existingEntity.setPopularity(movie.getPopularity());

        MovieEntity savedEntity = movieEntityRepository.save(existingEntity);

        return mapper.toDomain(savedEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        movieEntityRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Movie> findById(Long id) {
        return movieEntityRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findAll(Pageable pageable) {
        PageRequest springPageable = PageRequest.of(pageable.pageNumber(), pageable.pageSize());
        org.springframework.data.domain.Page<MovieEntity> springPage = movieEntityRepository.findAll(springPageable);
        return mapToDomainPage(springPage);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findNowPlaying(Pageable pageable) {
        PageRequest springPageable = PageRequest.of(pageable.pageNumber(), pageable.pageSize());
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusMonths(1);
        org.springframework.data.domain.Page<MovieEntity> springPage = movieEntityRepository.findNowPlaying(startDate, today, springPageable);
        return mapToDomainPage(springPage);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findTopRated(Pageable pageable) {
        PageRequest springPageable = PageRequest.of(pageable.pageNumber(), pageable.pageSize());
        org.springframework.data.domain.Page<MovieEntity> springPage = movieEntityRepository.findByOrderByVoteAverageDesc(springPageable);
        return mapToDomainPage(springPage);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findUpcoming(Pageable pageable) {
        PageRequest springPageable = PageRequest.of(pageable.pageNumber(), pageable.pageSize());
        org.springframework.data.domain.Page<MovieEntity> springPage = movieEntityRepository.findUpcoming(LocalDate.now(), springPageable);
        return mapToDomainPage(springPage);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Movie> findPopular(Pageable pageable) {
        PageRequest springPageable = PageRequest.of(pageable.pageNumber(), pageable.pageSize());
        org.springframework.data.domain.Page<MovieEntity> springPage = movieEntityRepository.findByOrderByPopularityDesc(springPageable);
        return mapToDomainPage(springPage);
    }

    private Page<Movie> mapToDomainPage(org.springframework.data.domain.Page<MovieEntity> springPage) {
        List<Movie> content = springPage.getContent()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
        return new Page<>(
                content,
                springPage.getNumber(),
                springPage.getSize(),
                springPage.getTotalElements()
        );
    }
}