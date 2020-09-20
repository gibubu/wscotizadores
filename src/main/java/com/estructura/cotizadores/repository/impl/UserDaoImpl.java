package com.estructura.cotizadores.repository.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import com.api.BonosAgentes.models.oauth.User;
//import com.api.BonosAgentes.repository.UserDao;
//
//@Transactional
//@Repository
//public class UserDaoImpl implements UserDao{
//public static final Logger log = Logger.getLogger(UserDaoImpl.class);
//	
//  @Autowired
//	@PersistenceContext(unitName ="oauth")
//  private EntityManager entityManager;
//
//  @Override
//  public User findByUsername(String username) {
//
//		log.info("**************** FIND BY USERNAME - " + username + " ****************");
//		User user = null;
//		try{
//			 Query qry = entityManager.createQuery("SELECT u FROM User u" +
//		                " " +
//		                "WHERE u.username = :username");
//		        qry.setParameter("username" , username);
//		        
//		        user = (User) qry.getSingleResult();
//		      
//		}catch(Exception e){
//			log.error("OCURRIO UN ERROR AL OBTENER INFO USER#########:"+e.getCause());
//		}
//     
//      return user;
//  }
//
//  @Override
//  public User findByUsernameAndPassword(String username, String password) {
//  			
//      Query qry = entityManager.createQuery("SELECT DISTINCT user FROM User user " +
//              "INNER JOIN FETCH user.authorities AS authorities " +
//              "WHERE user.username = :username and user.password = :password ");
//      qry.setParameter("username" , username);
//      qry.setParameter("password" , password);
//      return (User) qry.getSingleResult();
//  }
//
//  @Override
//  public List<User> findAll() {
//      return null;
//  }
//}
