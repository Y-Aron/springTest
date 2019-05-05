package org.aron.springTest.bean;

/**
 * @author: Y-Aron
 * @create: 2019-04-20 20:54
 */
public class UserFactory {

    public static User createStaticUser() {
        return new User();
    }

    public User createUser() {
        return new User();
    }
}
