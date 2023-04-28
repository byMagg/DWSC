package dwsc.frontgestor.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

import dwsc.frontgestor.model.Track;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FrontGestorController {
	private static String trackInsertURL ="http://localhost:8084";
	private static String mainURL ="http://localhost:8000";

	
	@GetMapping("/")
	public String searchList(Model model) {
		
		return "index";
	}
	
	@PostMapping("/tracks")
	public String insertTrack(@ModelAttribute Track track, Model model) {
		Track savedTrack = null;
		System.out.println(track.getName());
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Track> request = new HttpEntity<>(track, headers);

			System.out.println(request.getBody().getCover());
			ResponseEntity<Track> response = restTemplate.postForEntity(trackInsertURL + "/tracks", request, Track.class);
			savedTrack = response.getBody();
			System.out.println(savedTrack.getId());
			
			model.addAttribute("track", savedTrack);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:" + mainURL + "/tracks/" + savedTrack.getId();
	}
	
}
