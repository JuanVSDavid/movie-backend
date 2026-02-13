package co.edu.ucompensar.jpa.common;

import co.edu.ucompensar.model.common.Page;
import co.edu.ucompensar.model.common.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class PaginationMapper {

    private PaginationMapper() {}

    public static org.springframework.data.domain.Pageable toSpringPageable(Pageable domainPageable) {
        return PageRequest.of(
                domainPageable.pageNumber(),
                domainPageable.pageSize()
        );
    }

    public static <D, E> Page<D> toDomainPage(org.springframework.data.domain.Page<E> springPage, Function<E, D> mapper) {
        List<D> content = springPage.getContent().stream()
                .map(mapper)
                .collect(Collectors.toList());

        return new Page<>(
                content,
                springPage.getNumber(),
                springPage.getSize(),
                springPage.getTotalElements()
        );
    }
}