package hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class SayHelloController {

    public static final List<String> GREETINGS = List.of("Hi there", "Greetings", "Salutations");

    @GetMapping("/")
    public String home() {
        log.info("Access /");
        return "Hi!";
    }

    @GetMapping("/greeting")
    public String greet() {
        log.info("Access /greeting");

        Random random = new Random();
        int randomNumber = random.nextInt(GREETINGS.size());

        return GREETINGS.get(randomNumber);
    }
}