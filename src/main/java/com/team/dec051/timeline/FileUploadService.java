package com.team.dec051.timeline;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.team.dec051.member.Member;



@Service
public class FileUploadService {

    private String uploadDir = Constants.getPersonalFolderDir();
    
   
    
    public String getFolderDir(HttpServletRequest req) {
    	
    	
    	Member mb = (Member) req.getSession().getAttribute("loginMember");
    	String m_folder = mb.getM_folder();
    	
    	return uploadDir + "/" + m_folder;
    }

    public void uploadVideo(MultipartFile file, HttpServletRequest req) throws IOException {
    	deleteOldVideo(req);
    	String folderDir = getFolderDir(req);
    	String uniqueFileName = "video_"+UUID.randomUUID().toString()+".mp4";
        Path filePath = Paths.get(folderDir).resolve(uniqueFileName);
        Files.write(filePath, file.getBytes());
        
        System.out.println(uniqueFileName);
        req.getSession().setAttribute("UploadedFileName", uniqueFileName);
        
    }
    
    public void deleteOldVideo(HttpServletRequest req) {
    	String UploadedFileName = (String) req.getSession().getAttribute("UploadedFileName");
    	
    	if(UploadedFileName!=null) {
    		System.out.println("이전에 업로드 된 파일 삭제");
    		String filePath = getFolderDir(req)+"/"+UploadedFileName;
    		System.out.println(filePath);
    		try {
				Path path = Paths.get(filePath);
				Files.delete(path);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
    	}else {
    		System.out.println("이전에 업로드된 파일 없음");
    	}
    }

}
