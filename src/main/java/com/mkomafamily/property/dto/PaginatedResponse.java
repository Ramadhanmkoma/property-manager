package com.mkomafamily.property.dto;

import java.util.List;

public class PaginatedResponse<T> {
    private long totalElements;
    private int currentPage;
    private int totalPage;
    private List<T> content;

    public PaginatedResponse(long totalElements, int currentPage, int totalPage, List<T> content) {
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.content = content;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    
}
