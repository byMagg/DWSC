package dwsc.frontuser.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import dwsc.tracksearch.model.Track;

@Controller
public class FrontUserController {
	private static String trackSearchURL ="http://localhost:8081";
	
	@GetMapping("/")
	public String searchList(Model model) {
		ArrayList<Track> tracks = new ArrayList<Track>();
		try {
			tracks.addAll(new ArrayList<Track>(Arrays.asList((new RestTemplate().getForEntity(trackSearchURL + "/tracks", Track[].class).getBody()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tracks", tracks);
		
		return "index";
	}
	
	@GetMapping("/search")
	public String searchTrackByName(@RequestParam(name = "name") String name, Model model) {
		ArrayList<Track> tracks = new ArrayList<Track>();
		if(name.isBlank()) return "redirect:/";
		try {
			tracks.addAll(new ArrayList<Track>(Arrays.asList((new RestTemplate().getForEntity(trackSearchURL + "/seach/" + name, Track[].class).getBody()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tracks", tracks);
		
		return "index";
	}
	
	@GetMapping("/tracks/{id}")
	public String getTrackById(@PathVariable String id, Model model) {
		Track track = new Track();
		try {
			track = new RestTemplate().getForEntity(trackSearchURL + "/tracks/" + id, Track.class).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("track", track);
		
		return "track";
	}
}
