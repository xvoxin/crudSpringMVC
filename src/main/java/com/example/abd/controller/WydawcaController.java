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
import com.example.abd.model.Wydawca;
import com.example.abd.services.WydawcaServiceImpl;

@Controller 
@RequestMapping("/wydawca") 
public class WydawcaController {
	@Autowired 
	private WydawcaServiceImpl wydawcaService;
	
   
    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam(value = "page", required = false) Long page, ModelMap modelMap) {
    	if(page != null){
    		modelMap.put("wydawcas", wydawcaService.findAll((int)(long)page));
    	} else {
    		modelMap.put("wydawcas", wydawcaService.findAll(0));
    	}    		
        return "wydawca/index";
    }
    
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	modelMap.put("wydawca", new Wydawca());
        return "wydawca/add";
    }
    
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(@ModelAttribute("wydawca") @Valid Wydawca wydawca, BindingResult bindingResult, ModelMap modelMap) {
    	if(bindingResult.hasErrors()){
            return "wydawca/add";
    	}    	
    	wydawcaService.save(wydawca);
        return "redirect:../wydawca.html";
    }
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	wydawcaService.delete(wydawcaService.findOne(id));
    	modelMap.put("albums", wydawcaService.findAll(0));
    	return "wydawca/index";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	modelMap.put("wydawcaEd", wydawcaService.findOne(id));
        return "wydawca/edit";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.POST)
    public String edit(@RequestParam(value = "id", required = true) int id, @ModelAttribute("wydawca") @Valid Wydawca wydawca, BindingResult bindingResult, ModelMap modelMap) {
    	
    	if(bindingResult.hasErrors()){
        	modelMap.put("wydwacaEd", wydawcaService.findOne(id));
    		return "wydawca/edit";
    	}    	
    	wydawcaService.save(wydawca);
        return "redirect:../wydawca.html";
    }
}