package webapp.atlas.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends AbstractSecurityWebApplicationInitializer {

    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authz -> authz
                .requestMatchers("/authentication/**").permitAll()
                .requestMatchers("/h2/**").permitAll()
                .anyRequest().authenticated());
    }
}
