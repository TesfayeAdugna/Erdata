package com.erdata.project;
import java.util.Optional;
import java.util.List;

import javax.validation.Valid;

import com.erdata.project.Security.User;

import com.erdata.project.Security.UserRepository;

import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SuggestionController{
    @Autowired
    private SuggestionService service;
 
    @Autowired
    private SuggestionRepository repo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChildrenService services;

    
    @GetMapping("/admin")
    public String suggested(Model model) {
        List<Suggestion> listsuggest = service.listAll();
        model.addAttribute("listsuggest", listsuggest);

        List<Children> listentry = services.listAll();
        model.addAttribute("listentry", listentry);

        List<User> user=(List<User>)userRepository.findAll();
        model.addAttribute("userlist", user);

        System.out.print("Get /");
        return "admin";
    }
    @GetMapping("/suggestion")
    public String suggest(Model model){
        model.addAttribute("suggest", new Suggestion());
        return "suggestion";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String suggestions(@AuthenticationPrincipal User user, @ModelAttribute("suggest") @Valid Suggestion suggestion, Errors errors){
        if (errors.hasErrors()) {
            return "suggestion";
        }
        suggestion.setUser(user);
        service.save(suggestion);
        return "redirect:/";
    }

    @GetMapping("/erase/{id}")
    public String eraseSuggestion(@PathVariable("id") long id, Model model) {
        Suggestion suggest = repo.findById(id).get();
          
        repo.delete(suggest);
        return "redirect:/admin";
    }
    
    @GetMapping("/cancel/{id}")
    public String eraseUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return "redirect:/admin";
    }

}
