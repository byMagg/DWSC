package dwsc.trackcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TrackCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackCheckApplication.class, args);
	}

}
