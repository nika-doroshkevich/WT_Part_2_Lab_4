package by.nika_doroshkevich.service.api;

import by.nika_doroshkevich.entity.User;
import by.nika_doroshkevich.entity.UserOrder;
import by.nika_doroshkevich.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {


    Optional<User> login(String email, String password) throws ServiceException;


    boolean register(String name, String surname,  String email, String phone, String password) throws ServiceException;


    Optional<User> retrieveUserById(int userId) throws ServiceException;

    public List<User> getUsersFromOrders(List<UserOrder> orders) throws ServiceException;


}
