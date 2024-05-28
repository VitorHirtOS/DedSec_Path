package dedsec.projeto_dedsec.controller;

import dedsec.projeto_dedsec.domain.UserModel;
import dedsec.projeto_dedsec.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String homeLogin(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "home/index";
    }

    @PostMapping(value = "/menuLogin")
    public String menuLogin(@ModelAttribute UserModel userModel, Model model) {

        if (userModel.getName() == null || userModel.getName().isEmpty()) {
            // Nome de usuário não informado
            model.addAttribute("error", "Usuário não informado");
            return "home/index";
        }else if(userModel.getPassword() == null || userModel.getPassword().isEmpty()){
            model.addAttribute("error", "Senha não informado");
            return "home/index";
        }

        Optional<UserModel> optionalUser = userRepository.findByName(userModel.getName());
        Optional<UserModel> optionalPassword = userRepository.findAllByPassword(userModel.getPassword());

        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            if (userModel.getName().equals(user.getName()) && passwordEncoder.matches(userModel.getPassword(), user.getPassword())) {
                // Login bem-sucedido
                return "redirect:/menu";
            }else {
                // Senha incorreta
                model.addAttribute("error", "Senha incorreta");
                return "home/index";
            }
        }else{
            model.addAttribute("error", "Usuário e senha não encontrado");
            return "home/index";
        }

    }

}
