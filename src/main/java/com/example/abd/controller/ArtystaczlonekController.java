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
import com.example.abd.model.Artystaczlonek;
import com.example.abd.services.ArtystaServiceImpl;
import com.example.abd.services.ArtystaczlonekServiceImpl;
import com.example.abd.services.CzlonekServiceImpl;


@Controller 
@RequestMapping("/artystaczlonek") 
public class ArtystaczlonekController {
	@Autowired 
	private ArtystaczlonekServiceImpl artystaczlonekService;
	@Autowired 
	private ArtystaServiceImpl artystaService;
	@Autowired
	private CzlonekServiceImpl czlonekService;
	
	
   
    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam(value = "page", required = false) Long page, ModelMap modelMap) {
    	if(page != null){
    		modelMap.put("artystaczloneks", artystaczlonekService.findAll((int)(long)page));
    	} else {
    		modelMap.put("artystaczloneks", artystaczlonekService.findAll(0));
    	}    		
        return "artystaczlonek/index";
    }
    
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	modelMap.put("artysci", artystaService.findAll());
    	modelMap.put("czlonki", czlonekService.findAll());
    	modelMap.put("artystaczlonek", new Artystaczlonek());
        return "artystaczlonek/add";
    }
    
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(@ModelAttribute("artystaczlonek") @Valid Artystaczlonek artystaczlonek, BindingResult bindingResult, ModelMap modelMap) {
    	if(bindingResult.hasErrors()){
            return "artystaczlonek/add";
    	}    	
    	artystaczlonekService.save(artystaczlonek);
        return "redirect:../artystaczlonek.html";
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	artystaczlonekService.delete(artystaczlonekService.findOne(id));
    	modelMap.put("albums", artystaczlonekService.findAll(0));
    	return "artystaczlonek/index";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	modelMap.put("artysci", artystaService.findAll());
    	modelMap.put("czlonki", czlonekService.findAll());
    	modelMap.put("artystaczlonekEd", artystaczlonekService.findOne(id));
        return "artystaczlonek/edit";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.POST)
    public String edit(@RequestParam(value = "id", required = true) int id, @ModelAttribute("artystaczlonek") @Valid Artystaczlonek artystaczlonek, BindingResult bindingResult, ModelMap modelMap) {
    	
    	if(bindingResult.hasErrors()){
    		return "artystaczlonek/edit";
    	}    	
    	artystaczlonekService.save(artystaczlonek);
        return "redirect:../artystaczlonek.html";
    }
}