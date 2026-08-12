package server.auth.AuthServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/public-data")
    public String publicData() {
        return "public-data";
    }

    @GetMapping("/private-data")
    public String privateData() {
        return "private-data";
    }
}

