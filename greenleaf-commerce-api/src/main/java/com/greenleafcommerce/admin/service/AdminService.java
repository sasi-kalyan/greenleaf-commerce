package com.greenleafcommerce.admin.service;

import com.greenleafcommerce.admin.model.request.CreateAdminRequest;
import com.greenleafcommerce.admin.model.response.CreateAdminResponse;
import org.springframework.stereotype.Service;

public interface AdminService {
    CreateAdminResponse create(CreateAdminRequest createAdminRequest);
}
