package com.greenleafcommerce.admin.service;

import com.greenleafcommerce.admin.model.request.CreateAdminRequest;
import com.greenleafcommerce.admin.model.response.CreateAdminResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface AdminService extends UserDetailsService {
    CreateAdminResponse create(CreateAdminRequest createAdminRequest);
}
