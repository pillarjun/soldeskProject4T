package com.team.dec051.timeline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.dec051.member.Member;




@Service
public class STSDAO {

	@Autowired
	ServletContext context;
	
	
	public TextData send_video(HttpServletRequest req) {
		System.out.println("send_video");
		
		Member mb = (Member) req.getSession().getAttribute("loginMember");
		String folderName = mb.getM_folder();
		String folder_dir = Constants.getPersonalFolderDir()+"/"+folderName+"/";
		folder_dir = folder_dir.replace("\\", "/");
		String videoFileName = (String) req.getSession().getAttribute("UploadedFileName");
		
		String postData = "folder_dir="+folder_dir+"&fileName="+videoFileName;
		String url ="http://localhost:8000/myapp/responseToSpring?";
		url += postData;
		TextData td = new TextData();
		
		try {
			
			URL obj = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) obj.openConnection();

			huc.setRequestMethod("GET");
			int responseCode = huc.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            String res = response.toString();
            JSONParser parser = new JSONParser();
            
            Object ob = parser.parse(res);
            JSONObject jo = (JSONObject)ob;
            
            String transcript = (String)jo.get("transcript");
            JSONArray words = (JSONArray)jo.get("words");
            JSONArray topWords = (JSONArray)jo.get("top_words");
                        
            
            td.setTranscript(transcript);
             
            ArrayList<String> td_topWords = new ArrayList<String>();
            ArrayList<WordAndTime> wat = new ArrayList<WordAndTime>();
            
            int topWordsize = topWords.size();
            int wordsize = words.size();
            
            for(int i=0; i<topWordsize; i++) {
            	JSONArray topword = (JSONArray) topWords.get(i);
            	td_topWords.add((String) topword.get(0));
            }
            
            
            for(int i=0; i<wordsize; i++) {
            	WordAndTime wAndT = new WordAndTime();
            	JSONObject word = (JSONObject)words.get(i);
                String w = (String) word.get("word");
                String timeString = (String) word.get("startTime");
                timeString = timeString.replace("s", "");
                double doubleTime = Double.parseDouble(timeString);
                Integer intTime = (int)Math.round(doubleTime);
                
                wAndT.setSerialNo(i);
                wAndT.setWord(w);
                wAndT.setSecond(intTime);
                
                wat.add(wAndT);
            }
            
            td.setTopWords(td_topWords);
            td.setWat(wat);

            
            in.close();
            
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return td;
			
	}
	
//	public void deleteVideo(HttpServletRequest req) {
//		
//		HttpSession hs = req.getSession(false);
//		String dir = Constants.getPersonalFolderDir();
//		Member mb = (Member) hs.getAttribute("loginMember");
//		System.out.println(dir+"/"+mb.getM_folder()+"/"+hs.getAttribute("UploadedFileName"));
//			
//		try {
//			if(hs.getAttribute("UploadedFileName")!=null) {
//				Path path = Paths.get(dir+"/"+mb.getM_folder()+"/"+hs.getAttribute("UploadedFileName"));
//				Files.delete(path);
//			}
//				
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	
//	}
	
}//class end
