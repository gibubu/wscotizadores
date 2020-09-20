package com.estructura.cotizadores.configurations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.util.Properties;

import static java.util.Collections.singletonMap;
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = {"com.api.BonosAgentes.dao.Impl","com.api.BonosAgentes.dao"}
)
@EnableTransactionManagement
public class PrimaryDSConfig {
	@Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final EntityManagerFactoryBuilder builder,
                                                                            final DataSource dataSource) {
			
		LocalContainerEntityManagerFactoryBean emfBean = builder
                .dataSource(dataSource)
                .packages("com.api.BonosAgentes.models")
                .persistenceUnit("midas")
                .properties(singletonMap("hibernate.hbm2ddl.auto", ""))
                .properties(singletonMap("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect"))
                .build();
		emfBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emfBean;
    }

    Properties additionalJpaProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "");
        properties.setProperty("hibernate.proc.param_null_passing", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory")
                                                                      EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
