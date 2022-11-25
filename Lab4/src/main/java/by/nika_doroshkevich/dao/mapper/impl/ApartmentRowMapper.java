package by.nika_doroshkevich.dao.mapper.impl;

import by.nika_doroshkevich.dao.mapper.Column;
import by.nika_doroshkevich.dao.mapper.RowMapper;
import by.nika_doroshkevich.entity.Apartment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentRowMapper implements RowMapper<Apartment> {

    @Override
    public Apartment map(ResultSet resultSet) throws SQLException {
        Apartment apartment = new Apartment();
        apartment.setId(resultSet.getInt(Column.ID));
        apartment.setPrice(resultSet.getDouble(Column.APARTMENT_PRICE));
        apartment.setStatus(resultSet.getString(Column.APARTMENT_STATUS));
        apartment.setType(resultSet.getString(Column.APARTMENT_TYPE));
        apartment.setApartments(resultSet.getInt(Column.APARTMENT_NUMBER));
        apartment.setRooms(resultSet.getInt(Column.APARTMENT_NUMBER_OF_ROOMS));
        apartment.setBeds(resultSet.getInt(Column.APARTMENT_NUMBER_OF_BEDS));
        apartment.setPhoto(resultSet.getString(Column.APARTMENT_PHOTO));
        return apartment;
    }
}
