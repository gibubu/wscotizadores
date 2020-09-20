package com.estructura.cotizadores.configurations.oauth.security.service;
//
//import java.util.Arrays;
//import java.util.List;
//
//import com.api.BonosAgentes.models.oauth.*;
//import com.api.BonosAgentes.repository.*;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//
//@Service(value = "userService")
//public class UserServiceImpl implements UserDetailsService{
//	public static final Logger LOG = Logger.getLogger(UserServiceImpl.class);
//
//  @Autowired
//  private UserDao userDao;
//  
//  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//      User user = userDao.findByUsername(userId);
//      if (user == null) {
//      LOG.info("Error Al obtener Usuario:"+user);
//      LOG.error(""+ new UsernameNotFoundException("Invalid username or password."));
//          throw new UsernameNotFoundException("Invalid username or password.");
//      }
//      LOG.info("USER EXITOSO:"+user.getUsername());
//      return user;
//  }
//}
