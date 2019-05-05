package org.aron.springTest.configuration;

import org.aron.springTest.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: Y-Aron
 * @create: 2019-04-20 21:53
 */
@Configuration
@ImportResource("classpath:config.xml")
public class ResourceConfig {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean("user")
    public User initUser() {
        return new User(username, password);
    }
}
