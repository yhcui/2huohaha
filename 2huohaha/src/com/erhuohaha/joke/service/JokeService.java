package com.erhuohaha.joke.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.erhuohaha.joke.dao.JokeDao;
import com.erhuohaha.joke.pojo.Joke;
import com.erhuohaha.joke.util.JokeConst;
import com.erhuohaha.joke.util.Pager;
import com.erhuohaha.utils.DateUtils;
import com.erhuohaha.utils.ReflectUtils;
import com.erhuohaha.utils.StringUtils;

//@Service("jokeService") 
public class JokeService {
	
	
	private JokeDao jokeDao;
	

	public void saveJoke(Joke joke){
		if(joke != null && StringUtils.isNotNull(joke.getContent())){
			jokeDao.saveJoke(joke);
		}
		
	}
	
	/**
	 * 首页查询
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String,Object> queryListJokeByPage(int page,int row){
		String date = DateUtils.getTomorrowForStringByFormat(DateUtils.FORMAT_YYYYMMDD);
		int start = (page-1)*row; //分页
		List<Joke> jokeList = jokeDao.queryListForPage(start,row,date);
		Integer count = jokeDao.queryForCount(date);
		Map<String,Object> model =new HashMap<String,Object>();
		model.put(JokeConst.LIST_KEY,jokeList);
		
		Pager pager = new Pager();  
        pager.setPagesize(JokeConst.PAGE_ROW);  //在应用中 需要设置 每页显示的数量
        pager.setSum(count);   // 设置总数量
        pager.setCurpage(page);  //设置当前页
        model.put(JokeConst.PAGER_KEY,pager);
		return model;
	}
	
	public Map<String,Object> queryListJokeByPageAndJokeType(int page,int row,int type){
		String date = DateUtils.getTomorrowForStringByFormat(DateUtils.FORMAT_YYYYMMDD);
		int start = (page-1)*row; //分页
		List<Joke> jokeList = jokeDao.queryListForPageByType(start,row,type,date);
		Integer count = jokeDao.queryForCountByType(type, date);
		Map<String,Object> model =new HashMap<String,Object>();
		model.put(JokeConst.LIST_KEY,jokeList);
		
		Pager pager = new Pager();  
        pager.setPagesize(JokeConst.PAGE_ROW);  //在应用中 需要设置 每页显示的数量
        pager.setSum(count);   // 设置总数量
        pager.setCurpage(page);  //设置当前页
        model.put(JokeConst.PAGER_KEY,pager);
		return model;
	}
	
	public void updateJokeBad(int id){
		jokeDao.updateJokeBad(id);
	}
	
	public void updateJokeGood(int id){
		jokeDao.updateJokeGood(id);
	}
	
	public JokeDao getJokeDao() {
		return jokeDao;
	}

	public void setJokeDao(JokeDao jokeDao) {
		this.jokeDao = jokeDao;
	}
	
	public static void main(String[] args) {
		ApplicationContext appContext= new ClassPathXmlApplicationContext("applicationContext.xml");
		JokeDao jokeDao =(JokeDao)appContext.getBean("jokeDao");
		List<Joke> jokeList = jokeDao.queryListForPage(1,30,"20131219");
		for(Joke joke:jokeList){
			System.err.println(ReflectUtils.getClassGetMethodForString(joke));
		}
		int count = jokeDao.queryCurrentDayForCount();
	}
}
