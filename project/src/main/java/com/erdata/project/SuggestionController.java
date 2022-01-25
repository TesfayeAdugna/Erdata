package com.erdata.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SuggestionController {
    @Autowired
    private SuggestionService service;
    @GetMapping("/admin")
    public String suggested(Model model) {
        List<Suggestion> listsuggest = service.listAll();
        model.addAttribute("listsuggest", listsuggest);
        System.out.print("Get /");
        return "admin";
    }
    @GetMapping("/suggestion")
    public String suggest(Model model){
        model.addAttribute("suggest", new Suggestion());
        return "suggestion";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String suggestions(@ModelAttribute("suggest") Suggestion suggestion){
        service.save(suggestion);
        return "redirect:/";
    }
}
