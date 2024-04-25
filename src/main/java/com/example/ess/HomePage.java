package com.example.ess;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePage {
    
    @GetMapping("/")
    public String nothingHere()
    {
        return "Nothing here";
    }
    

}
