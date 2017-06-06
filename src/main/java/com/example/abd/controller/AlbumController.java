package com.example.abd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.abd.model.Album;
import com.example.abd.services.AlbumServiceImpl;
import com.example.abd.services.ArtystaServiceImpl;
import com.example.abd.services.WydawcaServiceImpl;


@Controller 
@RequestMapping("/album") 
public class AlbumController {
	@Autowired 
	private AlbumServiceImpl albumService;
	@Autowired
	private ArtystaServiceImpl artystaService;
	@Autowired
	private WydawcaServiceImpl wydawcaService;
	
   
    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam(value = "page", required = false) Long page, ModelMap modelMap) {
    	if(page != null){
    		modelMap.put("albums", albumService.findAll((int)(long)page));
    	} else {
    		modelMap.put("albums", albumService.findAll(0));
    	}    		
        return "album/index";
    }
    
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
    	modelMap.put("artysci", artystaService.findAll());
    	modelMap.put("wydawcy", wydawcaService.findAll());
    	modelMap.put("album", new Album());
        return "album/add";
    }
    
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(@ModelAttribute("album") @Valid Album album, BindingResult bindingResult, ModelMap modelMap) {
    	if(bindingResult.hasErrors()){
    		modelMap.put("artysci", artystaService.findAll());
        	modelMap.put("wydawcy", wydawcaService.findAll());
    		return "album/add";
    	}    	
    	albumService.save(album);
        return "redirect:../album.html";
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	albumService.delete(albumService.findOne(id));
    	modelMap.put("albums", albumService.findAll(0));
    	return "album/index";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = true) int id, ModelMap modelMap) {
    	modelMap.put("artysci", artystaService.findAll());
    	modelMap.put("wydawcy", wydawcaService.findAll());
    	modelMap.put("albumEd", albumService.findOne(id));
        return "album/edit";
    }
    
    @RequestMapping(value="edit", method = RequestMethod.POST)
    public String edit(@RequestParam(value = "id", required = true) int id, @ModelAttribute("album") @Valid Album album, BindingResult bindingResult, ModelMap modelMap) {
    	
    	if(bindingResult.hasErrors()){
    		modelMap.put("artysci", artystaService.findAll());
        	modelMap.put("wydawcy", wydawcaService.findAll());
        	modelMap.put("albumEd", albumService.findOne(id));
    		return "album/edit";
    	}    	
    	albumService.save(album);
        return "redirect:../album.html";
    }
}	