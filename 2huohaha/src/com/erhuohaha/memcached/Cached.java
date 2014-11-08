package com.erhuohaha.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class Cached{
	
	private static MemcachedClient memcachedClient; 
	
	static{
		
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
                  AddrUtil.getAddresses("localhost:11211"));
		try {
			memcachedClient= builder.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	private Cached(){
		
	}
	
	public static Object get(String key){
		return get(key,Object.class);
	}

	public static <T> T get(String key,Class<T> t){
		try {
			T v = (T)memcachedClient.get(key);
			return v;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean add(String key,Object obj,int expTime){
		try {
			return memcachedClient.add(key, expTime, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	} 

	public static boolean set(String key,Object obj,int expTime){
		try {
			return memcachedClient.set(key, expTime, obj);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	} 
	
	/**
	 * @param key
	 */
	public static boolean delete(String key){
		try {
			return memcachedClient.delete(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void shutdown(){
		try {
			if(memcachedClient != null){
				memcachedClient.shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		String threadName = Thread.currentThread().getName();
		
		for(int i = 0;i<10;i++){
			Cached.set(threadName+i, threadName+i, 0);
		}
		System.out.println("完成");
		Cached.shutdown();
	}
}
class Tester extends Thread{
	
	@Override
	public void run(){
		
		
		
	}
}
