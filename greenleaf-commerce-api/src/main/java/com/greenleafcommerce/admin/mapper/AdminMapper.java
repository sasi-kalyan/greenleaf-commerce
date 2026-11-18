package com.greenleafcommerce.admin.mapper;

import com.greenleafcommerce.admin.entity.Admin;
import com.greenleafcommerce.admin.model.request.CreateAdminRequest;
import com.greenleafcommerce.admin.model.response.CreateAdminResponse;
import com.greenleafcommerce.common.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AdminMapper {

    private PasswordEncoder passwordEncoder;

    public AdminMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Admin modelToEntity(CreateAdminRequest createAdminRequest){

        return new Admin().builder()
                .username(createAdminRequest.username())
                .password(passwordEncoder.encode(createAdminRequest.password()))
                .role("ADMIN")
                .active(true)                            // admin active by default
                .createdAt(LocalDateTime.now())
                .build();
    }

    public CreateAdminResponse entityToModel(Admin admin){

        return new CreateAdminResponse().builder()
                .username(admin.getUsername())
                .createAt(admin.getCreatedAt())
                .build();
    }
}
