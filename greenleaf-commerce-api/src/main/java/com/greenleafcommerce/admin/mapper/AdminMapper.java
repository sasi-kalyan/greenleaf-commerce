package com.greenleafcommerce.admin.mapper;

import com.greenleafcommerce.admin.entity.Admin;
import com.greenleafcommerce.admin.model.request.CreateAdminRequest;
import com.greenleafcommerce.admin.model.response.CreateAdminResponse;
import com.greenleafcommerce.common.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AdminMapper {

    public Admin modelToEntity(CreateAdminRequest createAdminRequest){

        return new Admin().builder()
                .username(createAdminRequest.username())
                .password(createAdminRequest.password())
                .role(Role.ADMIN)
                .active(true)                            // admin active by default
                .createdAt(LocalDateTime.now())
                .build();
    }

    public CreateAdminResponse entityToModel(Admin admin){

        return new CreateAdminResponse().builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                .createAt(admin.getCreatedAt())
                .build();
    }
}
