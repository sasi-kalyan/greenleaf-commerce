package com.greenleafcommerce.admin.model.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdminResponse {

    private String username;
    private String password;
    private boolean active;
    private LocalDateTime createAt;
}
