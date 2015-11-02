package com.sunshine.sitepicker;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class PicTest {

	@Test
	public void picTest(){
	
		try {
			Document doc = Jsoup.connect("http://www.txdzs.com/sort/5/index.html").get();
			
			Elements eles = doc.getElementsByClass("list_d");
			
			for(int i = 0; i < eles.size(); i++){
				Element ele = eles.get(i);
				
				Elements spans = ele.select("p > span");
				for(int j = 0; j < spans.size(); j++){
					Element spEle = spans.get(j);
					System.out.print(spEle.text() + "\t");
				}
				System.out.println();
				System.out.println(ele);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
