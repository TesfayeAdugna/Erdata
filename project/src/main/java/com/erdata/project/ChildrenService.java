package com.erdata.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildrenService {
    @Autowired
    private ChildrenRepository repo;

    public List<Children>listAll(){
        return repo.findAll();
    }
    public void save(Children entry){
        repo.save(entry);
    }
    
}
