package dedsec.projeto_dedsec.controller;

import dedsec.projeto_dedsec.domain.UserModel;
import dedsec.projeto_dedsec.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Home {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String layout(Model model){
        model.addAttribute("pageTitle", "DedSec");
        model.addAttribute("content", "home/index");
        return "layout";
    }

    @PostMapping("/")
    public ResponseEntity<List<UserModel>> loginUser(){
        var dbUsers = userRepository.findAll();
        return ResponseEntity.ok(dbUsers);
    }
}
