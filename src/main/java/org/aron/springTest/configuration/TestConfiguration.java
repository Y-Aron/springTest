package org.aron.springTest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用@Configuration 将第三方库组件装配到应用中，显示装配配置
 * @author: Y-Aron
 * @create: 2019-04-20 21:45
 */
@Configuration
public class TestConfiguration {

    @Bean("configTest")
    public String test() {
        return "configTest";
    }
}
