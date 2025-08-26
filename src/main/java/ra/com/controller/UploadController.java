package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ra.com.model.User;
import ra.com.service.UploadService;
import ra.com.service.UserService;

@Controller
@RequestMapping("/")
public class UploadController {

    @Autowired
    private UploadService uploadService;
    @Autowired
    private UserService userService;
    @GetMapping("/upload")
    public String upload(Model model) {
        return "uploadFile";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        String url = uploadService.uploadFile(file);
        User user = new User();
        user.setAvatarUrl(url);
        user.setPassword("123456");
        user.setUserName("haonguyen");
        user.setEmail("haonguyen@gmail.com");
        userService.addUser(user);
        model.addAttribute("url", url);
        return "uploadFile";
    }
}
