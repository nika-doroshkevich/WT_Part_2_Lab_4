package by.nika_doroshkevich.dao.mapper;

import by.nika_doroshkevich.entity.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {

    T map(ResultSet resultSet) throws SQLException;
}