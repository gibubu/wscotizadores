package com.estructura.cotizadores.models.oauth;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails; 
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.OrderBy;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
//
//import java.io.Serializable;
//import java.util.Collection;
//
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Table(schema = "SEGAGENTES", name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
//@Getter
//@Setter
//@EqualsAndHashCode(of = "username")
//public class User implements UserDetails, Serializable{
//	
//	private static final long serialVersionUID = 6787293535995156147L;
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id") 
//  private Long id;
//
//  @Column(name = "username")
//  private String username;
//
//  @Column(name = "password")
//  private String password;
//
//  @Column(name = "enabled")
//  private boolean enabled;
//
//  @Column(name = "ACCOUNT_EXPIRED")
//  private boolean accountExpired;
//
//  @Column(name = "ACCOUNT_LOCKED")
//  private boolean accountLocked;
//
//  @Column(name = "CREDENTIALS_EXPIRED")
//  private boolean credentialsExpired;
//
//  @ManyToMany(fetch = FetchType.LAZY)
//  @JoinTable(name = "group_members", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
//  @OrderBy
//  @JsonIgnore
//  private Collection<Groups> authorities;
//
//  @Override
//  public boolean isAccountNonExpired() {
//      return !accountExpired;
//  }
//
//  @Override
//  public boolean isAccountNonLocked() {
//      return !accountLocked;
//  }
//
//  @Override
//  public boolean isCredentialsNonExpired() {
//      return !credentialsExpired;
//  }
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return this.username;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return this.enabled;
//	}
//	
//	public Long getId(){
//		return this.id;
//	}
//	
//
//}