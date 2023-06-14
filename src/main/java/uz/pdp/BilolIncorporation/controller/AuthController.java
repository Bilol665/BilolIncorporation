package uz.pdp.BilolIncorporation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.BilolIncorporation.dto.UserDto;
import uz.pdp.BilolIncorporation.entity.user.UserEntity;
import uz.pdp.BilolIncorporation.entity.user.UserEntityRole;
import uz.pdp.BilolIncorporation.service.furniture.FurnitureServiceImpl;
import uz.pdp.BilolIncorporation.service.user.UserServiceImpl;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserServiceImpl userService;
    private final FurnitureServiceImpl furnitureService;

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String signMap(){
        return "sign-up";
    }
    @RequestMapping(value = "/sign-in",method = RequestMethod.POST)
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        UserEntity user = userService.signIn(username, password);
        if (user == null) {
            model.addAttribute("message", "User not found!");
            return "index";
        }
        model.addAttribute("user", user);
        return "menu";
    }
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String signUp(
            @ModelAttribute UserDto user,
            @RequestParam String role,
            Model model
    ){
        System.out.println(user);
        UserEntity user1 = UserEntity.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .password(user.getPassword())
                .role(UserEntityRole.valueOf(role))
                .build();
        userService.add(user1);
        System.out.println(user1);
        model.addAttribute("user",user1);
        return "index";
    }

}
