package com.github.lorellw.socialNetworkRest.config;

import com.github.lorellw.socialNetworkRest.entities.User;
import com.github.lorellw.socialNetworkRest.repositories.UserDetailsRepository;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.time.LocalDateTime;


//todo: Cut a deprecated code
@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfigurator extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/","/login**","/error**","/js/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserDetailsRepository repository) {
        return map -> {
            String id = (String) map.get("sub");
            User user = repository.findById(id).orElseGet(() -> {
                User newUser = new User();

                newUser.setId(id);
                newUser.setName((String) map.get("name"));
                newUser.setEmail((String) map.get("email"));
                newUser.setUserpic((String) map.get("picture"));
                newUser.setGender((String) map.get("gender"));
                newUser.setLocale((String) map.get("locale"));

                return newUser;
            });
            user.setLastVisit(LocalDateTime.now());
            return repository.save(user);

        };
    }
}
