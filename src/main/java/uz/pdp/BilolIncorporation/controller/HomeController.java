package uz.pdp.BilolIncorporation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.BilolIncorporation.service.user.UserService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/login")
    public String login(){
        return "index";
    }
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String home(
            @RequestParam UUID user_id,
            Model model
    ) {
        model.addAttribute("user",userService.getById(user_id));
        return "menu";
    }
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contact(
            @RequestParam UUID user_id,
            Model model
    ) {
        model.addAttribute("user",userService.getById(user_id));
        return "contact";
    }

    @RequestMapping(value = "/admin-side",method = RequestMethod.POST)
    public String admin_side(
            @RequestParam UUID user_id,
            Model model
    ) {
        model.addAttribute("users",userService.getAll());
        model.addAttribute("user",userService.getById(user_id));
        return "admin-side";
    }
}
