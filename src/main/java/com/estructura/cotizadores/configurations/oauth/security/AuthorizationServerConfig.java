package com.estructura.cotizadores.configurations.oauth.security;

//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//
//  @Autowired @Qualifier("secondaryDB")
//  private DataSource dataSource;
//
//  @Autowired  @Qualifier("authenticationManagerBean")
//  private AuthenticationManager authenticationManager;
//
//  
//  @Override
//  public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
//
//      configurer.jdbc(dataSource);
//  }
//  
//  @Bean @Autowired
//  public TokenStore tokenStore() {
//      return new JdbcTokenStore(dataSource);
//  }
//
//  @Override
//  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//      endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).reuseRefreshTokens(true);//.userApprovalHandler(userApprovalHandler).authenticationManager(authenticationManager);
//  }
//}
