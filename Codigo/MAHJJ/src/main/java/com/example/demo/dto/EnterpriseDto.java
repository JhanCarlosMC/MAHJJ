package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
public class EnterpriseDto implements Serializable {
    
    private Long id;
    private String name;
    private String document;
    private String  phone;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
