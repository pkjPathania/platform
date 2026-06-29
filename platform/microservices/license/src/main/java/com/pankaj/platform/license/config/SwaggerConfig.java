package com.pankaj.platform.license.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI licenseOpenAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("License Service API")
                .version("v1")
                .description("OpenAPI docs for license-service"));
  }
}
