package org.aron.springTest;

import lombok.extern.slf4j.Slf4j;
import org.aron.springTest.bean.User;
import org.aron.springTest.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Y-Aron
 * @create: 2019-04-20 20:18
 */
@Slf4j
// 使用 @Configuration 和 @ComponentScan 启动注解扫描器
@Configuration @ComponentScan(basePackages = "org.aron.springTest.*")
public class TestAnnotationBean {

    private ApplicationContext acpc;

    private ApplicationContext xmlContext;

    private ApplicationContext resourceContext;

    @Before
    public void initXmlContext() {
        this.xmlContext = new ClassPathXmlApplicationContext("annotationBean.xml");
    }

    @Before
    public void initResourceContext() {
        this.resourceContext = new ClassPathXmlApplicationContext("config.xml");
    }

    @Before
    public void initAnnotationConfigApplicationContext() {
        this.acpc = new AnnotationConfigApplicationContext(TestAnnotationBean.class);
    }

    @Test
    public void test() {
        UserController user = this.acpc.getBean(UserController.class);
        log.info("{}", user);
        user.execute();

        UserController userController = this.xmlContext.getBean(UserController.class);
        log.info("{}", userController);
        userController.execute();

        String test = (String) this.acpc.getBean("configTest");
        log.info("{}", test);
    }

    @Test
    public void testResourceConfig() {
        User user = (User) this.resourceContext.getBean("user");
        log.info("{}", user);
    }
}
