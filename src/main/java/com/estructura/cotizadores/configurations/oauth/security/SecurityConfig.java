package com.estructura.cotizadores.configurations.oauth.security;
//
//import org.springframework.beans.factory.annotation.Autowired; 
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.approval.ApprovalStore;
//import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
//import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
//import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  @Resource(name = "userService")
//  private UserDetailsService userDetailsService;
//
//  @Override
//  @Bean
//  public AuthenticationManager authenticationManagerBean() throws Exception {
//      return super.authenticationManagerBean();
//  }
//
//  @Autowired
//  public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//      auth.userDetailsService(userDetailsService)
//              .passwordEncoder(encoder());
//  }
//
//  @Bean
//  public BCryptPasswordEncoder encoder() {
//      return new BCryptPasswordEncoder();
//  }
//  
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//
//  	  http.cors()
//        .and()
//        .csrf()
//        .disable()
//        .sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and()
//        .anonymous().disable()
//        .authorizeRequests()
//        .requestMatchers(EndpointRequest.to("swagger-ui.html", "info"))
//        .permitAll()
//        .antMatchers("/wsBonosAgentes/**")
//        .permitAll()
//        .antMatchers("/api-docs/**")
//        .permitAll()
//        .and()
//        .httpBasic();     
//  }
//}