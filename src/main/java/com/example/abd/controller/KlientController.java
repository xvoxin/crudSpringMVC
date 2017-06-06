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
import com.example.abd.model.Klient;
import com.example.abd.services.KlientServiceImpl;


@Controller 
@RequestMapping("/klient") 
public class KlientController {
	@Autowired 
	private KlientServiceImpl klientService;
	
   
    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam(value = "page", required = false) Long page, ModelMap modelMap) {
    	if(page != null){
    		modelMap.put("klients", klientService.findAll((int)(long)page));
    	} else {
    		modelMap.put("klients", klientService.findAll(0));
    	}    		
        return "klient/index";
    }
    
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	modelMap.put("klient", new Klient());
        return "klient/add";
    }
    
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(@ModelAttribute("klient") @Valid Klient klient, BindingResult bindingResult, ModelMap modelMap) {
    	if(bindingResult.hasErrors()){
            return "klient/add";
    	}    	
    	klientService.save(klient);
        return "redirect:../klient.html";
    }
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	klientService.delete(klientService.findOne(id));
    	modelMap.put("klients", klientService.findAll(0));
    	return "klient/index";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	modelMap.put("klientEd", klientService.findOne(id));
        return "klient/edit";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.POST)
    public String edit(@RequestParam(value = "id", required = true) int id, @ModelAttribute("klient") @Valid Klient klient, BindingResult bindingResult, ModelMap modelMap) {
    	
    	if(bindingResult.hasErrors()){
        	modelMap.put("klientEd", klientService.findOne(id));
    		return "klient/edit";
    	}    	
    	klientService.save(klient);
        return "redirect:../klient.html";
    }
}