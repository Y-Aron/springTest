package org.aron.springTest.bean;

import lombok.*;

/**
 * @author: Y-Aron
 * @create: 2019-04-20 20:31
 */
@Setter @Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Role {
    private String roleName;
    private String[] array;
}
