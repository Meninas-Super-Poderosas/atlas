package webapp.atlas.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {




    @GetMapping("/")
    public String main(Model model) {
        return "home"; //view
    }

    @GetMapping("/post")
    public String post(Model model){ return "post";}

    @GetMapping("/filter")
    public String filter(Model model){ return "filter";}

    @GetMapping("/tutorial")
    public String tutorial(Model model){ return "tutorial";}

    @GetMapping("/login")
    public String login(Model model){ return "login";}

}
