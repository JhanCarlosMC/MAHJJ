package com.example.demo.dto;

import com.example.demo.enums.Enum_RoleName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto implements Serializable {
    
    private Long id;
    private String email;
    private String name;
    private Enum_RoleName rol;
    private ProfileDto profile;
    private EnterpriseDto enterprise;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
