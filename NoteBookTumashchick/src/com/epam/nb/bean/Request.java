package com.epam.nb.bean;

import java.util.HashMap;
import java.util.Map;

public class Request {

	private Map<RequestParam, Object> map = new HashMap<>();

	public void setParam(RequestParam paramKey, Object value) {
		
		map.put(paramKey, value);
	
	}

	public Object getParam(RequestParam paramKey) {
		
		return map.get(paramKey);
	
	}

}
