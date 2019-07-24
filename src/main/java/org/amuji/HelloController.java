package org.amuji;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/hellos")
public class HelloController {
    private List<Hello> patterns = new ArrayList<>();

    @GetMapping("/{id}")
    public String howToSayHello(@PathVariable("id") String id) {
        return String.format("%s, how do you do?", id);
    }

    @PostMapping
    public ResponseEntity<?> createHelloPatterns(@RequestBody List<Hello> newPatterns) {
        patterns.addAll(newPatterns);
        List<String> ids = IntStream.range(patterns.size() - newPatterns.size(), patterns.size())
                .mapToObj(String::valueOf)
                .collect(toList());

        return ResponseEntity
                .status(201)
                .body(ids);
    }
}
