package com.leonardobrambilla.ecommerce.ecommerce.config;

import com.leonardobrambilla.ecommerce.ecommerce.services.PopulateService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    @Autowired
    private PopulateService populateService;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @PostConstruct
    public void init(){
        if (this.ddlAuto.equals("create"));
        this.populateService.populate();
    }
}
