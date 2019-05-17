package demo.msa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(method=RequestMethod.GET, path="/hello")
    public String index() {
        return "MSA Say: Hello!!";
    }
}