package org;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class App {

    public static void main(String[] args) {
        String path = "org/spring.xml";
        ClassPathXmlApplicationContext ctx;
        ctx = new ClassPathXmlApplicationContext(path);
        JdbcTemplate jdbcTemplate;
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        String sql = (String) ctx.getBean("sql");
        Object params[] = {4};
        RowMapper<Employee> row;
        row = (RowMapper<Employee>) ctx.getBean("row");
        Object obj;
        obj = jdbcTemplate.queryForObject(sql, row, params);
        System.out.println(obj);
    }
}
