package co.edu.ucompensar.api.model.mapper;

import co.edu.ucompensar.api.common.ResponseMapper;
import co.edu.ucompensar.api.model.response.MoviesResponse;
import co.edu.ucompensar.api.model.response.PageResponse;
import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.movie.Movie;
import org.springframework.stereotype.Component;

@Component
public class PageResponseMapper implements ResponseMapper<Page<MoviesResponse>, PageResponse> {

    @Override
    public PageResponse toResponse(Page<MoviesResponse> moviesResponsePage) {
        return PageResponse.builder()
                .page(moviesResponsePage.pageNumber())
                .results(moviesResponsePage.content())
                .totalPages(moviesResponsePage.totalPages())
                .totalResults(moviesResponsePage.totalElements())
                .build();
    }
}
