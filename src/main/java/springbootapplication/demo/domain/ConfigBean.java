package springbootapplication.demo.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.dudu")
@Data
public class ConfigBean {
    private String name;
    private String want;
}
