package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.com.model.DTO.req.RegisterReq;
import ra.com.model.DTO.req.LoginReq;
import ra.com.model.User;
import ra.com.repository.UserRepository;
import ra.com.service.UploadService;
import ra.com.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UploadService uploadService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new LoginReq());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") LoginReq userReq,BindingResult result, Model model){
        User user = userService.login(userReq.getUserName(), userReq.getPassword());
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "login";
        }else {
            if (user != null) {
                Cookie cookie = new Cookie("user", user.getUserName());
                cookie.setPath("/home");
                cookie.setMaxAge(60*60*24*30);
                model.addAttribute("user", userReq);
                return "redirect:/home";
            } else {
                model.addAttribute("user", userReq);
                model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng.");
                return "login";
            }
        }
    }

    @GetMapping("/register")
    public String showFormregister(Model model){
        model.addAttribute("user",new RegisterReq());
        return "register";
    }

    @PostMapping("/register")

public String register(@Valid @ModelAttribute("user") RegisterReq user, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("user",user);
            return "register";
        }
        // chuyen doi DTO sang entity
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setAvatarUrl(uploadService.uploadFile(user.getAvatarUrl()));
         userService.addUser(newUser);
        user.setUserName(user.getUserName());
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        Cookie cookie = new Cookie("user", null);
        cookie.setPath("/home");
        cookie.setMaxAge(0);
        session.removeAttribute("user");
        return "redirect:/login";
    }

}
