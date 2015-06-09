package com.ramanclasses.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.ramanclasses.constants.Constants;

import com.ramanclasses.daoimpl.UserDetail;

public class Util {

	public static String covertToMd5(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());

	    byte byteData[] = md.digest();

	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < byteData.length; i++)
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		return sb.toString();

	}

	public static void setParameters(ModelAndView modelandview,UserDetail userdetail) {
		// TODO Auto-generated method stub
		if(userdetail!=null){
			modelandview.addObject(Constants.TITLE, "Raman Classes");
			modelandview.addObject(Constants.USERNAME,userdetail.getUsername());
			modelandview.addObject(Constants.ACTIVE_FROM,userdetail.getActiveFrom());
			modelandview.addObject(Constants.NAME,userdetail.getName());
			modelandview.addObject(Constants.USER_TYPE,userdetail.getUserType());
			modelandview.addObject(Constants.LAST_LOGIN,userdetail.getLastLogin());
			modelandview.addObject(Constants.EMAIL,userdetail.getEmail());
		}
		else{
			modelandview.addObject(Constants.TITLE, "Raman Classes");
			modelandview.addObject(Constants.USERNAME,"Admin");
			modelandview.addObject(Constants.ACTIVE_FROM,"Unknown");
			modelandview.addObject(Constants.NAME,"Your Name");
			modelandview.addObject(Constants.USER_TYPE,"Admin");
			modelandview.addObject(Constants.LAST_LOGIN,Constants.LAST_LOGIN);
			modelandview.addObject(Constants.EMAIL,Constants.EMAIL);
		}
	}

	
}
