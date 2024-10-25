package com.withJo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;

@MultipartConfig
public class FileUpload {

    private Logger log = LoggerFactory.getLogger(FileUpload.class);
    private String saveDirectory;

    public FileUpload() {
        // OS에 따라 saveDirectory 설정
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            saveDirectory = "C:/upload";
        } else if (os.contains("mac") || os.contains("nux")) {
            saveDirectory = "/Users/username/upload"; // 적절한 Mac 경로로 변경
        } else {
            throw new UnsupportedOperationException("지원하지 않는 운영체제입니다: " + os);
        }
    }

    public String getFileUpload(Part filePart, String imgName) throws Exception, IOException {
        String fileName = "";

        try {
            log.info("업로드된 파일 종류 : {}", filePart.getContentType());
            log.info("업로드된 파일 크기 : {}", filePart.getSize());
            log.info("업로드된 파일 이름 : {}", filePart.getSubmittedFileName());
            log.info("업로드된 파일 확장자 : {}", StringUtils.getFilenameExtension(filePart.getSubmittedFileName()));

            InputStream fileContent = filePart.getInputStream();
            String extension = StringUtils.getFilenameExtension(filePart.getSubmittedFileName());
            OutputStream outputStream = null;

            try {
                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(System.currentTimeMillis());
                fileName = timeStamp + "." + extension;

                File dir = new File(saveDirectory);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File file = new File(dir, fileName);
                outputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fileContent.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }

                if (StringUtils.hasText(imgName)) {
                    File deleteFile = new File(dir, imgName);
                    // 파일이 존재하면 삭제
                    if (deleteFile.exists()) {
                        deleteFile.delete();
                    }
                }

            } catch (Exception e) {
                log.error("파일 업로드 중 오류 발생", e);
            } finally {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
                fileContent.close();
            }

        } catch (IOException e) {
            log.error("파일 업로드 중 IO 오류 발생", e);
        }

        return fileName;
    }
    
    public String getFileDelete(String imgName) throws Exception, IOException {
        String fileName = "";

        try {
        	
            File dir = new File(saveDirectory);
            
            if (StringUtils.hasText(imgName)) {
                File deleteFile = new File(dir, imgName);
                // 파일이 존재하면 삭제
                if (deleteFile.exists()) {
                    deleteFile.delete();
                }
            }

        } catch (Exception e) {
            log.error("파일 업로드 중 오류 발생", e);
        } finally {

        }
        return fileName;
    }
    

    
    
}