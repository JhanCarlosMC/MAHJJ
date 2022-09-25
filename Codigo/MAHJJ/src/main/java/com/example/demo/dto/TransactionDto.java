package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionDto implements Serializable {
    
    private Long id;
    private String concept;
    private float amount;
    private UserDto user;
    private EnterpriseDto enterprise;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
