package com.tgliedt.language.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tgliedt.language.models.Language;
import com.tgliedt.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	// adding the language repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    
    public List<Language> getLanguages(){
		return languageRepository.findAll();
	}
    // creates a language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

//  update a language- for front end
    public Language updateLanguageF(Language language) {
    	return languageRepository.save(language);
    }
//    
//  update a language- for back end
  public Language updateLanguage(Long id, String name, String creator, String version) {
  	if (languageRepository.existsById(id)) { // If language is found with this id
  		Language thisLanguage = findLanguage(id); // Get the language 
  		thisLanguage.setName(name);
  		thisLanguage.setCreator(creator);
  		thisLanguage.setVersion(version);
  		languageRepository.save(thisLanguage); // Save changes
  		return thisLanguage;
  	} else {
  		return null;
  	}
  }
    
    public void deleteLanguage(Long id) {
    	if (languageRepository.existsById(id)) {
    		languageRepository.deleteById(id);
    	}
	}
}
