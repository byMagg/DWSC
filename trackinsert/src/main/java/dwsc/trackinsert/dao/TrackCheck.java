package dwsc.trackinsert.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("trackcheck")
public interface TrackCheck {
	@GetMapping("/check/{name}")
	public String checkTrackExists(@PathVariable(value="name") String name);
}
