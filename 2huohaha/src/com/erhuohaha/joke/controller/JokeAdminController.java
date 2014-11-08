package com.erhuohaha.joke.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.erhuohaha.joke.pojo.Joke;
import com.erhuohaha.joke.service.JokeService;

@Controller
public class JokeAdminController {
	
	private JokeService jokeService;
	
	public JokeService getJokeService() {
		return jokeService;
	}
	
	@Resource
	public void setJokeService(JokeService jokeService) {
		this.jokeService = jokeService;
	}

	@RequestMapping("/admin/admin")
	public ModelAndView admin(){
		return new ModelAndView("/admin/admin");
	}
	
	@RequestMapping("/admin/addjoke")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response){
		System.err.println("title:"+request.getParameter("title"));
		System.err.println("content:"+request.getParameter("content"));
		System.err.println("type"+request.getParameter("type"));
		Joke joke = new Joke(request.getParameter("title"),0,request.getParameter("content"));
		joke.setType(Integer.valueOf(request.getParameter("type").toString()));
		jokeService.saveJoke(joke);
		return new ModelAndView("/admin/admin");
	}
}
