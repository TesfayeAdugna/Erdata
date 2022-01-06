package com.erdata.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewEntryController {

    @GetMapping("/newentry")
    public String newentry(){
        return "newentry";
    }
}
