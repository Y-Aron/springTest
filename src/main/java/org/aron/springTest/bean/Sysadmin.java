package org.aron.springTest.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: Y-Aron
 * @create: 2019-04-20 20:35
 */
@Getter @Setter
@ToString
public class Sysadmin extends IUser {
    private String sysAdmin;
    private Role role;
    private String nickname;
}
