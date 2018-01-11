package cn.smbms.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class FileUploadUtil {
	

	    public static String uploadFile(HttpServletRequest request, String filePath,String filePathUrl) throws FileNotFoundException {
	    	String filePathList = null;

	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

	        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
	        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {

	            MultipartFile mf = entity.getValue();
	            String suffix = FilenameUtils.getExtension(mf.getOriginalFilename());
	            String newFileName = UUID.randomUUID().toString().replace("-", "")+"."+suffix;
	            System.out.println(newFileName);
	            String relativePath=null;
	            try {
					byte[] imgbyte = mf.getBytes();
					
					Client client = Client.create();
					
					WebResource resource = client.resource(filePath+filePathUrl+newFileName);
					
					resource.put(String.class, imgbyte);
					
					//String fullPath = filePath+filePathUrl+newFileName;
					
					relativePath = filePathUrl+newFileName;
					
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
	            
	            
	            
	            
	            filePathList = relativePath;
	        }

	        return filePathList;
	    }
	
}
