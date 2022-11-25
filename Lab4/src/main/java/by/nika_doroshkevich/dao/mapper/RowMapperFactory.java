package by.nika_doroshkevich.dao.mapper;

import by.nika_doroshkevich.dao.mapper.impl.ApartmentRowMapper;
import by.nika_doroshkevich.dao.mapper.impl.RoleRowMapper;
import by.nika_doroshkevich.dao.mapper.impl.UserInformationRowMapper;
import by.nika_doroshkevich.dao.mapper.impl.UserOrderRowMapper;
import by.nika_doroshkevich.dao.mapper.impl.UserRowMapper;
import by.nika_doroshkevich.entity.Apartment;
import by.nika_doroshkevich.entity.Role;
import by.nika_doroshkevich.entity.User;
import by.nika_doroshkevich.entity.UserInformation;
import by.nika_doroshkevich.entity.UserOrder;

public class RowMapperFactory {

    public static RowMapperFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final RowMapper<User> userRowMapper = new UserRowMapper();
    private final RowMapper<Role> roleRowMapper = new RoleRowMapper();
    private final RowMapper<UserInformation> userInformationRowMapper = new UserInformationRowMapper();
    private final RowMapper<UserOrder> userOrderRowMapper = new UserOrderRowMapper();
    private final RowMapper<Apartment> apartmentRowMapper = new ApartmentRowMapper();

    public RowMapper<User> getUserRowMapper() {
        return userRowMapper;
    }

    public RowMapper<Role> getRoleRowMapper() {
        return roleRowMapper;
    }

    public RowMapper<UserInformation> getUserInformationRowMapper() {
        return userInformationRowMapper;
    }

    public RowMapper<UserOrder> getUserOrderRowMapper() {
        return userOrderRowMapper;
    }

    public RowMapper<Apartment> getApartmentRowMapper() {
        return apartmentRowMapper;
    }

    private static class Holder {
        private static final RowMapperFactory INSTANCE = new RowMapperFactory();
    }
}
