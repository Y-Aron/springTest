package org.aron.springTest;

import org.aron.springTest.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Y-Aron
 * @create: 2019-04-20 22:41
 */
public class TestSpringAop {
    private ApplicationContext appContext;


    @Before
    public void start() {
        this.appContext = new ClassPathXmlApplicationContext("aop.xml");
        System.out.println(this.appContext);
    }

    @Test
    public void testAop() {
        User user = this.appContext.getBean(User.class);
        user.init("aopName", "aopPasswd");
    }

}
