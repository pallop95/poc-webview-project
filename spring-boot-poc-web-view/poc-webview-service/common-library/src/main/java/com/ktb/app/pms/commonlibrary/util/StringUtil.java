package com.ktb.app.pms.commonlibrary.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.reflections.ReflectionUtils;

public class StringUtil {
	
	public static String nullToEmpty(String text) {
		String result = "";
		if(!Validate.empty(text)) {
			result = text;
		}
		return result;
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}

	public static String genRelationCaption(String relation, String collateralRelation) {
		if (StringUtils.isNotBlank(relation)) {
			if (StringUtils.isBlank(collateralRelation)) {
				return MessageUtil.getMessage("person.relationConst." + relation);
			} else {
				return MessageUtil.getMessage("person.relationConst." + relation + collateralRelation);
			}
		}
		return "-";
	}

	public static String objectToJson(Object obj) {
		GsonBuilder builder = new GsonBuilder();
		builder.serializeNulls();
		Gson gson = builder.create();
		String output = gson.toJson(obj);
		return output;
	}
	public static String capitalize(String str) {
		if(str == null || str.isEmpty()) {
			return str;
		}

		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	public static String currencyFormat(BigDecimal n) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		if(n == null) {
			return "-";
		}
		return df.format(n);
	}

	public static String camelToSnake(String str) {

		// Regular Expression
		String regex = "([a-z])([A-Z]+)";

		// Replacement string
		String replacement = "$1_$2";

		// Replace the given regex
		// with replacement string
		// and convert it to lower case.
		str = str
				.replaceAll(
						regex, replacement)
				.toUpperCase();

		// return string
		return str;
	}

	public static Object getValueByFieldName(Object obj, String fieldName){
		Set<Field> fields = ReflectionUtils.getAllFields(obj.getClass(), ReflectionUtils.withModifier(Modifier.PRIVATE));
		Object output = null;
		for (Field field : fields) {
			if(fieldName.equals(field.getName())){
				output = new Object();
				output = runGetter(field, obj);
			}
		}
		return output;
	}
	
//	public static Object getValueByFieldNamePrivate(Object obj, Object objInput){
////		Set<Field> fields = ReflectionUtils.getAllFields(obj.getClass(), ReflectionUtils.withModifier(Modifier.PRIVATE));
//		Set<Field> fields = ReflectionUtils.getAllFields(objInput.getClass(), ReflectionUtils.withModifier(Modifier.PRIVATE));
////		Object output = null;
////		for (Field field : fields) {
//////			if(fieldName.equals(field.getName())){
////			output = new Object();
////			output = runGetter(field, obj);
//////			}
////		}
////		return output;
//		
////		objInput.class
////		Field declaredField =  null;
////        try {
////
////            declaredField = Test.class.getDeclaredField("ttp");
////            boolean accessible = declaredField.isAccessible();
////
////            declaredField.setAccessible(true);
////
////            ConcurrentHashMap<Object, Object> concHashMap = new ConcurrentHashMap<Object, Object>();
////            concHashMap.put("key1", "value1");
////            declaredField.set(this, concHashMap);
////            Object value = ttp.get("key1");
////
////            System.out.println(value);
////
////            declaredField.setAccessible(accessible);
////
////        } catch (NoSuchFieldException 
////                | SecurityException
////                | IllegalArgumentException 
////                | IllegalAccessException e) {
////            e.printStackTrace();
////        }
//	}

	public static Object getValueByFieldNamePublic(Object obj, String fieldName){
		Set<Field> fields = ReflectionUtils.getAllFields(obj.getClass(), ReflectionUtils.withModifier(Modifier.PUBLIC));
		Object output = null;
		for (Field field : fields) {
			if(fieldName.equals(field.getName())){
				output = new Object();
				output = runGetter(field, obj);
			}
		}
		return output;
	}

	public static Object runGetter(Field field, Object o)
	{
		// MZ: Find the correct method
		for (Method method : o.getClass().getMethods())
		{
			if ((method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3)))
			{
				if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase()))
				{
					// MZ: Method found, run it
					try
					{
						return method.invoke(o);
					}
					catch (IllegalAccessException e)
					{
						System.out.println("Error Could not determine method: " + method.getName());
					}
					catch (InvocationTargetException e)
					{
						System.out.println("Error Could not determine method: " + method.getName());
					}

				}
			}
		}

		return null;
	}


}
