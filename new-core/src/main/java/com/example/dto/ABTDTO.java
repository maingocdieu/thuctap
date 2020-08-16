package com.example.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ABTDTO<T> implements Serializable {

    private static final long serialVersionUID = 827498336051493850L;
    private List<T> listResult = new ArrayList<>();
    private int page = 1;
    private int maxPageItems = 2;
    private int totalItems = 0;
    private int totalPages=0;
    private String tableId = "tableList";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxPageItems() {
        return maxPageItems;
    }

    public void setMaxPageItems(int maxPageItems) {
        this.maxPageItems = maxPageItems;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}
