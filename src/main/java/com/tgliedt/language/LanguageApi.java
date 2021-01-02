package com.tgliedt.language;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tgliedt.language.models.Language;
import com.tgliedt.language.services.LanguageService;

@RestController
public class LanguageApi {
	private final LanguageService languageService;
    public LanguageApi(LanguageService languageService){
        this.languageService = languageService;
    }
    @RequestMapping("/api/languages")
    public List<Language> index() {
        return languageService.allLanguages();
    }
    
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
        Language language = new Language(name, creator, version);
        return languageService.createLanguage(language);
    }
    
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = languageService.findLanguage(id);
        return language;
    }
    
    @RequestMapping(value="/api/languages/{id}/edit", method=RequestMethod.PUT)
	public Language update(@ModelAttribute("language") Language language) {
    	System.out.println("in LanguageAPI public Language update");
		Language updateLanguageF = languageService.updateLanguageF(language);
		return updateLanguageF;
	}
    //the method below is for update using back end
    @RequestMapping(value="/api/languages/{id}/edit2", method=RequestMethod.PUT)
	public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Language updateLanguage = languageService.updateLanguage(id, name, creator, version);
		return updateLanguage;
	}
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }
}
