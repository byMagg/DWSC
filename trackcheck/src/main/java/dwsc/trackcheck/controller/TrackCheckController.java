package dwsc.trackcheck.controller;

import org.springframework.context.annotation.Bean;
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
	
	@Bean
	public void getToken() {
		String clientId = "533eefa5ec2e4315876edd6eb5926f74";
		String clientSecret = "f7ea363ba02a4a628fecacf0301c8609";

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		        .header("Content-Type", "application/x-www-form-urlencoded")
		        .uri(URI.create("https://accounts.spotify.com/api/token"))
		        .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret))
		        .build();

		try {
		    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		    String responseBody = response.body();
		    ObjectMapper mapper = new ObjectMapper();
		    JsonNode json = mapper.readTree(responseBody);
		    String accessToken = json.get("access_token").asText();
		    System.out.println("Access token: " + accessToken);
		    System.setProperty("SPOTIFY_TOKEN", accessToken);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}

	@GetMapping("/check/{name}")
	public ResponseEntity<String> checkTrackExists(@PathVariable String name) {
		String cover = "";
		String token = System.getProperty("SPOTIFY_TOKEN");
		System.out.println(token);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.header("Accept", "application/json")
				.header("Authorization", "Bearer " + token)
				.uri(URI.create("https://api.spotify.com/v1/search?type=track&limit=1&q=" + name)).build();

		ObjectMapper mapper = new ObjectMapper();
				
		try {
			String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
			JsonNode json = mapper.readTree(response);
			if (!json.get("tracks").get("total").asText().equals("0")) {
				cover = json.get("tracks").get("items").get(0).get("album").get("images").get(0).get("url").asText();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(cover, HttpStatus.OK);
	}
}
