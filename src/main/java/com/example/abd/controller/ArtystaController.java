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
import com.example.abd.model.Artysta;
import com.example.abd.services.ArtystaServiceImpl;


@Controller 
@RequestMapping("/artysta") 
public class ArtystaController {
	@Autowired 
	private ArtystaServiceImpl artystaService;
	
   
    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam(value = "page", required = false) Long page, ModelMap modelMap) {
    	if(page != null){
    		modelMap.put("artystas", artystaService.findAll((int)(long)page));
    	} else {
    		modelMap.put("artystas", artystaService.findAll(0));
    	}    		
        return "artysta/index";
    }
    
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	modelMap.put("artysta", new Artysta());
        return "artysta/add";
    }
    
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(@ModelAttribute("artysta") @Valid Artysta artysta, BindingResult bindingResult, ModelMap modelMap) {
    	if(bindingResult.hasErrors()){
            return "artysta/add";
    	}    	
    	artystaService.save(artysta);
        return "redirect:../artysta.html";
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	artystaService.delete(artystaService.findOne(id));
    	modelMap.put("artystas", artystaService.findAll(0));
    	return "artysta/index";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	modelMap.put("artystaEd", artystaService.findOne(id));
        return "artysta/edit";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.POST)
    public String edit(@RequestParam(value = "id", required = true) int id, @ModelAttribute("artysta") @Valid Artysta artysta, BindingResult bindingResult, ModelMap modelMap) {
    	
    	if(bindingResult.hasErrors()){
        	modelMap.put("artystaEd", artystaService.findOne(id));
    		return "artysta/edit";
    	}    	
    	artystaService.save(artysta);
        return "redirect:../artysta.html";
    }
}