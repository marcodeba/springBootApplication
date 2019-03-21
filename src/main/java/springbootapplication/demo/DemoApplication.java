package springbootapplication.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import springbootapplication.demo.domain.ConfigBean;

@RestController
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
@ComponentScan(basePackages = {"springbootapplication.*"})
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
//        Map<String, Object> propertiesMap = new LinkedHashMap<>();
//        propertiesMap.put("server.port", "0");
//        springApplication.setDefaultProperties(propertiesMap);
//        springApplication.run(DemoApplication.class, args);

        new SpringApplicationBuilder(DemoApplication.class) //Fluent API
                //.properties("server.port=0")
                .run(args);
    }
}
