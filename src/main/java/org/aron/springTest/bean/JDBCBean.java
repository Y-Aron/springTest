package org.aron.springTest.bean;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class JDBCBean {
    private String url;
    private String username;
    private String password;
}
