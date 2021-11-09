package com.example.demo.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.Domain.Hotel;

@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public static final RowMapper<Hotel> HOTEL_ROW_MAPPER =
			new BeanPropertyRowMapper<>(Hotel.class);
	
	public List<Hotel> findByPriceBelow(Integer price){
		String sql = "SELECT * FROM hotels "
				+ "WHERE price <= :price ORDER BY price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		return template.query(sql, param, HOTEL_ROW_MAPPER);
	}
	
	public List<Hotel> findAll(){
		String sql = "SELECT * FROM hotels ORDER BY price DESC;";
		return template.query(sql, HOTEL_ROW_MAPPER);
	}

}
