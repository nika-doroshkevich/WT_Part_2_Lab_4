package by.nika_doroshkevich.service.api;

import by.nika_doroshkevich.entity.User;
import by.nika_doroshkevich.entity.UserInformation;
import by.nika_doroshkevich.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserInformationService {

    Optional<UserInformation> retrieveUserInformationById(int userInformationId) throws ServiceException;


    List<UserInformation> getUserInformationFromUsers(List<User> users) throws ServiceException;
}
