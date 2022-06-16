package com.translate.handle;

import java.util.List;
import java.util.Map;

public interface IDictionaryHandler {
	public Map<String, String> getLanguages();

	public void add(String key, String value);

	public String get(String key);

	public void readToMemory(List<String> lineList);

	public void searchLike(String line);

	public void search(String key);

	public void boxSearch(String key);

	public void readToFile(List<String> lineList);
}
