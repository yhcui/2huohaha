package com.erhuohaha.joke.dao.imp;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.erhuohaha.joke.dao.JokeDao;
import com.erhuohaha.joke.pojo.Joke;
import com.erhuohaha.utils.DateUtils;

public class JokeDaoImpl extends JdbcDaoSupport implements JokeDao {
	
	@Override
	public List<Joke> queryListForPage(int start,int num,String date) {
		String sql = "select * from joke where createdate<"+date +" order by createdate desc limit "+start+","+num;
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Joke.class));
	}

	@Override
	public List<Joke> queryListForPageByType(int start,int num,int type,String date) {
		String sql = "select * from joke where type="+type+" and createdate<"+date+" order by createdate desc limit "+start+","+num;
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Joke.class));
	}
	@Override
	public int queryForCount(String date) {
		String sql = "select count(1) from joke where  createdate<"+date;
		return this.getJdbcTemplate().queryForInt(sql);
	}
	
	public int queryForCountByType(int type,String date){
		String sql = "select count(1) from joke where type="+type+" and createdate<"+date;
		return this.getJdbcTemplate().queryForInt(sql);
	}
	

	public List<Joke> queryCurrentDayForList() {
		String tomorrow = DateUtils
				.getTomorrowForStringByFormat(DateUtils.FORMAT_YYYYMMDD);
		String today = DateUtils
				.getTodayForStringByFormat(DateUtils.FORMAT_YYYYMMDD);
		String sql = "select * from joke where createdate>= " + today
				+ " and createdate< " + tomorrow;
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Joke.class));
	}

	public int queryCurrentDayForCount() {
		String tomorrow = DateUtils
				.getTomorrowForStringByFormat(DateUtils.FORMAT_YYYYMMDD);
		String today = DateUtils
				.getTodayForStringByFormat(DateUtils.FORMAT_YYYYMMDD);
		String sql = "select count(1) from joke where createdate>= " + today
				+ " and createdate< " + tomorrow;
		return this.getJdbcTemplate().queryForInt(sql);
	}

	@Override
	public int saveJoke(Joke joke) {
		String sql = "insert into joke(title,type,content,createdate) value (?,?,?,NOW())";
		return this.getJdbcTemplate().update(
				sql,
				new Object[] { joke.getTitle(), joke.getType(),joke.getContent()},
				new int[] { java.sql.Types.VARCHAR, java.sql.Types.INTEGER,
						java.sql.Types.VARCHAR });
	}

	@Override
	public int updateJokeBad(int id) {
		String sql = "update joke set bad=bad+1 where id=?";
		return this.getJdbcTemplate().update(
				sql,
				new Object[] { id},
				new int[] {java.sql.Types.INTEGER });
	}

	@Override
	public int updateJokeGood(int id) {
		String sql = "update joke set good=good+1 where id=?";
		return this.getJdbcTemplate().update(
				sql,
				new Object[] { id},
				new int[] {java.sql.Types.INTEGER});
	}

}
