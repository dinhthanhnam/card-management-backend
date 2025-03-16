package com.api.cardmanagementapp.model;

import lombok.Data;

import java.util.List;

@Data
public class PagedClientResponse {
    private List<Client> clients;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}
