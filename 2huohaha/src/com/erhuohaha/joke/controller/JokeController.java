package com.erhuohaha.joke.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.erhuohaha.joke.pojo.Joke;
import com.erhuohaha.joke.service.JokeService;
import com.erhuohaha.joke.util.JokeConst;
import com.erhuohaha.joke.util.Pager;
import com.erhuohaha.utils.ComUtils;
import com.erhuohaha.utils.LoggerUtil;

@Controller
public class JokeController {
	
	private JokeService jokeService;
	
	public JokeService getJokeService() {
		return jokeService;
	}
	
	@Resource
	public void setJokeService(JokeService jokeService) {
		this.jokeService = jokeService;
	}
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		String curpagerStr= request.getParameter("curpager");
		int curpager =1;
		if(curpagerStr!=null && curpagerStr.length() >0){
			curpager = Integer.valueOf(curpagerStr);
		}
		if(curpager ==0 ){
			curpager = 1;
		}
		Map<String,Object> model = jokeService.queryListJokeByPage(curpager,JokeConst.PAGE_ROW);
        request.setAttribute(JokeConst.PAGER_KEY, model.get(JokeConst.PAGER_KEY));  
        request.setAttribute(JokeConst.JOKE_TYPE, JokeConst.JOKE_DEFAULT_TYPE); 
        request.setAttribute(JokeConst.JOKE_URL, JokeConst.JOKE_URL_INDEX);
		return new ModelAndView("index",model);
	}
	
	@RequestMapping("/erhuonvyou")
	public ModelAndView erhuonvyou(HttpServletRequest request, HttpServletResponse response){
		String curpagerStr= request.getParameter("curpager");
		int curpager =1;
		if(curpagerStr!=null && curpagerStr.length() >0){
			curpager = Integer.valueOf(curpagerStr);
		}
		if(curpager ==0 ){
			curpager = 1;
		}
		Map<String,Object> model = jokeService.queryListJokeByPageAndJokeType(curpager,JokeConst.PAGE_ROW,JokeConst.JOKE_TYPE_ERHUONVYOU);
        request.setAttribute(JokeConst.PAGER_KEY, model.get(JokeConst.PAGER_KEY));
        request.setAttribute(JokeConst.JOKE_TYPE, JokeConst.JOKE_TYPE_ERHUONVYOU);
        request.setAttribute(JokeConst.JOKE_URL, JokeConst.JOKE_URL_ERHUONVYOU);
		return new ModelAndView("index",model);
	}
	
	@RequestMapping("/erhuonanyou")
	public ModelAndView erhuonanyou(HttpServletRequest request, HttpServletResponse response){
		String curpagerStr= request.getParameter("curpager");
		int curpager =1;
		if(curpagerStr!=null && curpagerStr.length() >0){
			curpager = Integer.valueOf(curpagerStr);
		}
		if(curpager ==0 ){
			curpager = 1;
		}
		Map<String,Object> model = jokeService.queryListJokeByPageAndJokeType(curpager,JokeConst.PAGE_ROW,JokeConst.JOKE_TYPE_ERHUONANYOU);
        request.setAttribute(JokeConst.PAGER_KEY, model.get(JokeConst.PAGER_KEY));  
        request.setAttribute(JokeConst.JOKE_TYPE, JokeConst.JOKE_TYPE_ERHUONANYOU);
        request.setAttribute(JokeConst.JOKE_URL, JokeConst.JOKE_URL_ERHUONANYOU);
		return new ModelAndView("index",model);
	}
	
	@RequestMapping("/erhuosheyou")
	public ModelAndView erhuosheyou(HttpServletRequest request, HttpServletResponse response){
		String curpagerStr= request.getParameter("curpager");
		int curpager =1;
		if(curpagerStr!=null && curpagerStr.length() >0){
			curpager = Integer.valueOf(curpagerStr);
		}
		if(curpager ==0 ){
			curpager = 1;
		}
		Map<String,Object> model = jokeService.queryListJokeByPageAndJokeType(curpager,JokeConst.PAGE_ROW,JokeConst.JOKE_TYPE_ERHUOSHEYOU);
        request.setAttribute(JokeConst.PAGER_KEY, model.get(JokeConst.PAGER_KEY));  
        request.setAttribute(JokeConst.JOKE_TYPE, JokeConst.JOKE_TYPE_ERHUOSHEYOU);
        request.setAttribute(JokeConst.JOKE_URL, JokeConst.JOKE_URL_ERHUOSHEYOU);
		return new ModelAndView("index",model);
	}
	
	@RequestMapping("/qitaerhuo")
	public ModelAndView qitaerhuo(HttpServletRequest request, HttpServletResponse response){
		String curpagerStr= request.getParameter("curpager");
		int curpager =1;
		if(curpagerStr!=null && curpagerStr.length() >0){
			curpager = Integer.valueOf(curpagerStr);
		}
		if(curpager ==0 ){
			curpager = 1;
		}
		Map<String,Object> model = jokeService.queryListJokeByPageAndJokeType(curpager,JokeConst.PAGE_ROW,JokeConst.JOKE_TYPE_QITAERHUO);
        request.setAttribute(JokeConst.PAGER_KEY, model.get(JokeConst.PAGER_KEY));  
        request.setAttribute(JokeConst.JOKE_TYPE, JokeConst.JOKE_TYPE_QITAERHUO);
        request.setAttribute(JokeConst.JOKE_URL, JokeConst.JOKE_URL_QITAERHUO);
		return new ModelAndView("index",model);
	}
	
	@RequestMapping("/abouterhuo")
	public ModelAndView abouterhuo(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute(JokeConst.JOKE_TYPE, JokeConst.JOKE_TYPE_ABOUTERHUO);
		return new ModelAndView("index");
	}

	@RequestMapping("/bad")
	public ModelAndView bad(HttpServletRequest request, HttpServletResponse response){
		String idStr = request.getParameter("id");
		if(ComUtils.isNumeric(idStr)){
			jokeService.updateJokeBad(Integer.valueOf(idStr));
		}
		return null;
	}
	@RequestMapping("/good")
	public ModelAndView good(HttpServletRequest request, HttpServletResponse response){
		String idStr = request.getParameter("id");
		if(ComUtils.isNumeric(idStr)){
			jokeService.updateJokeGood(Integer.valueOf(idStr));
		}
		return null;
	}
	
	
}
