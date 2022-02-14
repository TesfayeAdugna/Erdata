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
    public List<Children> getByKeyword(String keyword){
        return repo.findByKeyword(keyword);
       }
    public Children find(Long id){
        Children child = repo.getById(id);
        return child;
    }
    
}
