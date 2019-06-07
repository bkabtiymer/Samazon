package com.example.samazon.jin;

import com.example.samazon.chau.CartRepository;
import com.example.samazon.jacob.AddressRepository;
import com.example.samazon.jacob.ProductRepository;
import com.example.samazon.security.UserRepository;
import com.example.samazon.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Properties;

@Controller
public class JinController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    UserService userService;


    @RequestMapping("/detailUser")
    public  String Home(Model model){
        model.addAttribute("user", userService.getCurrentUser());
        return "Jin/detailUser";
    }

//================== user

    @RequestMapping("/detailUser/{id}")
    public String showUser(@PathVariable("id") long id, Model model){
//        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("user", userRepository.findById(id).get());
        return "Jin/detailUser";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") long id, Model model){
//        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("user", userRepository.findById(id).get());
        return "security/registration";
    }

    //=================== Order

    @RequestMapping("/showOrderHistory")
    public String listCarts(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("history", userService.getCurrentUser().getHistory());
//    if (userService.getCurrentUser() != null) {
//        model.addAttribute("user_id", userService.getCurrentUser().getId());
//    }
        return "Jin/showOrderHistory";
    }

//    @RequestMapping("/simpleemail/{id}")
//    public String sendEmail(@PathVariable("id") long id, Model model){
//        model.addAttribute("cart",cartRepository);
//        return "sendEmail";
//    }



}