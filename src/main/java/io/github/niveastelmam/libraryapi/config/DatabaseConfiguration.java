package io.github.niveastelmam.libraryapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driver;

    /**
     * configuracao Hikary
     * https://github.com/brettwooldridge/HikariCP
     * @return
     */
    @Bean
    public DataSource hikariDataSource(){

        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);

        config.setMaximumPoolSize(10); // maximum number of connections allowed
        config.setMinimumIdle(1); // initial pool size
        config.setPoolName("library-db-pool");
        config.setMaxLifetime(600000); // 600 thousand ms (10 minutes)
        config.setConnectionTimeout(100000); // timeout to get a connection
        config.setConnectionTestQuery("select 1"); // test query

        return new HikariDataSource(config);
    }
}
