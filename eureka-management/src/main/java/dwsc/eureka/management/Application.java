package dwsc.eureka.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
<<<<<<< HEAD
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
=======
import org.springframework.cloud.openfeign.EnableFeignClients;
>>>>>>> f19116a36a4f58ebead523faac2f319d707fb7ce

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application {
<<<<<<< HEAD
	
=======

>>>>>>> f19116a36a4f58ebead523faac2f319d707fb7ce
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
