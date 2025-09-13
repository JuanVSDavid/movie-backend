package co.edu.ucompensar.jpa.adapter;

import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.MovieEntity;
import co.edu.ucompensar.jpa.repository.MovieEntityRepository;
import co.edu.ucompensar.model.movie.Movie;
import co.edu.ucompensar.model.movie.gateways.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieAdapter implements MovieRepository {
    private final DomainEntityMapper<Movie, MovieEntity> movieMapper;
    private final MovieEntityRepository movieEntityRepository;

    @Override
    public Movie create(Movie movie) {
        var entity = movieMapper.toEntity(movie);
        var entitySaved = movieEntityRepository.save(entity);
        return movie.toBuilder().id(entitySaved.getId()).build();
    }

    @Override
    public Movie modify(Movie movie) {
        return null;
    }

    @Override
    public Movie delete(Movie movie) {
        return null;
    }

//    @Override
//    public Page<Movie> findAll(Pageable pageable) {
//        return movieEntityRepository.findAll(pageable)
//                .map(movieMapper::toDomain);
//    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieEntityRepository.findById(id)
                .map(movieMapper::toDomain);
    }

    @Override
    public co.edu.ucompensar.model.common.Page<Movie> findNowPlaying(
            co.edu.ucompensar.model.common.Pageable pageable) {

        var springPageable = PageRequest.of(pageable.pageNumber(), pageable.pageSize());

        org.springframework.data.domain.Page<MovieEntity> springPage =
                movieEntityRepository.findNowPlaying(springPageable);

        var movies = springPage.getContent()
                .stream()
                .map(movieMapper::toDomain)
                .toList();

        return new co.edu.ucompensar.model.common.Page<>(
                movies,
                springPage.getNumber(),
                springPage.getSize(),
                springPage.getTotalElements()
        );
    }

    @Override
    public co.edu.ucompensar.model.common.Page<Movie> findTopRated(
            co.edu.ucompensar.model.common.Pageable pageable) {

        var springPageable = PageRequest.of(pageable.pageNumber(), pageable.pageSize());

        org.springframework.data.domain.Page<MovieEntity> springPage =
                movieEntityRepository.findTopRated(springPageable);

        var movies = springPage.getContent()
                .stream()
                .map(movieMapper::toDomain)
                .toList();

        return new co.edu.ucompensar.model.common.Page<>(
                movies,
                springPage.getNumber(),
                springPage.getSize(),
                springPage.getTotalElements()
        );
    }

    @Override
    public co.edu.ucompensar.model.common.Page<Movie> findUpcoming(
            co.edu.ucompensar.model.common.Pageable pageable) {

        var springPageable = PageRequest.of(pageable.pageNumber(), pageable.pageSize());

        org.springframework.data.domain.Page<MovieEntity> springPage =
                movieEntityRepository.findUpcoming(springPageable);

        var movies = springPage.getContent()
                .stream()
                .map(movieMapper::toDomain)
                .toList();

        return new co.edu.ucompensar.model.common.Page<>(
                movies,
                springPage.getNumber(),
                springPage.getSize(),
                springPage.getTotalElements()
        );
    }

    @Override
    public co.edu.ucompensar.model.common.Page<Movie> findPopular(
            co.edu.ucompensar.model.common.Pageable pageable) {

        var springPageable = PageRequest.of(pageable.pageNumber(), pageable.pageSize());

        org.springframework.data.domain.Page<MovieEntity> springPage =
                movieEntityRepository.findPopular(springPageable);

        var movies = springPage.getContent()
                .stream()
                .map(movieMapper::toDomain)
                .toList();

        return new co.edu.ucompensar.model.common.Page<>(
                movies,
                springPage.getNumber(),
                springPage.getSize(),
                springPage.getTotalElements()
        );
    }
}
