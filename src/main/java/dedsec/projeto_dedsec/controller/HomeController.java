package dedsec.projeto_dedsec.controller;

import dedsec.projeto_dedsec.domain.UserModel;
import dedsec.projeto_dedsec.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String homeLogin(Model model, UserModel userModel) {
        model.addAttribute("userModel", new UserModel());
        return "login/index";
    }
    @PostMapping("/loginValid") // Método para lidar com solicitações POST para a rota de login
    public String loginValid(@ModelAttribute UserModel userModel, Model model) {
        // Lógica de validação de login aqui
        return "redirect:home/index";
    }
}
