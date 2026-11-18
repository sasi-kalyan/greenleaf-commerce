package com.greenleafcommerce;

import com.greenleafcommerce.admin.entity.Admin;
import com.greenleafcommerce.admin.repository.AdminRepository;
import com.greenleafcommerce.common.GreenLeafCommerceProps;
import com.greenleafcommerce.common.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = "com.greenleafcommerce")
@ConfigurationPropertiesScan(basePackages = "com.greenleafcommerce")
public class GreenleafCommerceApplication implements CommandLineRunner {

	private final AdminRepository adminRepository;
	private final GreenLeafCommerceProps props;
	private final PasswordEncoder passwordEncoder;

	private final Logger log = LoggerFactory.getLogger(GreenleafCommerceApplication.class);

	public GreenleafCommerceApplication(AdminRepository adminRepository, GreenLeafCommerceProps props, PasswordEncoder passwordEncoder) {
		this.adminRepository = adminRepository;
        this.props = props;
        this.passwordEncoder = passwordEncoder;
    }

	public static void main(String[] args) {
		SpringApplication.run(GreenleafCommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Optional<Admin> optAdmin = adminRepository.findByUsername(props.username());

		if(!optAdmin.isPresent()) {
			Admin admin = Admin.builder()
					.username(props.username())
					.password(passwordEncoder.encode(props.password()))
					.role("ADMIN")
					.active(true)
					.createdAt(LocalDateTime.now())
					.build();

			log.info("/root admin created in database (runtime)");
			adminRepository.save(admin);
		}

		log.info("/root admin already present, skipping the creation step");
	}
}
