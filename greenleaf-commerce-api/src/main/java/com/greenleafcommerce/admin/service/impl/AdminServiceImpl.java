package com.greenleafcommerce.admin.service.impl;

import com.greenleafcommerce.admin.entity.Admin;
import com.greenleafcommerce.admin.mapper.AdminMapper;
import com.greenleafcommerce.admin.model.request.CreateAdminRequest;
import com.greenleafcommerce.admin.model.response.CreateAdminResponse;
import com.greenleafcommerce.admin.repository.AdminRepository;
import com.greenleafcommerce.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

        log.info("Saved admin into DB");
        return adminMapper.entityToModel(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("inside loadUserByUsername invoked by --SpringSecurity");
        log.info("username received --" + username);

        Optional<Admin> optAdmin = adminRepository.findByUsername(username);
        log.info("username found -- " + optAdmin.isPresent());

        if(optAdmin.isPresent()){
            Admin admin = optAdmin.get();
            String role = admin.getRole();
            log.info("role saved in db -- " + role);
            String normalizedRole = role != null && role.startsWith("ROLE_") ? role.substring(5) : role;
            log.info("normalizedRole -- " + normalizedRole);
            UserDetails userDetails =  User.builder()
                    .username(admin.getUsername())
                    .password(admin.getPassword())
                    .roles(normalizedRole)
                    .build();

            log.info("built object -- " + userDetails.toString());
            return userDetails;
        }

        throw new UsernameNotFoundException("USER NOT FOUND IN DB");
    }
}
