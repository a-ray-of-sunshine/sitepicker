package org.json;

import org.junit.Test;

public class JSONObjectTest {

	@Test
	public void createObject(){
		JSONObject obj = new JSONObject();
		
		obj.put("isConfirm", true);
		obj.put("sale", 123);
		obj.put("str", "hello");
		obj.put("nullObj", (Object)null);
		
		try {
			System.out.println(obj.getDouble("str"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(obj.optDouble("str"));
	}
	
}
