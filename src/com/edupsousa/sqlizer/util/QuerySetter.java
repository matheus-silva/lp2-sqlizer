package com.edupsousa.sqlizer.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

public class QuerySetter {

	public static final int SET_VALUES_STRATEGY = 0;
	public static final int FIELD_VALUES_STRATEGY = 1;
	public LinkedHashMap<String, String> fields = new LinkedHashMap<String, String>();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SetStrategy setStrategy;

	public QuerySetter(int concreto) {
		switch (concreto) {
		case QuerySetter.SET_VALUES_STRATEGY:
			setStrategy = new SetValuesStrategy();
			break;
		case QuerySetter.FIELD_VALUES_STRATEGY:
			setStrategy = new FieldValuesSetStrategy();
			break;
		default:
			
		}
	}

	public void set(String field, String value) {
		this.setQuoted(field, value);
	}

	public void set(String field, int value) {
		this.setUnquoted(field, String.valueOf(value));
	}

	public void set(String field, double value) {
		this.setUnquoted(field, String.valueOf(value));
	}

	public void set(String field, Date value) {
		this.setQuoted(field, sdf.format(value));
	}

	public int size() {
		return fields.size();
	}

	private void setQuoted(String field, String value) {
		fields.put(field, "\"" + value + "\"");
	}

	private void setUnquoted(String field, String value) {
		fields.put(field, value);
	}

	public String getSet() {
		return setStrategy.getSet(fields);
	}

}
