package com.greenleafcommerce.common;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "greenleaf.commerce")
public record GreenLeafCommerceProps(String username, String password) {

}
