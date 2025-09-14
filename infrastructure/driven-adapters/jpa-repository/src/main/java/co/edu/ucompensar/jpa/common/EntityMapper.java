package co.edu.ucompensar.jpa.common;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FunctionalInterface
public interface EntityMapper<D, E> {
    E toEntity(D d);
    default Collection<E> toEntity(Collection<D> d, Supplier<Collection<E>> supplier){
        return d.stream().map(this::toEntity).collect(Collectors.toCollection(supplier));
    }
}
