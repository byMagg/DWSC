package dwsc.frontuser.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;


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
import dwsc.frontuser.model.Mensaje;
import dwsc.frontuser.model.TipoNivelInteres;
import dwsc.frontuser.model.Track;

@Controller
public class FrontUserController {
	private static String trackSearchURL ="http://localhost:8081";
	private static String trackCommentURL ="http://localhost:8082";
	private static String servletURL ="http://localhost:8080/ProductorConsumidor/servlet";
	private static String trackInsertURL ="http://localhost:8084";

	
	@GetMapping("/")
	public String searchList(Model model) {
		ArrayList<Track> tracks = new ArrayList<Track>();
		try {
			tracks.addAll(new ArrayList<Track>(Arrays.asList((new RestTemplate().getForEntity(trackSearchURL + "/tracks", Track[].class).getBody()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
	    try {
	        ResponseEntity<String> response = new RestTemplate().getForEntity(servletURL, String.class);
	        String responseBody = response.getBody();
	        ArrayList<String> mensajesTemp = new ArrayList<String>();
	        String[] splitted = responseBody.split("Mensaje ");
	        Collections.addAll(mensajesTemp, splitted);
	        mensajesTemp.remove(0);
	        for (String string : mensajesTemp) {
	        	String trimmed = string.trim();
	        	String clean = trimmed.substring(0, trimmed.length() - 1).trim();
	        	mensajes.add(parseMensaje(clean.substring(1, clean.length() - 1)));
			}
			model.addAttribute("mensajes", mensajes);
	        // Haz algo con el cuerpo de la respuesta
	    } catch (RestClientException e) {
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
			restTemplate.getForEntity(trackInsertURL + "/tracks/" + comment.getTrackid() + "/score", Track.class).getBody();

			savedComment = response.getBody();
			System.out.println(savedComment.getId());
			
			model.addAttribute("track", savedComment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/tracks/" + savedComment.getTrackid();
	}
	
	public static Mensaje parseMensaje(String mensajeString) {
			String[] split = mensajeString.split(", ");
			Date fecha = null;
			TipoNivelInteres nivelInteres = null;
			String descripcionCorta = null;
			String descripcionLarga = null;
			for (int i = 0; i < split.length; i++) {
				String value = split[i].split("=")[1];
				if(i == 0) {
			        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			        try {
			        	fecha = dateFormat.parse(value);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if(i == 1) {
				    nivelInteres = TipoNivelInteres.valueOf(value);
				} else if(i == 2) {
					descripcionCorta = value;
				} else if(i == 3) {
					descripcionLarga = value;
				}
			}

			Mensaje mensaje = new Mensaje(fecha, nivelInteres, descripcionCorta, descripcionLarga);
			return mensaje;
	    
	}
}
