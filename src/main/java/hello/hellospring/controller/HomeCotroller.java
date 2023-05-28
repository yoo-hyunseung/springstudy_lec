package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCotroller {

    // home 화면 localhost:8080/ ->호출
    @GetMapping("/")
    public String Home(){
        return "home";
    }
}
