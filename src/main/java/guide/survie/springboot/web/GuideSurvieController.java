package guide.survie.springboot.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller")
public class GuideSurvieController {


    @GetMapping("/say-hi")
    public String sayHello() {
        return "Hi";
    }

    @GetMapping("/hi")
    public String sayHelloWithRequestParams(@RequestParam String name) {
        return "RequestParam : Hi " + name;
    }

    @GetMapping("/hi/{name}")
    public String sayHelloWithPathVariable(@PathVariable String name) {
        return "PathVariable : Hi " + name;
    }

}
