package com.example.demo.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.Domain.Team;

@Repository
public class TeamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public static final RowMapper<Team> TEAM_ROW_MAPPER = new BeanPropertyRowMapper<>(Team.class);

	/** チーム名一覧取得 */
	public List<Team> getTeamList() {
		String sql = "SELECT * FROM teams ORDER BY inauguration;";
		return template.query(sql, TEAM_ROW_MAPPER);
	}

	/** idからチーム情報を取得 */
	public Team findById(Integer id) {
		String sql = "SELECT * FROM teams " + "WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, param, TEAM_ROW_MAPPER);
	}
}
