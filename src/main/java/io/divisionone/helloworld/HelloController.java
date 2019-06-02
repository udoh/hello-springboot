package io.divisionone.helloworld;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    private static final Logger lo = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/api/v1/status")
    public ResponseEntity<?> getStatus() {
        return ResponseEntity.ok("Hello world!");
    }
}
