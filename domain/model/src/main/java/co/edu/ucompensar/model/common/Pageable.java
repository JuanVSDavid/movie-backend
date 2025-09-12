package co.edu.ucompensar.model.common;

/**
 * @param pageNumber
 * @param pageSize
 */
public record Pageable(int pageNumber, int pageSize) {
    public Pageable {
        if (pageNumber < 0) throw new IllegalArgumentException("Page number must be >= 0");
        if (pageSize <= 0) throw new IllegalArgumentException("Page size must be > 0");
    }

    public int getOffset() {
        return pageNumber * pageSize;
    }
}
