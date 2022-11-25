package by.nika_doroshkevich.dao.api;

import by.nika_doroshkevich.dao.Dao;
import by.nika_doroshkevich.entity.User;
import by.nika_doroshkevich.exeptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {

    Optional<User> findByEmailAndPassword(String email, String password) throws DaoException;

    Optional<User> findByEmail(String email) throws DaoException;
}
