package com.greenleafcommerce.admin.controller;

import com.greenleafcommerce.admin.model.request.CreateAdminRequest;
import com.greenleafcommerce.admin.model.response.CreateAdminResponse;
import com.greenleafcommerce.admin.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    //always prefer constructor auto-wiring
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateAdminResponse> create(@RequestBody CreateAdminRequest createAdminRequest){

        CreateAdminResponse createAdminResponse = adminService.create(createAdminRequest);
        return new ResponseEntity<>(createAdminResponse, HttpStatus.CREATED);
    }
}
