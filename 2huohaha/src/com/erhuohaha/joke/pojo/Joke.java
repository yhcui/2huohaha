package com.erhuohaha.joke.pojo;

import java.util.Date;

public class Joke {
	
	private int id;
	
	private String title;
	
	private int type;
	
	private String content;
	
	private Date createDate;
	
	private int good;
	
	private int bad;
	
	public Joke(){
		
	}


	public Joke(String title, int type, String content) {
		this.title = title;
		this.type = type;
		this.content = content;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getGood() {
		return good;
	}
	
	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}
	

}
