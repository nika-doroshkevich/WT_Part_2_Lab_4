package by.nika_doroshkevich.dao.api;

import by.nika_doroshkevich.dao.Dao;
import by.nika_doroshkevich.entity.Role;
import by.nika_doroshkevich.exeptions.DaoException;

import java.util.Optional;

public interface RoleDao extends Dao<Role> {

    Optional<Role> findByName(String name) throws DaoException;

}