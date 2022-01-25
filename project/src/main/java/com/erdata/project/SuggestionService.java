package com.erdata.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuggestionService {
    @Autowired
    private SuggestionRepository repo;

    public List<Suggestion>listAll(){
        return repo.findAll();
    }
    public void save(Suggestion suggest){
        repo.save(suggest);
    }
}
