package com.edupsousa.sqlizer.util;

import java.util.LinkedHashMap;

public interface SetStrategy {
	
	public String getSet(LinkedHashMap<String, String> fields);
	
}
