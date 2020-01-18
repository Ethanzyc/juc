package com.ethan.juc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class JucApplication {

    public static void main(String[] args) {
        SpringApplication.run(JucApplication.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public String start() {
        return "juc started";
    }

}
