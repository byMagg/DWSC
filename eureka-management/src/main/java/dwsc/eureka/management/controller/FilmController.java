package dwsc.eureka.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dwsc.eureka.management.dao.Film;

@RestController
public class FilmController {
	@Autowired
	Film filmService;

	@GetMapping("/films/{film}")
	public String getFilm(@PathVariable String film) {
		boolean exists = false;
		
		try {
			String result = filmService.getFilm(film);
			System.out.println(result);
			if(result != null) {
				if(result.split(" ")[1].equals("true")) exists = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists ? "Insertar" : "No insertar";
	}
}