package com.erdata.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewentryService {
    @Autowired
    private NewentryRepository repo;

    public List<Newentry>listAll(){
        return repo.findAll();
    }
    public void save(Newentry entry){
        repo.save(entry);
    }
    
}
