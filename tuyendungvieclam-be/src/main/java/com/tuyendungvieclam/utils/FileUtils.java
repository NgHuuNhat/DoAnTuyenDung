package com.tuyendungvieclam.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
//import org.apache.commons.codec.binary.Base64;

public class FileUtils {
	
	public static String uploadFile(String base64, String fileName, String folder) {
		try {
			String root = "D:\\TuyenDungViecLam\\TUYENDUNGVIECLAM\\quanlydulich-fe\\src\\main\\webapp\\fileupload";
			File locationRoot = new File(root);
	        if (!locationRoot.exists()){//if not exist folder, system will create folder by directory
	        	locationRoot.mkdir();
	        }
	        
	        String sub = root + File.separator + folder;
	        File locationSub = new File(sub);
	        if (!locationSub.exists()){//if not exist folder, system will create folder by directory
	        	locationSub.mkdir();
	        }
	        
	        String date = DateUtils.convertDateToString(LocalDateTime.now(), DateUtils.FORMAT_YYMMDD);
	        String sub1 = sub + File.separator + date;
	        File locationSub1 = new File(sub1);
	        if (!locationSub1.exists()){//if not exist folder, system will create folder by directory
	        	locationSub1.mkdir();
	        }
	        
	    	String location = sub1 + File.separator + fileName;
	        File directory = new File(location);
	        if (directory.exists()){//if not exist folder, system will create folder by directory
	        	directory.delete();
	        }
	        FileOutputStream outputStream = new FileOutputStream(location);
//	        byte[] base64Byte = Base64.decodeBase64(base64.getBytes());
//	        outputStream.write(base64Byte);
	        outputStream.close();
	        return "fileupload" + File.separator + folder + File.separator + date + File.separator + fileName;
	    } catch (IOException e) {
	        System.out.println("save file by news exception ---" + e.toString());
	        return null;
	    }
	}
}
