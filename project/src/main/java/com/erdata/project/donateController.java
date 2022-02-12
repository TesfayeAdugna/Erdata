package com.erdata.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class donateController {
    
    @GetMapping("/donate")
    public String displaydonate(){
        return "donate";
    }
}
