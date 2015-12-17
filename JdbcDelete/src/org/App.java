package org;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {

    public static void main(String[] args) {
        String path = "org/spring.xml";
        ClassPathXmlApplicationContext ctx;
        ctx = new ClassPathXmlApplicationContext(path);
        JdbcTemplate jdbcTemplate;
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        String sql = "delete from employee where chkno = ?";
        Object values[] = {9};
        int rows = jdbcTemplate.update(sql, values);
        System.out.println(rows + " rows affected");
    }
}
