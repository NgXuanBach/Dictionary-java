package com.translate.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements IFileHandler {

	@Override
	public List<String> read(String filePath) {
		List<String> lineList = new ArrayList<>();
		File file = new File(filePath);
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			inputStream = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(inputStream));
			while (reader.ready()) {
				lineList.add(reader.readLine());
			}
			return lineList;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

}
