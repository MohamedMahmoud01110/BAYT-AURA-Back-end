package org.os.bayturabackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // السماح للـ Angular (الـ frontend)
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));

        // الطرق (HTTP Methods) المسموح بيها
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // السماح بالهيدرز
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // لو بتستخدم Authorization header (JWT)
        configuration.setAllowCredentials(true);

        // apply على كل الـ endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
