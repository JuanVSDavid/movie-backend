package co.edu.ucompensar.jpa.common;

public interface DomainEntityMapper<D, E> {
    E toEntity(D d);
    D toDomain(E e);
}
