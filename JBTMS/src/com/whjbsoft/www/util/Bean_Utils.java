package com.whjbsoft.www.util;

import java.lang.reflect.*;

public class Bean_Utils {

	public Bean_Utils() {
	}

	public static Object getProperty(Object obj, String property) {
		Class c = obj.getClass();
		Object value = null;
		String mname = "get" + property.substring(0, 1).toUpperCase()
				+ property.substring(1);
		try {
			Method m = c.getDeclaredMethod(mname, null);
			value = m.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
