package com.ramanclasses.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ramanclasses.constants.Constants;
import com.ramanclasses.daoimpl.StudentForm;
import com.ramanclasses.services.StudentFormServiceImpl;

public class AddAttributesController implements Controller{

	private ModelAndView modelandview;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Ashish");
    	ApplicationContext context = 
    	    		new ClassPathXmlApplicationContext("Beans.xml");
    	
    	 int u_id = Integer.parseInt(request.getParameter("user"));
    	try{
    		List<StudentForm> studentForm = getStudentFormData(u_id);
    		modelandview = new ModelAndView("addStudent");
    		modelandview.addObject(Constants.STUDENT_FORM_FIELDS,studentForm);
    	}
    	catch(Exception ex){
    		System.out.println(ex.getMessage());
    	}
    	return modelandview;
	}
	private List<StudentForm> getStudentFormData(int u_id) {
		// TODO Auto-generated method stub
		return StudentFormServiceImpl.getStudentFormFields(u_id);
	}
	

}
