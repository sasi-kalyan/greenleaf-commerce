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

import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = "com.greenleafcommerce")
@ConfigurationPropertiesScan(basePackages = "com.greenleafcommerce")
public class GreenleafCommerceApplication implements CommandLineRunner {

	private AdminRepository adminRepository;
	private GreenLeafCommerceProps props;
	private final Logger log = LoggerFactory.getLogger(GreenleafCommerceApplication.class);

	public GreenleafCommerceApplication(AdminRepository adminRepository, GreenLeafCommerceProps props) {
		this.adminRepository = adminRepository;
        this.props = props;
    }

	public static void main(String[] args) {
		SpringApplication.run(GreenleafCommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Admin admin = Admin.builder()
				.username(props.username())
				.password(props.password())
				.role(Role.valueOf(String.valueOf(Role.ADMIN)))
				.active(true)
				.createdAt(LocalDateTime.now())
				.build();

		log.info("/root admin created in database (runtime)");
		adminRepository.save(admin);
	}
}
