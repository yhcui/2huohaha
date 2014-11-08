package com.erhuohaha.joke.dao;

import java.util.List;

import com.erhuohaha.joke.pojo.Joke;

public interface JokeDao {

	public List<Joke> queryListForPage(int start,int num,String date);
	
	public List<Joke> queryListForPageByType(int start,int num,int type,String date);
	
	public int queryForCount(String date);
	
	public int queryForCountByType(int type,String date);
	
	public List<Joke> queryCurrentDayForList();
	
	public int queryCurrentDayForCount();
	
	public int saveJoke(Joke joke);
	
	public int updateJokeGood(int id);
	
	public int updateJokeBad(int id);
	
}
