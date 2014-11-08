package com.erhuohaha.joke.scheduletask;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
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
 * @version 创建时间：Dec 17, 2013 9:22:25 PM 类说明
 */
public class HaHaTask extends AbstractJobTask {

	@Override
	public void doBus() {
		// 核心应用类
		HttpClient httpClient = new DefaultHttpClient();

		// HTTP请求
		for(int i=1163;i>0;i--){
//			HttpUriRequest request = new HttpGet("http://www.haha365.com/Adult_joke/index_3.htm");
//			HttpUriRequest request = new HttpGet("http://www.haha365.com/Adult_joke/index_"+i+".htm");//成人笑话
//			HttpUriRequest request = new HttpGet("http://www.haha365.com/fqxh/index_"+i+".htm");//成人笑话
//			HttpUriRequest request = new HttpGet("http://www.haha365.com/laxh/index_"+i+".htm");//成人笑话
//			HttpUriRequest request = new HttpGet("http://www.haha365.com/zc_joke/index_"+i+".htm");//成人笑话
			HttpUriRequest request = new HttpGet("http://www.haha365.com/xd_joke/index_"+i+".htm");//成人笑话
			// 打印请求信息
			System.out.println(request.getRequestLine());
			try {
				// 发送请求，返回响应
				HttpResponse response = httpClient.execute(request);

				// 打印响应信息
				System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();
				String responseBody= EntityUtils.toString(entity);
				responseBody = new String(responseBody.getBytes("ISO-8859-1"),"GBK");
//				System.out.println(responseBody);
				
				 Document doc = Jsoup.parse(responseBody);
				 Elements links = doc.getElementsByTag("div");
				 ApplicationContext appContext= new ClassPathXmlApplicationContext("applicationContext.xml");
				 JokeDao jokeDao =(JokeDao)appContext.getBean("jokeDao");
				 for (Element link : links) { 
				  String id = link.attr("id"); 
				  if("endtext".equals(id)){
					  String linkText = link.html(); 
					  System.err.println(linkText);
					  Joke joke = new Joke("",i%4,linkText);
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
		JobTask job = new HaHaTask();
		job.doBiz();
	}

}
