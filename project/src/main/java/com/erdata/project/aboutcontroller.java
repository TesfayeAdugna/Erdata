package com.erdata.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class aboutcontroller {
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    
}
