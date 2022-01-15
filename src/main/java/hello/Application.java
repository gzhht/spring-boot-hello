package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Application {

    private String myName = "";

    @RequestMapping("/")
    public String home() {
        return "Hello k8s new digital world!";
    }

    @RequestMapping("/test")
    public String test() {
        return "test new API 123";
    }

    @RequestMapping("/name/{name}")
    public String getName(@PathVariable("name") String name) {
        return this.myName + " - your name" + name;
    }

    @PostMapping("/name")
    @ResponseStatus(HttpStatus.CREATED)
    public String createName(@RequestBody String name) {
        String mName = "my name: " + name;
        this.myName = mName;
        return mName;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
