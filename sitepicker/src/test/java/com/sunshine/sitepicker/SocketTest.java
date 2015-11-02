package com.sunshine.sitepicker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class SocketTest {

//	@Test
	public void socketTest(){
		
		try {
			// 1. 连接到服务器
			Socket socket = new Socket("www.baidu.com", 80);

			// 2. 发送请求
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			StringBuffer sb = new StringBuffer("GET / HTTP/1.1\r\n");
	        sb.append("Host: www.baidu.com\r\n");
	        sb.append("Accept: */*\r\n");
	        sb.append("Accept-Language： zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3\r\n");
	        sb.append("Accept-Encoding: gzip, deflate\r\n");
	        sb.append("User-Agent: Mozilla/5.0 (Windows NT 6.1; rv:32.0) Gecko/20100101 Firefox/32.0\r\n");
	        sb.append("Connection: keep-alive\r\n\r\n");
	        out.write(sb.toString());
			out.flush();
			
		 	BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String lineText = "";
			while(null != (lineText = reader.readLine())){
				System.out.println(lineText);
			}
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void serverSocketTest(){
		try {
			Document doc = Jsoup.connect("http://www.txdzs.com/sort/5/index.html").get();
			
			Elements eles = doc.getElementsByClass("list_d");
			
			for(int i = 0; i < eles.size(); i++){
				Element ele = eles.get(i);
				System.out.println(ele);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	@Test 
	public void ttt(){
		 Socket sock = null;
	        try {
	            sock = new Socket("www.baidu.com", 80);
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        BufferedWriter bufwt = null;
	        BufferedReader bufrd = null;
	        try {
	            bufwt = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
	            bufrd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	            bufwt.write("GET / HTTP/1.1\r\n\r\n");
	            bufwt.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        String str = null;
	        try {
	            while((str = bufrd.readLine()) != null) {
	                System.out.println(str);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	            bufwt.close();
	            bufrd.close();
	            sock.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
//	@Test 
	public void UrlTest(){
		   URL tURL = null;
	        try {
	            tURL = new URL("http://www.baidu.com");
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	        BufferedReader bufrd = null;
	        String str = null;
	        try {
	            bufrd = new BufferedReader(new InputStreamReader(tURL.openStream()));
	            while((str = bufrd.readLine()) != null) {
	                System.out.println(str);
	            }
	            bufrd.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
