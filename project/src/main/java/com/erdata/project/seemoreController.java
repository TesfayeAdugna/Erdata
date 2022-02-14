package com.erdata.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class seemoreController {
    @Autowired
    private ChildrenService service;
    @GetMapping("/seemore/{id}")
    public String displayseemore(@PathVariable(name = "id") Long id, Model model){
        Children listentry = service.get(id);
        model.addAttribute("listentry", listentry);
        return "seemore";
    }
}
