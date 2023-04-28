package dwsc.frontgestor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import dwsc.frontgestor.model.Track;
import dwsc.frontgestor.model.Comment;

@Controller
public class FrontGestorController {
	private static String trackInsertURL = "http://localhost:8084";
	private static String trackCommentURL = "http://localhost:8082";
	private static String commentDeleteURL = "http://localhost:8083";
	private static String mainURL = "http://localhost:8000";

	@GetMapping("/")
	public String searchList(Model model) {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		try {
			comments.addAll(new ArrayList<Comment>(Arrays.asList((new RestTemplate()
					.getForEntity(trackCommentURL + "/tracks/comments", Comment[].class).getBody()))));

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("comments", comments);
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
			ResponseEntity<Track> response = restTemplate.postForEntity(trackInsertURL + "/tracks", request,
					Track.class);
			savedTrack = response.getBody();
			System.out.println(savedTrack.getId());

			model.addAttribute("track", savedTrack);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:" + mainURL + "/tracks/" + savedTrack.getId();
	}

	@PostMapping("/tracks/comments/{id}")
	public String deleteComment(@PathVariable Long id, Model model) {
		try {
			RestTemplate restTemplate = new RestTemplate();

			restTemplate.delete(commentDeleteURL + "/tracks/comments/" + id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/";
	}

}
