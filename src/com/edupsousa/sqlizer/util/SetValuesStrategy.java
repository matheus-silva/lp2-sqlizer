package com.edupsousa.sqlizer.util;

import java.util.LinkedHashMap;

public class SetValuesStrategy implements SetStrategy {

	@Override
	public String getSet(LinkedHashMap<String, String> fields) {
		String sql = "";

		for (String key : fields.keySet()) {
			String value = fields.get(key);
			if (sql.equals("")) {
				sql = "SET " + key + "=" + value;
			} else {
				sql += ", " + key + "=" + value;
			}
		}

		return sql;
	}

}
