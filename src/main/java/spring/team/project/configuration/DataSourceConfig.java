package spring.team.project.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	@Bean
	public DataSource dataSource() {
		String username = "admin";
		String password = "usamo123";
		String jdbcUrl = "jdbc:mysql://database.cngayfnz33zb.us-east-2.rds.amazonaws.com:3306/sys";
		String driverClass = "com.mysql.cj.jdbc.Driver";
		
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
		dataSourceBuilder.url(jdbcUrl);
		dataSourceBuilder.driverClassName(driverClass);
		return dataSourceBuilder.build();
	}
}
