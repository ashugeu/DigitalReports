package com.ramanclasses.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ramanclasses.constants.Constants;
import com.ramanclasses.daoimpl.StatBox;
import com.ramanclasses.daoimpl.StudentForm;
import com.ramanclasses.daoimpl.User;
import com.ramanclasses.daoimpl.UserDetail;
import com.ramanclasses.services.AdminServiceImpl;
import com.ramanclasses.services.CommonServiceImpl;
import com.ramanclasses.services.StatBoxServiceImpl;
import com.ramanclasses.services.StudentFormServiceImpl;
import com.ramanclasses.util.Util;

public class AddAttributesController implements Controller{

	private UserDetail userDetail;
    private List<StatBox> statBox;
    private ModelAndView modelandview;
    private int isAddFieldActive=0;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
    	ApplicationContext context = 
    	    		new ClassPathXmlApplicationContext("Beans.xml");
    	int u_id = Integer.parseInt(request.getParameter("user"));
    	int page_id = Integer.parseInt(request.getParameter("id"));
    	
    	if(isAddFieldActive==1){
    		//add code for adding field to DB
    	}
    	if(page_id==101){
    		try{
    			modelandview =new ModelAndView("editStudentForm");
        		List<String> fields = StudentFormServiceImpl.getAllFieldsById(u_id);
        		modelandview.addObject(Constants.STUDENT_FORM_FIELDS,fields);
    		}catch(Exception ex){
    			System.out.println(ex.getMessage());
    		}
    		
    	}
    	else if(page_id==102){
	    	try{
	    		modelandview =new ModelAndView("addStudent");
	    		List<StudentForm> studentForm = getStudentFormData(u_id);
	    		modelandview.addObject(Constants.STUDENT_FORM_FIELDS,studentForm);
	    	}
	    	catch(Exception ex){
	    		System.out.println(ex.getMessage());
	    	}
    	}
    	
    	addHeaderAndLeftColumnAttributes(modelandview,u_id);
    	return modelandview;
	}
	private void addHeaderAndLeftColumnAttributes(ModelAndView modelandview,int u_id) {
		// TODO Auto-generated method stub
		try{
			User user = CommonServiceImpl.getUserById(u_id);
			modelandview.addObject(Constants.USER,user.getId());
			userDetail = AdminServiceImpl.getUserDetail(user.getEmail());
			statBox = (List<StatBox>) StatBoxServiceImpl.getStatBoxDetails(user.getId());
			modelandview.addObject(Constants.USER,user.getId());
			Util.setParameters(modelandview,userDetail);
			Util.setStatBoxParameters(modelandview, statBox);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	private List<StudentForm> getStudentFormData(int u_id) {
		// TODO Auto-generated method stub
		return StudentFormServiceImpl.getStudentFormFields(u_id);
	}
	
	public void setIsAddFieldActive(int isAddFieldActive) {
		this.isAddFieldActive = isAddFieldActive;
	}
}
