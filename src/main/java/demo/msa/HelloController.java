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
	
	@Autowired
	private IRemoteService remoteService;

    @RequestMapping(method=RequestMethod.GET, path="/provider")
    public String provider() {
        return "MSA Say: Hello!!";
    }

    @RequestMapping(method=RequestMethod.GET, path="/customer")
    public String customer() {
        return restTemplate.getForEntity("http://MICRO-SERVICE/provider", String.class).getBody();
    }
    
    @RequestMapping(method=RequestMethod.GET, path="/cal")
    public String cal(Command c) {
    	System.out.println("a = " + c.getA() + ", b = " + c.getB());
    	return String.valueOf(remoteService.cal(c.getA(), c.getB()));
    }
}