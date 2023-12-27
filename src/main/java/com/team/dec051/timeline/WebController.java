package com.team.dec051.timeline;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.team.dec051.member.Member;


@Controller
public class WebController {

    @Autowired
    private FileUploadService fileUploadService;
    
    @Autowired
    private TokenManager tm;



    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadVideo(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws IOException {
    	System.out.println("uploadVideo");
    	if(tm.checkToken(req)) {
    		System.out.println("새로고침에 의한 요청이 아님");
    		fileUploadService.uploadVideo(file,req);
    	}else {
    		System.out.println("새로고침에 의한 요청입니다.");
    	}
    	
        return "VideoToText";
    }
    

    
    @RequestMapping(value = "/videos", method = RequestMethod.GET)
    public void serveVideo(HttpServletRequest req, HttpServletResponse response) throws IOException {
        
    	
    	String folder_dir = Constants.getPersonalFolderDir();

    	Member mb = (Member) req.getSession().getAttribute("loginMember");
    	String folderName = mb.getM_folder();
    	folder_dir += "/";
    	folder_dir += folderName;
    	
        String filename = (String) req.getSession().getAttribute("UploadedFileName");

        Path filePath = Paths.get(folder_dir).resolve(filename);
        byte[] videoBytes = Files.readAllBytes(filePath);

        // Content-Type 헤더 설정 (예: 비디오 파일의 MIME 타입)
        response.setContentType("video/mp4");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Accept-Ranges", "bytes");

        long fileSize = Files.size(filePath);
        response.setHeader("Content-Length", String.valueOf(fileSize));
        
        response.setHeader("Content-Range", "bytes 0-" + (fileSize - 1) + "/" + fileSize);

        // 응답 데이터 쓰기
        OutputStream out = response.getOutputStream();
        out.write(videoBytes);
        out.flush();
        out.close();
    }
    
    
}