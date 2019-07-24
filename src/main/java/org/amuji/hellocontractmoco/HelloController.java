package org.amuji.hellocontractmoco;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hellos")
public class HelloController {
    @GetMapping("/{id}")
    public String howToSayHello(@PathVariable("id") String id) {
        return String.format("%s, how do you do?", id);
    }
}
