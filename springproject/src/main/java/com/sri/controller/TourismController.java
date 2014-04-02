package com.sri.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sri.domain.Tourism;

@Controller  
@RequestMapping("/TourismController")
public class TourismController {  
  
@RequestMapping(value="/tourism-page")  
public String tourismPage(ModelMap mav) {  
  
Map<String, String> countries = new HashMap<String, String>();  
countries.put("UKR", "Ukraine");  
countries.put("ENG", "England");  
countries.put("USA", "United States");  
  
mav.addAttribute("countriesMap", countries);  
mav.addAttribute("tourism", new Tourism());  
  
return "tourism-form";  
}  
  
@RequestMapping(value="/tourism-result") 

public String processTourism(@ModelAttribute Tourism tourism ,ModelMap mav) {  
mav.addAttribute("tourism", tourism);    
return "tourism-result";  
}  
  
}  