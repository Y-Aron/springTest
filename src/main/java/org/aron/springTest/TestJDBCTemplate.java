package org.aron.springTest;

import lombok.extern.slf4j.Slf4j;
import org.aron.springTest.bean.TestTable;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestJDBCTemplate {

    private JdbcTemplate jdbcTemplate;

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        this.jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }
//    @Test
//    public void testInsert() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-anno.xml");
//        UserService userService = context.getBean(UserService.class);
//        userService.save();
//    }

    @Test
    public void testInsert() {
        String sql = "insert into tb_test(`name`, `desc`, `nickname`) values(?,?,?)";
        int row = jdbcTemplate.update(sql, "name2", "desc2", "nickname2");
        log.info("{}", row);

        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Object[]{"name" + i, "desc" + i, "nickname" + i});
        }
        int[] rows = this.jdbcTemplate.batchUpdate(sql, list);
        log.info("rows: {}", rows);
    }

    @Test
    public void testUpdate() {
        String sql = "UPDATE tb_test SET `name`=? where id=?";
        int row = jdbcTemplate.update(sql, "name2_update", 1);
        log.info("{}", row);
    }

    @Test
    public void testDelete() {
        String sql = "DELETE FROM tb_test where id=?";
        int row = jdbcTemplate.update(sql, 1);
        log.info("{}", row);
    }

    @Test
    public void testQuery() {
        String sql = "select * from tb_test";
        RowMapper<TestTable> rowMapper = new BeanPropertyRowMapper<>(TestTable.class);
        List<TestTable> testList = this.jdbcTemplate.query(sql, rowMapper);
        log.info("{}", testList);
    }
}