package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import com.example.demo.CustomAuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

     private final OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService;

    public SecurityConfiguration(OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService) {
        this.oidcUserService = oidcUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/oauth2/**", "/login/**" ).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .defaultSuccessUrl( "/home" );


                /*
                .authorizeRequests()
                .antMatchers( "/oauth2/**", "/login/**" ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(CustomAuthenticationSuccessHandler());
                 */




                /*
                .authorizeRequests()
                .antMatchers( "/oauth2/**", "/login/**" ).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .defaultSuccessUrl( "/home" );
                 */


                //.userInfoEndpoint()
                //.oidcUserService(oidcUserService);

                //.successHandler( new OAuth2AuthenticationSuccessHandler());
    }
}
