package dwsc.eureka.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dwsc.eureka.management.dao.Film1;
import dwsc.eureka.management.dao.Film2;

@RestController
public class FilmController {
	@Autowired
	Film1 film1;
	
	@Autowired
	Film2 film2;

	@GetMapping("/sentence")
	public String getSentence() {
		return film1.getWord() + " " + film2.getWord();
	}
}