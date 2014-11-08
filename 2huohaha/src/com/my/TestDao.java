package com.my;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class TestDao extends JdbcDaoSupport  {

	public void insert(String v){
		String sql = "insert into test(name)  values('"+v+"')";
		this.getJdbcTemplate().execute(sql);
	}

	public static void main(String[] args) {
		String[] a = "_".split("_",2);
		System.out.println(a.length);
		System.out.println(a[0]+","+a[1]);
//		long start  = System.currentTimeMillis();
//		ExecutorService pool = (ExecutorService) Executors.newFixedThreadPool(5);
//		Thread t1 = new OperatorThread();
//		Thread t2 = new OperatorThread();
//		Thread t3 = new OperatorThread();
//		Thread t4 = new OperatorThread();
//		Thread t5 = new OperatorThread();
//		pool.execute(t1);
//		pool.execute(t2);
//		pool.execute(t3);
//		pool.execute(t4);
//		pool.execute(t5);
//		pool.shutdown();
//		System.out.println(System.currentTimeMillis() - start);
		
	}
}

class OperatorThread extends Thread{
    @Override
    public void run() {
    	ApplicationContext appContext= new ClassPathXmlApplicationContext("test.xml");
		TestDao testDao =(TestDao)appContext.getBean("testDao");
		for(int i=0;i<1000;i++){
			testDao.insert("s"+i);
		}
		

    }

}

