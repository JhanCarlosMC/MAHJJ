package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
public class ProfileDto implements Serializable {
    
    private Long id;
    private String image;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
