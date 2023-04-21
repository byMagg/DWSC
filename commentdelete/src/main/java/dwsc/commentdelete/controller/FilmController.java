package dwsc.commentdelete.controller;

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
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(
						"https://api.themoviedb.org/3/search/movie?api_key=7c88c4114677a284e792acd53302efb1&query="
								+ film))
				.build();

		ObjectMapper mapper = new ObjectMapper();

		boolean exists = false;

		try {
			String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
			JsonNode json = mapper.readTree(response);
			System.out.println(json.get("total_results").asText());
			if (!json.get("total_results").asText().equals("0"))
				exists = true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("MovieDB: " + exists, HttpStatus.OK);
	}
}
