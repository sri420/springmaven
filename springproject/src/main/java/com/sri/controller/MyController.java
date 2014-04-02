package com.sri.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.sri.domain.Employee;
import com.sri.domain.FootballTeams;
import com.sri.service.EmployeeService;

@Controller
@RequestMapping("/MyController")
public class MyController {

	@Autowired
	@Qualifier("old")
	EmployeeService empService;
	
	/* @InitBinder
	 protected void initBinder(WebDataBinder binder) {
	        binder.setValidator(new EmployeeValidator());
	 }
	 */
	 
	// /MyController/welcomehttp?empno=100&empname=hello
	@RequestMapping(value="/welcomehttp", method = RequestMethod.GET)
	public String welcomeName(WebRequest req,ModelMap model) {
		empService.getEmployee(1);
 
		model.addAttribute("message", "SRI meenasdfds Received : welcomehttp:  -EmpNo: " + req.getParameter("empno")  + ":EmpName:" + req.getParameter("empname"));
			return "hello";
 
	}
	
	@RequestMapping("")
    public String sayDefaultMessage(ModelMap model) {
		model.addAttribute("message", "stupid sridhar wants sandhya saumya");
 		return "hello";
    }

	// /MyController/hello
	@RequestMapping(value="/hello")
	public String sayHello(ModelMap model) {
			model.addAttribute("message", "hello");
	 		return "hello";
	}
	
	// /MyController/getPathParams/sridhar/chennai
	@RequestMapping(value="/getPathParams/{name}/{city}", method = RequestMethod.GET)
	public String getNameCity(@PathVariable String name,@PathVariable String city, ModelMap model) {
 
		model.addAttribute("message", "Received name: " + name + " and city :" + city);
		return "hello";
	}
	
	
	// /MyController/getBindData/sridhar/chennai
	@RequestMapping(value="/getBindData/{empno}/{empname}", method = RequestMethod.GET)
	public String welcomeName(@ModelAttribute Employee emp, ModelMap model) {
 
		model.addAttribute("message", "Received  -EmpNo: " + emp.getEmpno() + ":EmpName:" + emp.getEmpname());
		return "hello";
	}

	// /MyController/getBindData/sridhar/chennai
	@RequestMapping(value="/validateData", method = RequestMethod.POST)
	public String validateData(@Valid @ModelAttribute Employee emp, BindingResult result, ModelMap model) {
 
		
		//new EmployeeValidator().validate(emp, result);
		String strmessage="";
		if(result.hasErrors()){
			for (Object object : result.getAllErrors()) {
			if (object instanceof FieldError) {
				FieldError fieldError = (FieldError) object;

				strmessage+="<BR/>" + fieldError.getField() + ":"
						+ fieldError.getCode();
				

			}

			/*if (object instanceof ObjectError) {
				ObjectError objectError = (ObjectError) object;

			}*/
		}
			model.addAttribute("message", strmessage);
			System.out.println("Error: " + strmessage);
		} else {
			model.addAttribute("message", "Received  -EmpNo: " + emp.getEmpno() + ":EmpName:" + emp.getEmpname());
		}
		return "hello";
	}
	
	 @RequestMapping(value = "/findEmp", method = RequestMethod.GET, params="!empno")
	    public String findEmp(Model model) {
		 model.addAttribute("message", "findEmp has Received without empno" );
	 	return "hello";
	}
	 @RequestMapping(value = "/findEmp", method = RequestMethod.GET, params="empno")
	    public String findEmp(@RequestParam("empno") String empno, Model model) {
		 model.addAttribute("message", "findEmp has Received  : " + empno );
	 	return "hello";
	} 
	
	
	
	@RequestMapping(value="/doprocess", method = RequestMethod.GET)
	public String doProcess(@RequestParam("empno") String empno, @RequestParam(value="empname" ,defaultValue="sri") String empname, ModelMap model) {
			model.addAttribute("message", "Received  : " + empno + empname);
	 		return "hello";
	}
	
	@RequestMapping(value="/football-page")
	public String footballPage(ModelMap model) {
	  
	List<String> teams = new ArrayList<String>();  
	teams.add("Bavaria Munich");  
	teams.add("Borussia Dortmund");  
	teams.add("Real Madrid");  
	teams.add("Barcelona");  
	  
	model.addAttribute("teamsList", teams);  
	model.addAttribute("footballTeams", new FootballTeams());  
	  
	return "football-form";  
	}  
	  
	@RequestMapping(value="/football-result")  
	public String processTeams(FootballTeams footballTeams,ModelMap model) {  
		model.addAttribute("teamsList", footballTeams);
		return "football-result";  
	}  


}
