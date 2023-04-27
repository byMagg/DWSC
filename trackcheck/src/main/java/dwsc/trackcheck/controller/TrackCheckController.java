package dwsc.trackcheck.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TrackCheckController {

	@GetMapping("/check/{name}")
	public ResponseEntity<Boolean> checkTrackExists(@PathVariable String name) {
		boolean exists = false;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.header("Accept", "application/json")
				.header("Authorization", "Bearer BQCqMa80nMrVNmhQ0_yaeEbODJAKjB30d0aXmHNjwUYlz0Cs7plfWDZ1fru5s96RH4a__8MkQ-GDKD8yuXAQqKDbp8IEpwQY6swmEVCEiyOZTNg2ytpl")
				.uri(URI.create("https://api.spotify.com/v1/search?type=track&limit=1&q=" + name)).build();

		ObjectMapper mapper = new ObjectMapper();
				
		try {
			String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
			JsonNode json = mapper.readTree(response);
			if (!json.get("tracks").get("total").asText().equals("0")) exists = true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(exists, HttpStatus.OK);
	}
}
