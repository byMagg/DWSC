<<<<<<< HEAD
package dwsc.eureka.film1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	@Value("${words}")
	private String words;

	@GetMapping("/")
	public ResponseEntity<String> getWord() {
		String[] wordsArray = words.split(",");
		int index = (int) Math.round(Math.random() * (wordsArray.length - 1));
		String word = wordsArray[index];
		return new ResponseEntity<>(word, HttpStatus.OK);
	}
}
=======
package dwsc.eureka.film1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	@Value("${words}")
	private String words;

	@GetMapping("/")
	public ResponseEntity<String> getWord() {
		String[] wordsArray = words.split(",");
		int index = (int) Math.round(Math.random() * (wordsArray.length - 1));
		String word = wordsArray[index];
		return new ResponseEntity<>(word, HttpStatus.OK);
	}
}
>>>>>>> f19116a36a4f58ebead523faac2f319d707fb7ce
