package uz.pdp.BilolIncorporation.controller;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.BilolIncorporation.dto.FurnitureDto;
import uz.pdp.BilolIncorporation.entity.furniture.Furniture;
import uz.pdp.BilolIncorporation.entity.order.Order;
import uz.pdp.BilolIncorporation.service.furniture.FurnitureService;
import uz.pdp.BilolIncorporation.service.order.OrderService;
import uz.pdp.BilolIncorporation.service.user.UserService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/furniture")
public class FurnitureController {
    private final FurnitureService furnitureService;
    private final UserService userService;
    private final OrderService orderService;
    @RequestMapping(value = "/add/{user_id}",method = RequestMethod.POST)
    public String addPost(
            @PathVariable UUID user_id,
            @ModelAttribute FurnitureDto furniture,
            Model model
    ){
        furnitureService.add(furniture,user_id);
        System.out.println(furniture);
        model.addAttribute("furnitures",furnitureService.getUserPost(user_id));
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        model.addAttribute("user",userService.getById(user_id));
        return "postCrud/posts";
    }

    @RequestMapping(value = "/posts",method = RequestMethod.POST)
    public String posts(
            @RequestParam UUID user_id,
            Model model
    ){
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        model.addAttribute("furnitures",furnitureService.getUserPost(user_id));
        model.addAttribute("user",userService.getById(user_id));
        return "postCrud/posts";
    }
    @RequestMapping(value = "/update/{furniture_id}",method = RequestMethod.GET)
    public String update(
            @PathVariable UUID furniture_id,
            @RequestParam UUID user_id,
            Model model
    ) {
        model.addAttribute("furniture_id",furniture_id);
        model.addAttribute("user",userService.getById(user_id));
        return "postCrud/updatePost";
    }
    @RequestMapping(value = "/update/{furniture_id}",method = RequestMethod.POST)
    public String update(
            @PathVariable UUID furniture_id,
            @RequestParam UUID user_id,
            @ModelAttribute FurnitureDto update,
            Model model
    ){
        System.out.println(update);
        furnitureService.update(update,furniture_id,user_id);
        model.addAttribute("furnitures",furnitureService.getUserPost(user_id));
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        model.addAttribute("user",userService.getById(user_id));
        return "postCrud/posts";
    }
    @RequestMapping(value = "/delete/{furniture_id}", method = RequestMethod.POST)
    public String delete(
            @PathVariable UUID furniture_id,
            @RequestParam UUID user_id,
            Model model
    ) {
        furnitureService.deleteById(furniture_id);
        model.addAttribute("furnitures",furnitureService.getUserPost(user_id));
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        model.addAttribute("user",userService.getById(user_id));
        return "postCrud/posts";
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public String all(
            @RequestParam UUID user_id,
            Model model
    ) {
        model.addAttribute("message",null);
        model.addAttribute("furnitures",furnitureService.getAll());
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        model.addAttribute("user",userService.getById(user_id));
        return "/postCrud/allPost";
    }



    @RequestMapping(value = "/order/{furniture_id}", method = RequestMethod.POST)
    public String order(
            @PathVariable UUID  furniture_id,
            @RequestParam UUID user_id,
            Model model
    ) {
        String message = null;
        Order order;
        if(orderService.checkLength()) {
            order = new Order(List.of(furnitureService.getById(furniture_id)),userService.getById(user_id));
            orderService.add(order);
        }else{
            try {
                order = orderService.getByUserId(user_id);
                List<Furniture> furniture = order.getFurniture();
                boolean t = true;
                for(Furniture f:furniture) {
                    if (Objects.equals(f.getId(), furniture_id)) {
                        message = "You already ordered it! Check your orders!";
                        t = false;
                        break;
                    }
                }
                if(t) {
                    furniture.add(furnitureService.getById(furniture_id));
                    order.setFurniture(furniture);
                    orderService.justUpdate(order);
                }
            }catch (Exception e) {
                order = new Order(List.of(furnitureService.getById(furniture_id)),userService.getById(user_id));
                orderService.add(order);
            }
        }
        model.addAttribute("message",message);
        model.addAttribute("furnitures",furnitureService.getAll());
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        model.addAttribute("user",userService.getById(user_id));
        return "postCrud/allPost";
    }

    @RequestMapping(value = "/myOrders/{id}", method = RequestMethod.POST)
    public String myOrders(
            @PathVariable UUID id,
            Model model
    ) {
        model.addAttribute("user",userService.getById(id));
        model.addAttribute("furnitures",orderService.getByUserId(id).getFurniture());
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        return "postCrud/myOrders";
    }
}

