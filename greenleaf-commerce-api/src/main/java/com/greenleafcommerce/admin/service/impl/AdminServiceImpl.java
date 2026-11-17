package com.greenleafcommerce.admin.service.impl;

import com.greenleafcommerce.admin.entity.Admin;
import com.greenleafcommerce.admin.mapper.AdminMapper;
import com.greenleafcommerce.admin.model.request.CreateAdminRequest;
import com.greenleafcommerce.admin.model.response.CreateAdminResponse;
import com.greenleafcommerce.admin.repository.AdminRepository;
import com.greenleafcommerce.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    private AdminRepository adminRepository;
    private AdminMapper adminMapper;

    public AdminServiceImpl(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    @Override
    public CreateAdminResponse create(CreateAdminRequest createAdminRequest) {

        Optional<Admin> optAdmin = adminRepository.findByUsername(createAdminRequest.username());

        if(optAdmin.isPresent()){
            log.error("Admin with name " + createAdminRequest.username() + "already present");
            return null;
        }

        Admin admin = adminRepository.save(adminMapper.modelToEntity(createAdminRequest));
        log.info("Saved new admin into DB");
        return adminMapper.entityToModel(admin);
    }
}
