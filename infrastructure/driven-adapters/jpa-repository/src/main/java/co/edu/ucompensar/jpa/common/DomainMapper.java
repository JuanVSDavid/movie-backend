package co.edu.ucompensar.jpa.common;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FunctionalInterface
public interface DomainMapper<D, E> {
    D toDomain(E e);
    default Collection<D> toDomain(Collection<E> e, Supplier<Collection<D>> supplier){
        return e.stream().map(this::toDomain).collect(Collectors.toCollection(supplier));
    }
}
