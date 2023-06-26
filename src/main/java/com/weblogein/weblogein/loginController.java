package com.weblogein.weblogein;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class loginController {
    @GetMapping("/login")
    public  String showLoge(Model model , @RequestParam(required = false) String error){
        if (error!=null){
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication==null||authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        else {
            return "redirect:/home";
        }

    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("username");
        System.out.println( getCurrentUsername());
        return "home";
    }

   @GetMapping("/logouts")
    public   String logeOut(HttpServletRequest request){
        request.getSession().invalidate();
       System.out.println(getCurrentUsername()+"loge out anoop");
        return "redirect:/login?logout";

    }

    public String getCurrentUsername() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       return authentication.getName();
    }
}


