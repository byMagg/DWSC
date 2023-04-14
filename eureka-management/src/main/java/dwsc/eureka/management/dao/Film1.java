package dwsc.eureka.management.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-film1")
public interface Film1 {
	@GetMapping("/")
	public String getWord();
}
