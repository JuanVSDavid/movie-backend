package co.edu.ucompensar.api.common;

@FunctionalInterface
public interface ResponseMapper<D, R> {
    R toResponse(D d);
}
