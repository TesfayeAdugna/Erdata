package com.erdata.project;

import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ChildrenController {
    @Autowired
    private ChildrenService service;
    @Autowired
    private ChildrenRepository repo;
    @GetMapping("/")
    public String home(Model model){
        List<Children> listentry = service.listAll();
        model.addAttribute("listentry", listentry);
        System.out.print("Get /");
        return "home";
    }
    @GetMapping("/newentry")
    public String newe(Model model){
        model.addAttribute("entry", new Children());
        return "newentry";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String sendContact(@ModelAttribute("entry") @Valid Children entry, Errors errors, @RequestParam("image") MultipartFile multipartFile)throws IOException{
        if (errors.hasErrors()) {
            return "newentry";
        }
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        entry.setPhotos(fileName);
        // entry.setUser(user);


        Children savedItems = repo.save(entry);

        String uploadDir = "user-photos/" + savedItems.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        service.save(entry);
        return "redirect:/admin";
    }
    
    


    @GetMapping("/edit/{id}")
public String showUpdateForm(@PathVariable("id") long id, Model model) {
    Children entry = repo.findById(id).get();
    
    model.addAttribute("entry", entry);
    return "update_user";
}


@PostMapping("/update/{id}")
public String updateChild(@PathVariable(name = "id") long id, @Valid Children entry, 
  Model model) {
   
        
    repo.save(entry);
    return "redirect:/admin";
}



    @GetMapping("/delete/{id}")
public String deleteChildren(@PathVariable("id") long id, Model model) {
    Children entry = repo.findById(id).get();
      
    repo.delete(entry);
    return "redirect:/admin";
}


    // for search
    @RequestMapping("/search")
    public String home(Children children, Model model, String keyword) {
     if(keyword!=null) {
      List<Children> listentry = service.getByKeyword(keyword);
      model.addAttribute("listentry", listentry);
     }else {
     List<Children> listentry = service.listAll();
     model.addAttribute("listentry", listentry);}
     return "profile";
    }


}