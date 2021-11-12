package com.ktb.app.pms.commonlibrary.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Validate {

	public static boolean empty(Object object) {
		if (object == null) {
			return true;
		} else if (object instanceof String) {
			String str = (String) object;
			if (str.trim().equals("")) {
				return true;
			}
		} else if (object instanceof Collection) {
			Collection<?> collection = (Collection<?>) object;
			if (collection.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks <code>obj1</code> equals <code>obj2</code> or not.
	 *
	 * @param obj1
	 *          the object to check equal
	 * @param obj2
	 *          the object to check equal
	 * @return <code>true</code> if <code>obj1</code> equals <code>obj2</code>.
	 *         Otherwise, <code>false</code>.
	 *
	 */
	public static boolean equalAs(Object obj1, Object obj2) {
		return (obj1 == null && obj2 == null) || (obj1 != null && obj1.equals(obj2));
	}

	/**
	 * กรณีค่า List เป็น null จะสร้าง Empty List<T> ให้
	 * 
	 * @param lists
	 *          : List<T>
	 * @return if null return empty of List<T> else return lists
	 * @author : Sama S.
	 */
	public static <T> List<T> nvlList(List<T> lists) {
		if (lists == null) {
			return Collections.emptyList();
		}

		return lists;
	}
	public static<T> T changeNullTo(T text, T result){
		if(Validate.empty(text)){
			return result;
		}
		return text;
	}
}