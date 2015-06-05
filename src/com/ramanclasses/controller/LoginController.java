package com.ramanclasses.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ramanclasses.dao.CommonDao;
import com.ramanclasses.daoimpl.AdminDaoImpl;
import com.ramanclasses.daoimpl.CommonDaoImpl;
import com.ramanclasses.daoimpl.User;
import com.ramanclasses.daoimpl.UserDetail;
import com.ramanclasses.util.Util;
import com.ramanclasses.constants.Constants;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LoginController implements Controller {

    private UserDetail userDetail;
   
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
    	
    	 
    	ApplicationContext context = 
    	    		new ClassPathXmlApplicationContext("Beans.xml");
    	    	 
    	CommonDaoImpl commonDao = (CommonDaoImpl) context.getBean("commonDao");
    	AdminDaoImpl adminDao = (AdminDaoImpl) context.getBean("adminDao");
    	
    	
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        ModelAndView modelandview;
        pass = Util.covertToMd5(pass);
        try{
        	User user = commonDao.getUser(email,pass);
        	String userType = user.getType();
        	if(userType.equals(Constants.ADMIN)){	
        		userDetail = adminDao.getUserDetail(user.getEmail());
        		modelandview = new ModelAndView("admin_home");
        		Util.setParameters(modelandview,userDetail);
        		return modelandview;
        	}
        	else if(user.getType() == Constants.STUDENT){
        		 modelandview =new ModelAndView("student_home");
        		 return modelandview;
        	}
        }
        catch(Exception e){
        	
        	System.out.println("Cannot find the user "+e);
        }
		
		return null;
    }

}
