package dwsc.trackcomment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TrackCommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackCommentApplication.class, args);
	}

}
