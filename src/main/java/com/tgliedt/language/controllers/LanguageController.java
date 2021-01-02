package com.tgliedt.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tgliedt.language.models.Language;
import com.tgliedt.language.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
    
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }
    
    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("Language") Language Language) {
        return "/languages/new.jsp";
    }
    
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    @PostMapping("/languages")
    public String create(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
    	//the next two lines are so that Model attribute exists on execution of this method (So that the top table shows on errors)
    	List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        if (result.hasErrors()) {
            return "/languages/index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }

    
    @RequestMapping("/languages/{id}")
    public String Language(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
    	model.addAttribute(language);
        return "/languages/show.jsp";
    }
    
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
    	//the next two lines are so that Model attribute exists on execution of this method
    	List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
    	System.out.println("in Controller public String update");
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            languageService.updateLanguageF(language);
            return "redirect:/languages";
        }
    }
    
    
    
   
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
    
}
