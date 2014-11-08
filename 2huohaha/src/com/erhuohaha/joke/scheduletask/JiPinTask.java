package com.erhuohaha.joke.scheduletask;

import java.io.IOException;
import java.util.Calendar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.erhuohaha.joke.dao.JokeDao;
import com.erhuohaha.joke.pojo.Joke;

/**
 * @author yuhuicui E-mail:yuhuicui@xyh.com
 * @version 创建时间：Dec 19, 2013 10:28:40 PM
 * 类说明
 */
//http://www.jipinge.com/youmo/2.html
public class JiPinTask extends AbstractJobTask {

	@Override
	public void doBus() {
		// 核心应用类
		HttpClient httpClient = new DefaultHttpClient();
		int j=0;
		// HTTP请求
		for(int i=1;i<=242;i++){
//			HttpUriRequest request = new HttpGet("http://www.jipinge.com/youmo/"+i+".html");//成人笑话
//			HttpUriRequest request = new HttpGet("http://www.jipinge.com/lengxiaohua/"+i+".html");//成人笑话
			HttpUriRequest request = new HttpGet("http://www.jipinge.com/qiushi/"+i+".html");//成人笑话
			// 打印请求信息
			try {
				// 发送请求，返回响应
				HttpResponse response = httpClient.execute(request);

				// 打印响应信息
				System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();
				String responseBody= EntityUtils.toString(entity);
				responseBody = new String(responseBody.getBytes("ISO-8859-1"),"UTF-8");
//				System.out.println(responseBody);
				
				 Document doc = Jsoup.parse(responseBody);
				 Elements links = doc.getElementsByTag("div");
				 ApplicationContext appContext= new ClassPathXmlApplicationContext("applicationContext.xml");
				 JokeDao jokeDao =(JokeDao)appContext.getBean("jokeDao");
				 for (Element link : links) { 
				  String id = link.attr("class"); 
				  if("content".equals(id)){
					  j++;
					  String linkText = link.html(); 
					  System.err.println(linkText);
					  Joke joke = new Joke("",i%4,linkText);
					  Calendar cal = Calendar.getInstance();
						  cal.add(Calendar.DAY_OF_MONTH, 1);
						  joke.setCreateDate(cal.getTime());
					 if (j<6000){
						  cal.add(Calendar.DAY_OF_MONTH, 1);
						  joke.setCreateDate(cal.getTime());
					  }else if (j<8000){
						  cal.add(Calendar.DAY_OF_MONTH, 1);
						  joke.setCreateDate(cal.getTime());
					  }else if (j<10000){
						  cal.add(Calendar.DAY_OF_MONTH, 1);
						  joke.setCreateDate(cal.getTime());
					  }else{
						  cal.add(Calendar.DAY_OF_MONTH, 1);
						  joke.setCreateDate(cal.getTime());
					  }
					  jokeDao.saveJoke(joke);
					 
					 
				  }
				  
				 } 
			} catch (ClientProtocolException e) {
				// 协议错误
				e.printStackTrace();
			} catch (IOException e) {
				// 网络异常
				e.printStackTrace();
				System.out.println("i-----------------"+i);
				break;
			}
		}

	}

	public static void main(String[] args) {
		JobTask job = new JiPinTask();
		job.doBiz();
	}

}
