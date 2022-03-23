package com.covid.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.covid.model.Covid;

public class CovidDaoImpl implements CovidDao{
	@PersistenceContext
	private JdbcTemplate jdbcTemp;

	public CovidDaoImpl(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}
	public List<Covid> cvlist() {
		// TODO Auto-generated method stub
		List<Covid> list = jdbcTemp.query("SELECT location, Count(new_cases) as new_cases FROM covidinformation WHERE new_cases> 1000 GROUP BY location ORDER BY new_cases;", new RowMapper<Covid>() {

			public Covid mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Covid co = new Covid();
				co.setLocation(rs.getString("location"));
				co.setNew_cases(rs.getInt("new_cases"));
				
				return co;
			}
			
		});
		return list;
	}
}
