package co.edu.ucompensar.model.common;

import java.util.List;

/**
 * @param content
 * @param pageNumber
 * @param pageSize
 * @param totalElements
 */ 
public record Page<T>(
        List<T> content,
        int pageNumber,
        int pageSize,
        long totalElements
) {
    public Page {
        if (pageNumber < 0) throw new IllegalArgumentException("Page number must be >= 0");
        if (pageSize <= 0) throw new IllegalArgumentException("Page size must be > 0");
        if (totalElements < 0) throw new IllegalArgumentException("Total elements must be >= 0");
        if (content == null) throw new IllegalArgumentException("Content must not be null");
    }

    public int totalPages() {
        return (int) Math.ceil((double) totalElements / pageSize);
    }

    public boolean isFirst() {
        return pageNumber == 0;
    }

    public boolean isLast() {
        return pageNumber + 1 >= totalPages();
    }
}