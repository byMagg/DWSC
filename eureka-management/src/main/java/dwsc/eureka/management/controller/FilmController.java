package dwsc.eureka.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dwsc.eureka.management.dao.Film1;
import dwsc.eureka.management.dao.Film2;

@RestController
public class FilmController {
	@Autowired
	Film1 film1;

	@Autowired
	Film2 film2;

	@GetMapping("/films/{film}")
	public String getFilm(@PathVariable String film) {
		return (film1.getFilm(film) || film2.getFilm(film)) ? "Insertar" : "No insertar";
	}
}