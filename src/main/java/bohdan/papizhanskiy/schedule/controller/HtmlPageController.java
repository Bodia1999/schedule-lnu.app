package bohdan.papizhanskiy.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class HtmlPageController {

    @RequestMapping("/")
    public String adminTime() {
        return "main.html";
    }

//    @RequestMapping("/timeAdmin")
//    public String adminTime() {
//        return "time.html";
//    }
//
//    @RequestMapping("/audienceAdmin")
//    public String adminAudience() {
//        return "audience.html";
//    }
}