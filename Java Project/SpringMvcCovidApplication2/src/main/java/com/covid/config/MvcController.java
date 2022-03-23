package com.covid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.covid.dao.CovidDao;
import com.covid.dao.CovidDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.covid.dao", "com.covid.controller"})
public class MvcController {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");

		return vr;
	}

	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost/postgres");
		ds.setUsername("postgres");
		ds.setPassword("Juned@56");

		return ds;
	}

	@Bean
	public CovidDao getCovidDao() {
		return new CovidDaoImpl(getDataSource());
	}
	
}
