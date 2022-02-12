package com.erdata.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class profileController {
    @Autowired
    private NewentryService service;
    @GetMapping("/profile")
    public String displayprofile(Model model){
        List<Newentry> listentry = service.listAll();
        model.addAttribute("listentry", listentry);
        return "profile";
    }
}
