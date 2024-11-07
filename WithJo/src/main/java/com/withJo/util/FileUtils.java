package com.withJo.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.annotations.Until;

@Component("fileUtils")
public class FileUtils {
	private static final String FILE_PATH = "/Users/kimyk/cUpload";
	
	public Map<String, Object> insertFileInfo(MultipartHttpServletRequest mhr) throws Exception{
		
		Iterator<String> iterator = mhr.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		Map<String, Object> fileInfoMap = null;
		
		File file = new File(FILE_PATH);
		
		if(file.exists() == false) {
			file.mkdir();
		}
		
		while (iterator.hasNext()) {
			multipartFile = mhr.getFile(iterator.next());
			
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName
					.substring(originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() 
					+ originalFileExtension;
					
				file = new File(FILE_PATH, storedFileName);
				multipartFile.transferTo(file); // 실제 파일이 생성
				
				fileInfoMap = new HashMap<>();
				fileInfoMap.put("originalFileName", originalFileName);
				fileInfoMap.put("storedFileName", storedFileName);
				fileInfoMap.put("fileSize", multipartFile.getSize());
				
			}
			
		}
		
		return fileInfoMap;
	}
}
