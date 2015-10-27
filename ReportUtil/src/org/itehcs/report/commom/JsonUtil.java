package org.itehcs.report.commom;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.itehcs.report.gitlabUtil.MergeRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//parse json str
//1. convert json to map
//2. convert map to java bean
public class JsonUtil {

	String str = "";

	public JsonUtil(String s) {
		this.str = s;
	}

	// 该方法解析包含多个对象的json字符串
	public List<Object> parsingJsonObject(Object javabean) {

		List<Object> objects = new ArrayList<Object>();
		List<MergeRequest> mrs = new ArrayList<MergeRequest>();
		JSONArray ja = new JSONArray(str);
		for (int i = 0; i < ja.length(); i++) {
			JSONObject joo = (JSONObject) ja.get(i);
			Map<String, String> temp_map = toMap(joo);
			Object bean = new Object();
			bean = toJavaBean(javabean, temp_map);
			// mrr.setDescription(Integer.toString(i));
			objects.add(bean);
		}
		return objects;
	}

	public Map<String, String> toMap(JSONObject jsonObject) throws JSONException {

		// JSONObject jsonObject = new JSONObject(jsonString);

		Map<String, String> result = new HashMap<String, String>();
		Iterator iterator = jsonObject.keys();
		String key = null;
		Object value = null;

		while (iterator.hasNext()) {

			key = (String) iterator.next();
			value = jsonObject.get(key).toString();
			result.put(key, value.toString());
		}
		return result;

	}

	public Object toJavaBean(Object javabean, Map data) {

		Class c = javabean.getClass();
		Object obj = new Object();
		try {
			obj = c.newInstance();
			Method[] methods = obj.getClass().getDeclaredMethods();
			for (Method method : methods) {

				if (method.getName().startsWith("set")) {

					String field = method.getName().toLowerCase();
					field = field.substring(field.indexOf("set") + 3).toLowerCase();
					field = field.toLowerCase().charAt(0) + field.substring(1);
					method.invoke(obj, new Object[] { data.get(field) });
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;

	}

	public static void main(String[] arfs) {

		List<MergeRequest> mrs = new ArrayList<MergeRequest>();
		for (int i = 0; i < 20; i++) {
			MergeRequest mrr = new MergeRequest();
			mrr.setAuthor(Integer.toString(i));
			mrs.add(mrr);
		}
		for (int j = 0; j < mrs.size(); j++) {

			MergeRequest mrrr = new MergeRequest();
			mrrr = (MergeRequest) mrs.get(j);
			System.out.println("final:" + mrrr.getAuthor());
		}

	}
}
