package com.salil.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.salil.model.User;

@Component
public class EmployeeEmployerervice {
	 
	@Autowired
	@Qualifier("snowflakeJdbctemplate")
	protected NamedParameterJdbcTemplate namedJdbcTemplateSnowflake;
	
	
	
public List getAllEmployerDetails() {
		
		String query = "select * from employer_details";
		MapSqlParameterSource params = null;
		
		List<Map<String, Object>> results = namedJdbcTemplateSnowflake.queryForList(query, params);
		
		return results;
	}
	
public List getEmployerDetails(String employer_id) {
		
		String query = "select * from employer_details where employer_id = '"+employer_id+"'";
		MapSqlParameterSource params = null;
		
		List<Map<String, Object>> results = namedJdbcTemplateSnowflake.queryForList(query, params);
		
		return results;
	}

	public List getAllEmployeeEmploymentDetails() {
		
		String query = "select user_first_name,user_last_name,user_pan_no,"
				+ "employer_name, employer_address, employer_tin_no,user_employment_start_date,user_employment_end_date"
				+ " from employee_employment_details eed "
				+ " join employer_details ed on eed.employer_id=ed.employer_id";
		MapSqlParameterSource params = null;
		
		List<Map<String, Object>> results = namedJdbcTemplateSnowflake.queryForList(query, params);
		
		return results;
	}
	
public List getEmployeeEmploymentDetails(String userId) {
		
	String query = "select user_first_name,user_last_name,user_pan_no,"
			+ "employer_name, employer_address, employer_tin_no,user_employment_start_date,user_employment_end_date"
			+ " from employee_employment_details eed "
			+ " join employer_details ed on eed.employer_id=ed.employer_id"
			+ " where  user_pan_no ='"+userId+"'";

		MapSqlParameterSource params = null;
		
		List<Map<String, Object>> results = namedJdbcTemplateSnowflake.queryForList(query, params);
		
		return results;
	}
	
	
}
