package dwsc.eureka.management.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-film2")
public interface Film2 {
	@GetMapping("/")
	public String getWord();
}
