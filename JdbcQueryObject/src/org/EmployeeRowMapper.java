package org;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int i) throws SQLException {
        return new Employee(rs.getInt(1), 
                rs.getString(2), rs.getDate(3), rs.getString(4),
                 rs.getBoolean(5), rs.getInt(6), rs.getDouble(7));
    }
}
