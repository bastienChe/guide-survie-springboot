package guide.survie.springboot.web;

import ch.qos.logback.core.util.StringUtil;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GuideSurvieController {

    private String name;

    @GetMapping("/hi")
    public ResponseEntity<String> sayHelloWithRequestParams(@RequestParam String name) {
        return ResponseEntity.ok("RequestParam : Hi " + name);
    }

    @GetMapping("/hi/{name}")
    public ResponseEntity<String> sayHelloWithPathVariable(@PathVariable String name) {
        return ResponseEntity.ok("PathVariable : Hi " + name);
    }

    @GetMapping("/name")
    public ResponseEntity<String> sayHello() {
        return StringUtil.isNullOrEmpty(name) ? ResponseEntity.ok("No name set !") : ResponseEntity.ok(this.name);
    }

    @PostMapping("/name")
    public ResponseEntity<String> setName(@RequestBody String name) {
        this.name = name;
        return ResponseEntity.ok("name set !");
    }



}
