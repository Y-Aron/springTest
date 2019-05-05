package org.aron.springTest.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author: Y-Aron
 * @create: 2019-04-20 21:26
 */
@Repository
@Slf4j
public class UserRepository {

//    @Setter
//    private JdbcTemplate jdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(String sql, Object ... args) {
        return jdbcTemplate.update(sql, args);
    }
}
