package com.erhuohaha.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FirstSpring {

	public static void main(String[] args) {
		sayHello();
	}
	public static void sayHello(){
		ApplicationContext app= new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld hw = (HelloWorld)app.getBean("sayHello");
		hw.sayHello();
		BeanFactory factory = new FileSystemXmlApplicationContext("file:D:/workspace/testproject/WebRoot/WEB-INF/applicationContext.xml");
	}
}
