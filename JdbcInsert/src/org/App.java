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
        String sql = "insert into employee "
                + "(name, doj, gen, sept, psno, salary)"
                + "values (?,?,?,?,?,?)";
        Object values[] = {
            "Vishal", "1997-12-22", "M", false,
            34523, 67343.56
        };
        jdbcTemplate.update(sql, values);
    }
}
