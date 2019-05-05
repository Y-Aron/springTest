package org.aron.springTest;

import lombok.extern.slf4j.Slf4j;
import org.aron.springTest.bean.IUser;
import org.aron.springTest.bean.Role;
import org.aron.springTest.bean.Sysadmin;
import org.aron.springTest.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * 使用Xml文件配置对象
 * @author: Y-Aron
 * @create: 2019-04-20 19:56
 */
@Slf4j
public class TestXmlBean {

    private ClassPathXmlApplicationContext appContext;

    /**
     * 使用BeanFactory创建IOC容器对象
     */
    @Test
    public void testBeanFactory() {
        // 加载 Spring配置文件
        Resource resource = new ClassPathResource("xmlBean.xml");
        // 通过 XmlBeanFactory + 配置文件来创建IOC容器
        BeanFactory factory = new XmlBeanFactory(resource);
        // 获取User对象
        User user = factory.getBean(User.class);
        log.info("{}", user);
    }

    /**
     * 使用 ApplicationContext创建IOC容器对象
     */
    @Before
    public void testApplicationContext() {
        this.appContext = new ClassPathXmlApplicationContext("xmlBean.xml");
        log.info("{}", appContext);
    }

    @Test
    public void testPrototype() {
        User user = this.appContext.getBean(User.class);
        log.info("{}", user);
        Role role = this.appContext.getBean(Role.class);
        log.info("{}", role);
        Sysadmin sysadmin = this.appContext.getBean(Sysadmin.class);
        log.info("{}", sysadmin);
    }

    @Test
    public void testGetBean() {
        // 根据beanName 创建对象
        User user = (User) appContext.getBean("user");
        log.info("{}", user);

        // 根据Class创建对象
        user = appContext.getBean(User.class);
        log.info("{}", user);

        // 根据beanName 获取对象的class
        Class<?> type = appContext.getType("user");
        log.info("{}", type);

        // 根据class获取bean对象
        // 当class为抽象类或者接口时，获取IOC容器中所有的实现类
        Map<String, IUser> beans = appContext.getBeansOfType(IUser.class);
        log.info("{}",beans);

        // 根据Class获取beanName
        // 当class为抽象类或者接口时，获取IOC容器中所有实现类的beanName
        String[] names = appContext.getBeanNamesForType(IUser.class);
        log.info("{}", (Object) names);

        // 获取注解下所有的 bean对象
        Map<String, Object> map = appContext.getBeansWithAnnotation(Controller.class);
        log.info("{}", map);
    }


}
