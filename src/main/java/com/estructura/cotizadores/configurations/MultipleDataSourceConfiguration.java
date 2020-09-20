package com.estructura.cotizadores.configurations;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.zaxxer.hikari.HikariDataSource;

//@Configuration
//public class MultipleDataSourceConfiguration {
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource.primary")
//	public JndiPropertyHolder primary() {
//		return new JndiPropertyHolder();
//	}
//
//	
//	@Bean
//	@Primary
//	public DataSource dataSource() {
//		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//		DataSource dataSource = dataSourceLookup.getDataSource(primary()
//				.getJndiName());
//		return dataSource;
//	}
//
//
//	@Bean
//	@ConfigurationProperties(prefix = "oauth.datasource.secondary")
//	public JndiPropertyHolder secondary() {
//		return new JndiPropertyHolder();
//	}
//
//	@Bean(name = "secondaryDB")
//	public DataSource secondaryDataSource() {
//		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//		DataSource dataSource = dataSourceLookup.getDataSource(secondary()
//				.getJndiName());
//		return dataSource;
//	}
//	
//	@Bean
//	@ConfigurationProperties(prefix = "mizar.datasource.third")
//    public JndiPropertyHolder third() {
//        return new JndiPropertyHolder();
//    }
//	 
//	@Bean(name = "thirdDB")
//    public DataSource thirdDataSource() {
//        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//        //DataSource dataSource = dataSourceLookup.getDataSource(third().getJndiName());
//        DataSource dataSource = dataSourceLookup.getDataSource("jdbc/MizarDataSource");
//        return dataSource;
//    }
//
////	@Bean(name = "thirdEntityManagerFactory")
////	public LocalContainerEntityManagerFactoryBean mizarEntityManagerFactory(EntityManagerFactoryBuilder builder,
////			                                                                @Qualifier("thirdDB") DataSource ds) {
////		return builder.dataSource(ds).packages("com.api.BonosAgentes.models.mizar").persistenceUnit("mizar").build();
////	}
//
//	private static class JndiPropertyHolder {
//		private String jndiName;
//
//		public String getJndiName() {
//			return jndiName;
//		}
//
//		public void setJndiName(String jndiName) {
//			this.jndiName = jndiName;
//		}
//	}
//
// 
//
//	
//}
/**
 * configuracion datasource local
 * comentar codigo para PRD y descomentar codigo de arriba para PRD.
 * 
 */
@Configuration
public class MultipleDataSourceConfiguration{
	@Bean
	   @Primary
	   @ConfigurationProperties(prefix="spring.primary-datasource")
	   public DataSource dataSourceAgReports() throws IllegalArgumentException, NamingException {
	   	HikariDataSource hiDataSource = (HikariDataSource) DataSourceBuilder.create().build();
	       return hiDataSource;
	   }

	   @Bean(name = "secondaryDB")
	   @ConfigurationProperties(prefix="spring.second-datasource")
	   public DataSource secondDataSource() {
	       HikariDataSource hiDataSource = (HikariDataSource) DataSourceBuilder.create().build();
	       return hiDataSource;
	   }
}