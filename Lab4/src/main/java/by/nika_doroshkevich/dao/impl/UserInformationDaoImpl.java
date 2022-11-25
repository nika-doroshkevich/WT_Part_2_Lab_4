package by.nika_doroshkevich.dao.impl;

import by.nika_doroshkevich.dao.api.UserInformationDao;
import by.nika_doroshkevich.dao.mapper.RowMapperFactory;
import by.nika_doroshkevich.dao.AbstractDao;
import by.nika_doroshkevich.dao.Table;
import by.nika_doroshkevich.entity.UserInformation;
import by.nika_doroshkevich.exeptions.DaoException;

public class UserInformationDaoImpl extends AbstractDao<UserInformation> implements UserInformationDao {
    private static final String SAVE_USER_INFORMATION_QUERY = "INSERT INTO " + Table.USER_INFORMATION +
            " (name, surname,  phone) VALUES (?, ?, ?)";
    private static final String UPDATE_BY_ID =
            "UPDATE "+ Table.USER_INFORMATION +"  SET name=?, surname=?, phone=?, WHERE account_id=?";

    public UserInformationDaoImpl() {
        super(RowMapperFactory.getInstance().getUserInformationRowMapper(), Table.USER_INFORMATION);
    }

    @Override
    public int save(UserInformation userInformation) throws DaoException {
        return executeInsertQuery(SAVE_USER_INFORMATION_QUERY, userInformation.getName(),
                userInformation.getSurname(),  userInformation.getPhone());
    }

    @Override
    public void updateById(int id, UserInformation userInformation) throws DaoException {
        executeUpdateQuery(UPDATE_BY_ID,userInformation.getName(),userInformation.getSurname(),userInformation.getPhone(),id);
    }
}
