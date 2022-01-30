package com.op247.rest.webapi.op247webservices.payload;

import lombok.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class PagedResponse<T> {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean lastElements;
    private List<T> content;

    public PagedResponse() {
    }
    public PagedResponse(List<T> content, int page, int size, long totalElements, int totalPages, boolean lastElements) {
        setContent(content);
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.lastElements = lastElements;
    }
    public List<T> getContent() {
        return content == null ? null : new ArrayList<>(content);
    }
    public final void setContent(List<T> content) {
        if (content == null) {
            this.content = null;
        } else {
            this.content = Collections.unmodifiableList(content);
        }
    }
    public boolean isLast() {
        return lastElements;
    }
}
