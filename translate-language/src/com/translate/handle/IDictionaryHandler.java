package com.translate.handle;

import java.util.List;
import java.util.Map;

public interface IDictionaryHandler {
	public void add(Map<String, String> data, String key, String value);

	public String get(Map<String, String> data, String key);

	public void readToMemory(List<String> key, List<String> value, Map<String, String> Dictionary);

	public void searchLike(String line, Map<String, String> Dictionary);

	public void search(String key, Map<String, String> Dictionary);

	public void boxSearch(String key, Map<String, String> Dictionary);
}
