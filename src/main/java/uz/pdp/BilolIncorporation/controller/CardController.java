package uz.pdp.BilolIncorporation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.BilolIncorporation.dto.CardDto;
import uz.pdp.BilolIncorporation.service.card.CardService;
import uz.pdp.BilolIncorporation.service.user.UserService;

import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/card/")
public class CardController {
    private final CardService cardService;
    private final UserService userService;

    @RequestMapping(value = "/add/{userId}", method = RequestMethod.POST)
    public String addCard(
            @ModelAttribute CardDto cardDto,
            @PathVariable UUID userId,
            Model model
    ) {
        String message = null;
        if (cardService.add(cardDto,userId) == -1) {
            message = "Error creating card!";
        }
        model.addAttribute("message",message);
        model.addAttribute("user",userService.getById(userId));
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        model.addAttribute("cards",cardService.getCardsByUserId(userId));
        return "/cardCrud/cards";
    }
    @RequestMapping(value = "/myCard/{user_id}",method = RequestMethod.POST)
    public String myCard(
            @PathVariable UUID user_id,
            Model model
    ) {
        model.addAttribute("user",userService.getById(user_id));
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        model.addAttribute("cards",cardService.getCardsByUserId(user_id));
        return "/cardCrud/cards";
    }
    @RequestMapping(value = "/delete/{card_id}", method = RequestMethod.POST)
    public String delete(
            @PathVariable UUID card_id,
            @RequestParam UUID userId,
            Model model
    ) {
        cardService.deleteById(card_id);
        model.addAttribute("user",userService.getById(userId));
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        model.addAttribute("cards",cardService.getCardsByUserId(userId));
        return "/cardCrud/cards";
    }
    @RequestMapping(value = "/update/{card_id}",method = RequestMethod.GET)
    public String update(
            @PathVariable UUID card_id,
            @RequestParam UUID userId,
            Model model
    ) {
        model.addAttribute("card_id",card_id);
        model.addAttribute("user",userService.getById(userId));
        model.addAttribute("message",null);
        return "/cardCrud/update";
    }
    @RequestMapping(value = "/update/{card_id}",method = RequestMethod.POST)
    public String update(
            @ModelAttribute CardDto cardDto,
            @PathVariable UUID card_id,
            @RequestParam UUID userId,
            Model model
    ) {
        System.out.println(cardDto);
        cardService.update(cardDto,card_id,userId);
        model.addAttribute("user",userService.getById(userId));
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        model.addAttribute("cards",cardService.getCardsByUserId(userId));
        return "/cardCrud/cards";
    }
}
