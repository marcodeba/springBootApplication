package springbootapplication.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;
import springbootapplication.demo.domain.ConfigBean;

@RestController
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
public class DemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoApplication.class).run(args);
    }
}
