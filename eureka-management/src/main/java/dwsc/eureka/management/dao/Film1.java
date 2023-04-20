<<<<<<< HEAD
package dwsc.eureka.management.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("eureka-film1")
public interface Film1 {
	@GetMapping("/films/{film}")
	public boolean getFilm(@PathVariable String film);
}
=======
package dwsc.eureka.management.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-film1")
public interface Film1 {
	@GetMapping("/")
	public String getWord();
}
>>>>>>> f19116a36a4f58ebead523faac2f319d707fb7ce
