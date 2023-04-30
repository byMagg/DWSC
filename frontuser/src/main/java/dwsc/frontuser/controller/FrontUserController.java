package dwsc.frontuser.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import dwsc.frontuser.model.Comment;
import dwsc.frontuser.model.Track;

@Controller
public class FrontUserController {
	private static String trackSearchURL ="http://localhost:8081";
	private static String trackCommentURL ="http://localhost:8082";
	private static String servletURL ="http://localhost:8080/ProductorConsumidor/servlet";

	
	@GetMapping("/")
	public String searchList(Model model) {
		ArrayList<Track> tracks = new ArrayList<Track>();
		try {
			tracks.addAll(new ArrayList<Track>(Arrays.asList((new RestTemplate().getForEntity(trackSearchURL + "/tracks", Track[].class).getBody()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tracks", tracks);
		model.addAttribute("field", "name");
		
		return "index";
	}
	
	@GetMapping("/search")
	public String searchTrackByField(@RequestParam(defaultValue = "name") String field, @RequestParam String q, Model model) {
		ArrayList<Track> tracks = new ArrayList<Track>();
		if(q.isBlank()) return "redirect:/";
		try {
			tracks.addAll(new ArrayList<Track>(Arrays.asList((new RestTemplate().getForEntity(trackSearchURL + "/search?field=" + field + "&q=" + q, Track[].class).getBody()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tracks", tracks);
		model.addAttribute("field", field);
		
		return "index";
	}
	
	@GetMapping("/tracks/{id}")
	public String getTrackById(@PathVariable String id, Model model) {
		Track track = new Track();
		ArrayList<Comment> comments = new ArrayList<Comment>();
		try {
			track = new RestTemplate().getForEntity(trackSearchURL + "/tracks/" + id, Track.class).getBody();
			comments.addAll(new ArrayList<Comment>(Arrays.asList((new RestTemplate().getForEntity(trackCommentURL + "/tracks/" + id + "/comments", Comment[].class).getBody()))));

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("track", track);
		model.addAttribute("comments", comments);
		
		return "track";
	}
	
	@PostMapping("/comments")
	public String insertComment(@ModelAttribute Comment comment , Model model) {
		Comment savedComment = null;
		System.out.println(comment.getTrackid());
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Comment> request = new HttpEntity<>(comment, headers);

			System.out.println(request.getBody().getContent());
			ResponseEntity<Comment> response = restTemplate.postForEntity(trackCommentURL + "/comment", request, Comment.class);
			savedComment = response.getBody();
			System.out.println(savedComment.getId());
			
			model.addAttribute("track", savedComment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/tracks/" + savedComment.getTrackid();
	}
	
	@GetMapping("/news")
	public String getNews(Model model) {
	    try {
	        ResponseEntity<String> response = new RestTemplate().getForEntity(servletURL, String.class);
	        String responseBody = response.getBody();
	        System.out.println(responseBody);
	        // Haz algo con el cuerpo de la respuesta
	    } catch (RestClientException e) {
	        e.printStackTrace();
	    }
	    return "index";
	}
}
