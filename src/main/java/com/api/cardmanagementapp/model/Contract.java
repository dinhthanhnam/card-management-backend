package com.api.cardmanagementapp.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Contract {
    private String contractNumber;
    private String contractType;
    private List<Contract> subContracts;
}
