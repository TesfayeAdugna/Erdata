package com.erdata.project;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SuggestionController{
    @Autowired
    private SuggestionService service;


    @Autowired
    private ChildrenService services;

    
    @GetMapping("/admin")
    public String suggested(Model model) {
        List<Suggestion> listsuggest = service.listAll();
        model.addAttribute("listsuggest", listsuggest);

        List<Children> listentry = services.listAll();
        model.addAttribute("listentry", listentry);

        System.out.print("Get /");
        return "admin";
    }
    @GetMapping("/suggestion")
    public String suggest(Model model){
        model.addAttribute("suggest", new Suggestion());
        return "suggestion";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String suggestions(@ModelAttribute("suggest") @Valid Suggestion suggestion, Errors errors){
        if (errors.hasErrors()) {
            return "suggestion";
        }
        service.save(suggestion);
        return "redirect:/";
    }
}
