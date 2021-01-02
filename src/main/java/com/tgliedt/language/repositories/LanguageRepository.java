package com.tgliedt.language.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tgliedt.language.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	// this method retrieves all the languages from the database
    List<Language> findAll();
    // this method finds languages with descriptions containing the search string
//    List<Language> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
    // this method deletes a Language that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
}
