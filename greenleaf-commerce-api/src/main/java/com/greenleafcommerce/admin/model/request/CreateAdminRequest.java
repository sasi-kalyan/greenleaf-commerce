package com.greenleafcommerce.admin.model.request;

import java.time.LocalDateTime;

public record CreateAdminRequest(
     String username,
     String password
) {}
