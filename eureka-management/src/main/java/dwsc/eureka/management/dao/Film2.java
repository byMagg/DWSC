package dwsc.eureka.management.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("eureka-film2")
public interface Film2 {
	@GetMapping("/films/{film}")
	public boolean getFilm(@PathVariable String film);
}
