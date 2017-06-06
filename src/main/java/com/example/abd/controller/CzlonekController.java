package com.example.abd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.abd.model.Album;
import com.example.abd.model.Czlonek;
import com.example.abd.services.CzlonekServiceImpl;


@Controller 
@RequestMapping("/czlonek") 
public class CzlonekController {
	@Autowired 
	private CzlonekServiceImpl czlonekService;
	
   
    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam(value = "page", required = false) Long page, ModelMap modelMap) {
    	if(page != null){
    		modelMap.put("czloneks", czlonekService.findAll((int)(long)page));
    	} else {
    		modelMap.put("czloneks", czlonekService.findAll(0));
    	}    		
        return "czlonek/index";
    }
    
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	modelMap.put("czlonek", new Czlonek());
        return "czlonek/add";
    }
    
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(@ModelAttribute("czlonek") @Valid Czlonek czlonek, BindingResult bindingResult, ModelMap modelMap) {
    	if(bindingResult.hasErrors()){
            return "czlonek/add";
    	}    	
    	czlonekService.save(czlonek);
        return "redirect:../czlonek.html";
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	czlonekService.delete(czlonekService.findOne(id));
    	modelMap.put("albums", czlonekService.findAll(0));
    	return "czlonek/index";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	modelMap.put("czlonekEd", czlonekService.findOne(id));
        return "czlonek/edit";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.POST)
    public String edit(@RequestParam(value = "id", required = true) int id, @ModelAttribute("czlonek") @Valid Czlonek czlonek, BindingResult bindingResult, ModelMap modelMap) {
    	
    	if(bindingResult.hasErrors()){
        	modelMap.put("czlonekEd", czlonekService.findOne(id));
    		return "czlonek/edit";
    	}    	
    	czlonekService.save(czlonek);
        return "redirect:../czlonek.html";
    }
}