package com.dell.tsp.admin.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dell.tsp.admin.DTO.AdminDTO;
import com.dell.tsp.admin.entity.AdminEntity;
import com.dell.tsp.admin.model.Subscriber;
import com.dell.tsp.admin.repository.AdminRepository;

@Repository
public class Transction {


	JdbcTemplate jdbcTemplate;
	
	
	/*
	 * @Autowired AdminRepository adminRepository;
	 */
	@Autowired
	public Transction(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}



	public class SubscriberMapper implements RowMapper<Subscriber> {

		@Override
		public Subscriber mapRow(ResultSet rs, int rowNum) throws SQLException {
			Subscriber subscriber = new Subscriber();
			subscriber.setSubscriberId(rs.getLong("subscriber_id"));
			subscriber.setFirstName(rs.getString("first_name"));
			subscriber.setLastName(rs.getString("last_name"));
			subscriber.setEmail(rs.getString("email_address"));
			subscriber.setMobileNo(rs.getLong("mobile_no"));
			subscriber.setAddress(rs.getString("address"));
			subscriber.setAdharNo(rs.getString("aadhar_no"));
			return subscriber;
		}

	}

	public List<Subscriber> findAll() {
		return jdbcTemplate.query("select * from Subscribers", new SubscriberMapper());
	}

	public Subscriber findById(int id) {
		return jdbcTemplate.queryForObject("select * from Subscribers where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Subscriber>(Subscriber.class));
	}

	public Subscriber findByMobileNo(long mobile_no) {
		return jdbcTemplate.queryForObject("select * from Subscribers where mobile_no=?", new Object[] { mobile_no },
				new BeanPropertyRowMapper<Subscriber>(Subscriber.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from Subscriber where id=?", new Object[] { id });
	}



	public class LoginMapper implements RowMapper<AdminDTO> {
		@Override
		public AdminDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			AdminDTO login = new AdminDTO();
			login.setUserName(rs.getString("user_name"));
			login.setPassWord(rs.getString("password"));
			login.setAdminEmail(rs.getString("email"));
			login.setAdminFirstName(rs.getString("first_name"));
			login.setAdminLastName(rs.getString("last_name"));
			login.setMobileNo(rs.getLong("mobile_no"));
			return login;
		}
	}

	public String findByUserName(String userName) {
		try {
			AdminDTO loginDTO = jdbcTemplate.queryForObject("SELECT * FROM Admin WHERE USER_NAME = ?",
					new Object[] { userName }, new BeanPropertyRowMapper<AdminDTO>(AdminDTO.class));
			return loginDTO.getPassWord();
		} catch (EmptyResultDataAccessException e) {
			return "User not found";
		}
	}

}
