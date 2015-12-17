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
        String sql = "update employee set name = ?, gen = ?"
                + " where chkno = ?";
        Object values[] = {"Anuja", "F", 10};
        int rows = jdbcTemplate.update(sql, values);
        System.out.println(rows + " rows affected");
    }
}
