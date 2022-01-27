package com.erdata.project;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NewEntryController {
    @Autowired
    private NewentryService service;
    @Autowired
    private NewentryRepository repo;
    @GetMapping("/")
    public String home(Model model){
        List<Newentry> listentry = service.listAll();
        model.addAttribute("listentry", listentry);
        System.out.print("Get /");
        return "home";
    }
    @GetMapping("/newentry")
    public String newe(Model model){
        model.addAttribute("entry", new Newentry());
        return "newentry";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String sendContact(@ModelAttribute("entry") Newentry entry,  @RequestParam("image") MultipartFile multipartFile)throws IOException{
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        entry.setPhotos(fileName);
        // entry.setUser(user);


        Newentry savedItems = repo.save(entry);

        String uploadDir = "user-photos/" + savedItems.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        service.save(entry);
        return "redirect:/";
    }
}