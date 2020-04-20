package springbootapplication.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootapplication.demo.domain.ConfigBean;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    ConfigBean configBean;

    @GetMapping(value = "/springboot/{firstId}/{secondId}")
    public String hello(@PathVariable(value = "firstId") String firstId,
                        @PathVariable(value = "secondId") String secondId) {
        return configBean.getName() + configBean.getWant() + firstId + "," + secondId;
    }

    @GetMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
