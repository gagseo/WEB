package common.frontcontroller;

import java.util.HashMap;

public class ModelAndView {
	
	private String view = "";
	private HashMap<String,Object> data = new HashMap<String, Object>();
	
	public ModelAndView() {
		
	}
	
	public ModelAndView(String view, String key, String value) {
		this.view = view;
		data.put(key,value);
	}
	
	public void addObject(String key, Object value) {
		data.put(key,value);
	}
	
	public void setView(String view) {
		this.view = view;
	}

	public String getView() {
		return view;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	
}
