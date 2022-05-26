package com.translate.handle;

import java.util.List;
import java.util.Map;

public class DictionaryHandler implements IDictionaryHandler {

	@Override
	public void add(Map<String, String> data, String key, String value) {
		data.put(key, value);
	}

	@Override
	public String get(Map<String, String> data, String key) {
		return data.get(key);
	}

	@Override
	public void readToMemory(List<String> key, List<String> value, Map<String, String> Dictionary) {
		for (int i = 0; i < key.size(); i++) {
			Dictionary.put(key.get(i), value.get(i));
		}
	}

	@Override
	public void searchLike(String findKey, Map<String, String> Dictionary) {
		for (String line : Dictionary.keySet()) {
			if (findKey.toLowerCase().contains(line.toLowerCase()) || line.toLowerCase().contains(findKey.toLowerCase())
					|| Dictionary.get(findKey).toLowerCase().contains(Dictionary.get(line).toLowerCase())
					|| Dictionary.get(line).toLowerCase().contains(Dictionary.get(findKey).toLowerCase())) {
				System.out.println(line + " = " + Dictionary.get(line));
			}
		}
	}

	@Override
	public void search(String key, Map<String, String> Dictionary) {
		if (Dictionary.get(key) == null)
			System.out.println("This word has not been added to the dictionary yet !!");
		else
			System.out.println("---> " + Dictionary.get(key));
	}

	@Override
	public void boxSearch(String key, Map<String, String> Dictionary) {
		search(key, Dictionary);
		if (Dictionary.get(key) == null)
			return;
		else {
			System.out.println("List of relative words: ");
			searchLike(key, Dictionary);
		}
	}

}
