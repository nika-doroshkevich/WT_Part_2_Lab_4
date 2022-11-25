package by.nika_doroshkevich.dao.mapper.impl;

import by.nika_doroshkevich.dao.mapper.Column;
import by.nika_doroshkevich.dao.mapper.RowMapper;
import by.nika_doroshkevich.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role map(ResultSet resultSet) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getInt(Column.ID));
        role.setName(resultSet.getString(Column.ROLE_NAME));
        return role;
    }
}