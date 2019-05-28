package demo.msa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	
	@Autowired
	private RestTemplate restTemplate;

    @RequestMapping(method=RequestMethod.GET, path="/provider")
    public String provider() {
        return "MSA Say: Hello!!";
    }

    @RequestMapping(method=RequestMethod.GET, path="/customer")
    public String customer() {
        return restTemplate.getForEntity("http://MICRO-SERVICE/provider", String.class).getBody();
    }
}