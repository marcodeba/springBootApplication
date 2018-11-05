package springbootapplication.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootapplication.demo.domain.ConfigBean;

@RestController
public class UserController {
//    @Value("${com.dudu.name}")
//    private String name;
//
//    @Value("${com.dudu.want}")
//    private String want;
//
//    @RequestMapping("/")
//    public String hello() {
//        return name + "," + want;
//    }

    @Autowired
    ConfigBean configBean;

    //@RequestMapping(value = "/springboot/{firstId}/{secondId}", method = RequestMethod.GET)
    @GetMapping(value = "/springboot/{firstId}/{secondId}")
    public String hello(@PathVariable(value = "firstId") Integer firstId,
                        @PathVariable(value = "secondId") Integer secondId) {
        return configBean.getName() + configBean.getWant() + firstId + "," + secondId;
    }
}
