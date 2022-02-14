package com.erdata.project.Security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("form", new User());
        return "registration";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("form") User user, Errors errors, BindingResult bind) {
        if (userRepository.findByUsername(user.getUsername()) != null){
            bind.addError( new FieldError("form","username","User name already exist"));
        }
        if (userRepository.findByEmail(user.getEmail()) != null){
            bind.addError( new FieldError("form","email","This email is used"));
        }
        if (errors.hasErrors()) {
            return "registration";
        }
        String rawPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "redirect:/login";
    }
}