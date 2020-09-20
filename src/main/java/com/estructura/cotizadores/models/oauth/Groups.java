package com.estructura.cotizadores.models.oauth;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
//
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Table(schema = "SEGAGENTES", name = "groups", uniqueConstraints = {@UniqueConstraint(columnNames = {"group_name"})})
//@Getter @Setter
//@EqualsAndHashCode(of = "id")
//public class Groups implements GrantedAuthority {
//
////	private static final long serialVersionUID = 1L;
//
//	@Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id")
//  private Long id;
//
//  @Column(name = "group_name")
//  private String groupName;
//
//  @Override
//  public String getAuthority() {
//      return this.groupName;
//  }
//}
