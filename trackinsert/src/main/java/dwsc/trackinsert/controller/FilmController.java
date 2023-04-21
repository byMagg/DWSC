package dwsc.trackinsert.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FilmController {

	@GetMapping("/films/{film}")
	public ResponseEntity<String> getFilm(@PathVariable String film) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().header("Accept", "application/json")
				.uri(URI.create("https://omdbapi.com/?apikey=95303372&t=" + film)).build();

		ObjectMapper mapper = new ObjectMapper();

		boolean exists = false;

		try {
			String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
			JsonNode json = mapper.readTree(response);
			System.out.println(json.get("Response").asText());
			if (!json.get("Response").asText().equals("False"))
				exists = true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("OMDB: " + exists, HttpStatus.OK);
	}
}
