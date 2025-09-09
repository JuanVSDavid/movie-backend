package co.edu.ucompensar.jpa.common;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public interface DomainEntityMapper<D, E> {
    E toEntity(D d);
    D toDomain(E e);

    default Collection <D> toDomain(Collection<E> e, Supplier<Collection<D>> supplier){
        return e.stream().map(this::toDomain).collect(Collectors.toCollection(supplier));
    }
    default Collection <E> toEntity(Collection<D> d, Supplier<Collection<E>> supplier){
        return d.stream().map(this::toEntity).collect(Collectors.toCollection(supplier));
    }
}
