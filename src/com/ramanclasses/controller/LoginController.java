package com.ramanclasses.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ramanclasses.daoimpl.StatBox;
import com.ramanclasses.daoimpl.User;
import com.ramanclasses.daoimpl.UserDetail;
import com.ramanclasses.services.AdminServiceImpl;
import com.ramanclasses.services.CommonServiceImpl;
import com.ramanclasses.services.StatBoxServiceImpl;
import com.ramanclasses.util.Util;
import com.ramanclasses.constants.Constants;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class LoginController implements Controller {

    private UserDetail userDetail;
    private List<StatBox> statBox;
    private ModelAndView modelandview;
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
    	
    	ApplicationContext context = 
    	    		new ClassPathXmlApplicationContext("Beans.xml");
    	
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        pass = Util.covertToMd5(pass);
        try{
        	Boolean userExists = checkUserPresent(email,pass);
        	if(userExists.equals(Constants.FALSE)){
        		return wrongUserPass();
        	}
        	User user = CommonServiceImpl.getUser(email);
        	String userType = user.getType();
        	if(userType.equals(Constants.ADMIN)){	
        		return setAdminSpecificData(user);
        	}
        	else if(userType.equals(Constants.STUDENT)){
        		 return setStudentSpecificData();
        	}
        }
        catch(Exception e){
        	System.out.println("Cannot find the user "+e);
        }
		
		return null;
    }
    
    private ModelAndView setStudentSpecificData() {
		// TODO Auto-generated method stub
    	modelandview =new ModelAndView("student_home");
		return modelandview;
	}

	private ModelAndView setAdminSpecificData(User user) {
		// TODO Auto-generated method stub
    	userDetail = AdminServiceImpl.getUserDetail(user.getEmail());
		statBox = (List<StatBox>) StatBoxServiceImpl.getStatBoxDetails(user.getId());
		modelandview = new ModelAndView("admin_home");
		modelandview.addObject(Constants.USER,user.getId());
		Util.setParameters(modelandview,userDetail);
		Util.setStatBoxParameters(modelandview, statBox);
		//commonDao.setLastLogin(user.getId());
		return modelandview;
	}

	private ModelAndView wrongUserPass() {
		// TODO Auto-generated method stub
    	modelandview = new ModelAndView("login_failed");
		modelandview.addObject(Constants.WRONG_USERNAME_PASSWORD, Constants.FALSE);
		return modelandview;
	}

	boolean checkUserPresent(String email, String pass){
    	return CommonServiceImpl.isUserExists(email, pass);
    }

}
