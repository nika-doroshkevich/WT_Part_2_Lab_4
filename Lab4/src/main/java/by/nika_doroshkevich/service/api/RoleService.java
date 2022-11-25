package by.nika_doroshkevich.service.api;

import by.nika_doroshkevich.entity.Role;
import by.nika_doroshkevich.exeptions.ServiceException;

import java.util.Optional;

public interface RoleService {

    Optional<Role> retrieveRoleById(int roleId) throws ServiceException;
    Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException;

}
