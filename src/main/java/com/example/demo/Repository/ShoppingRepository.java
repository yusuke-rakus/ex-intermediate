package com.example.demo.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.Domain.Shopping;

@Repository
public class ShoppingRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public static final RowMapper<Shopping> SHOPPING_ROW_MAPPER =
			new BeanPropertyRowMapper<>(Shopping.class);
	
	public List<Shopping> findByGenderAndColor(Integer gender, String color){
		String sql = "SELECT * FROM clothes "
				+ "WHERE gender=:gender AND color=:color";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("gender", gender).addValue("color", color);
		List<Shopping> clothesList = template.query(sql, param, SHOPPING_ROW_MAPPER);
		return clothesList;
	}

}
