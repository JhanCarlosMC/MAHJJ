package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:postgresql.properties")
@EnableJpaRepositories(entityManagerFactoryRef = "postgresqlEntityManagerFactory",
        transactionManagerRef = "postgresqlTransactionManager",
        basePackages = {"com.example.demo.repository"})
public class PostgresConfiguration {

    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "postgresqlDataSource")
    @ConfigurationProperties(prefix = "postgresql.datasource")
    public DataSource customDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("postgresql.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("postgresql.datasource.url"));
        dataSource.setUsername(env.getProperty("postgresql.datasource.username"));
        dataSource.setPassword(env.getProperty("postgresql.datasource.password"));
        return dataSource;
    }

    @Primary
    @Bean(name = "postgresqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("postgresqlDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.example.demo.model")
                .properties(jpaProperties())
                .persistenceUnit("postgresql")
                .build();
    }

    @Primary
    @Bean(name = "postgresqlTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("postgresqlEntityManagerFactory") EntityManagerFactory
                                                                 entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


    private Map<String,Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.show_sql","false");
        props.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        return props;
    }

}
