package com.translate.handle;

import java.util.ArrayList;
import java.util.List;

import com.translate.constant.Constant;

public class EnglishDictionaryHandler implements IEnglishDictionaryHandler {

	@Override
	public List<String> listEnglishDictionary(List<String> lineList) {
		List<String> lineListEnglishDictionary = new ArrayList<>();
		for (String line : lineList) {
			String[] line1 = line.split(Constant.REGEX_SPLIT_STRING);
			lineListEnglishDictionary.add(line1[1]);
		}
		return lineListEnglishDictionary;
	}

}
