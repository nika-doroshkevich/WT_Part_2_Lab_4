package by.nika_doroshkevich.dao.api;

import by.nika_doroshkevich.dao.Dao;
import by.nika_doroshkevich.entity.UserInformation;
import by.nika_doroshkevich.exeptions.DaoException;

public interface UserInformationDao extends Dao<UserInformation> {

    void updateById(int id, UserInformation userInformation) throws DaoException;
}
