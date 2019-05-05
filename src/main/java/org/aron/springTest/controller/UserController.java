package org.aron.springTest.controller;

import lombok.extern.slf4j.Slf4j;
import org.aron.springTest.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author: Y-Aron
 * @create: 2019-04-20 20:43
 */
@Controller
@Slf4j
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserService userService;

    public void execute() {
        log.info("userController：save");
        userService.save();
    }
}
