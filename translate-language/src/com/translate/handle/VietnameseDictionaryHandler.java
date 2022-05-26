package com.translate.handle;

import java.util.ArrayList;
import java.util.List;

import com.translate.constant.Constant;

public class VietnameseDictionaryHandler implements IVietnameseDictionaryHandler {

	@Override
	public List<String> listVietnameseDictionary(List<String> lineList) {
		List<String> lineListVietnameseDictionary = new ArrayList<>();
		for (String line : lineList) {
			String[] line1 = line.split(Constant.REGEX_SPLIT_STRING);
			lineListVietnameseDictionary.add(line1[0]);
		}
		return lineListVietnameseDictionary;
	}

}
