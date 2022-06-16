package com.translate.handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.translate.constant.Constant;
import com.translate.model.Languages;

public class DictionaryHandler implements IDictionaryHandler {
	Map<String, String> dictionary;
	List<Languages> languages;

	@Override
	public Map<String, String> getLanguages() {
		return dictionary;
	}

	@Override
	public void add(String key, String value) {
		if (dictionary == null)
			dictionary = new HashMap<>();
		dictionary.put(key, value);
	}

	@Override
	public String get(String key) {
		return dictionary.get(key);
	}

	@Override
	public void readToMemory(List<String> lineList) {
		readToFile(lineList);
		for (int i = 0; i < languages.size(); i++) {
			add(languages.get(i).getVietnamese(), languages.get(i).getEnglish());
			add(dictionary.get(languages.get(i).getVietnamese()), languages.get(i).getVietnamese());
		}
	}

	@Override
	public void searchLike(String findKey) {
		for (String line : dictionary.keySet()) {
			if (findKey.toLowerCase().contains(line.toLowerCase()) || line.toLowerCase().contains(findKey.toLowerCase())
					|| dictionary.get(findKey).toLowerCase().contains(dictionary.get(line).toLowerCase())
					|| dictionary.get(line).toLowerCase().contains(dictionary.get(findKey).toLowerCase())) {
				System.out.println(line + " = " + dictionary.get(line));
			}
		}
	}

	@Override
	public void search(String key) {
		if (dictionary.get(key) == null)
			System.out.println("This word has not been added to the dictionary yet !!");
		else
			System.out.println("---> " + dictionary.get(key));
	}

	@Override
	public void boxSearch(String key) {
		search(key);
		if (dictionary.get(key) == null)
			return;
		else {
			System.out.println("List of relative words: ");
			searchLike(key);
		}
	}

	@Override
	public void readToFile(List<String> lineList) {
		languages = new ArrayList<>();
		for (String line : lineList) {
			String[] list = line.split(Constant.REGEX_SPLIT_STRING);
			Languages language = new Languages(list[0], list[1]);
			languages.add(language);
		}

	}

}
