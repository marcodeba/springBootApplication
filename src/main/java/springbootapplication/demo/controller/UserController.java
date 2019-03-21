package springbootapplication.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootapplication.demo.domain.ConfigBean;

@RestController
public class UserController {
    @Autowired
    ConfigBean configBean;

    //@RequestMapping(value = "/springboot/{firstId}/{secondId}", method = RequestMethod.GET)
    @GetMapping(value = "/springboot/{firstId}/{secondId}")
    public String hello(@PathVariable(value = "firstId") String firstId,
                        @PathVariable(value = "secondId") String secondId) {
        return configBean.getName() + configBean.getWant() + firstId + "," + secondId;
    }
}
