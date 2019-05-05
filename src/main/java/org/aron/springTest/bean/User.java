package org.aron.springTest.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author: Y-Aron
 * @create: 2019-04-20 19:59
 */
@Slf4j
@NoArgsConstructor
@Setter @Getter
@ToString
public class User extends IUser {
    private String username;
    private String password;
    private Role role;
    private List<String> interests;
    private Properties properties;
    private String[] array;
    private Map<String, String> map;
    private Set<String> set;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String init(String username, String password) {
        log.info("{}", username);
        log.info("{}", password);
        int c = 1/0;
        log.info("user init");
        return username + ": " + password;
    }

    public void destroy() {
        log.info("user destroy");
    }
}
