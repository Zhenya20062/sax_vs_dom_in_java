package com.euzhene.sax_vs_dom;

import java.lang.reflect.Field;

public class ReflectionHelper {
	private static ReflectionHelper _instance;
	public static ReflectionHelper Instance() {
		if (_instance == null) {
			_instance = new ReflectionHelper();
		}
		return _instance;
	}
	
	public <T> void setFieldValue(Object classObject, String fieldName, T value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = classObject.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(classObject, value);
		field.setAccessible(false);
	}
}
