package dwsc.trackinsert.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("trackcheck")
public interface TrackCheck {
	@GetMapping("/films/{film}")
	public String getFilm(@PathVariable String film);
}
