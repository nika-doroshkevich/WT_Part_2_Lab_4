package by.nika_doroshkevich.service.impl;

import by.nika_doroshkevich.dao.DaoFactory;
import by.nika_doroshkevich.dao.api.RoleDao;
import by.nika_doroshkevich.entity.Role;
import by.nika_doroshkevich.exeptions.DaoException;
import by.nika_doroshkevich.exeptions.ServiceException;
import by.nika_doroshkevich.service.api.RoleService;

import java.util.Optional;

public class RoleServiceImpl implements RoleService {




    @Override
    public Optional<Role> retrieveRoleById(int roleId) throws ServiceException {
        try {
            RoleDao roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> result;
            result = roleDao.findById(roleId);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException {
        try {
            RoleDao roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> result;
            result = roleDao.findByName(roleName);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }
    }
}