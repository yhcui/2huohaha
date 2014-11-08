package com.erhuohaha.joke.scheduletask;
/**
 * @author yuhuicui E-mail:yuhuicui@xyh.com
 * @version 创建时间：Dec 17, 2013 9:24:04 PM
 * 类说明
 */
public abstract class AbstractJobTask  implements JobTask{
	
	public void begin(){
		
	}

	@Override
	public void doBiz() {
		try {
			begin();
			doBus();
			end();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public abstract void doBus();
	
	public void end(){
		
	}

}
