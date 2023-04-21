package dwsc.trackcheck.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("eureka-film")
public interface Film {
	@GetMapping("/films/{film}")
	public String getFilm(@PathVariable String film);
}
