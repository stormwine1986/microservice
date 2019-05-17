package demo.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MSAApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(MSAApplication.class, args);
    }

}