package by.nika_doroshkevich.service.impl;

import by.nika_doroshkevich.dao.DaoFactory;
import by.nika_doroshkevich.dao.api.ApartamentDao;
import by.nika_doroshkevich.dao.api.UserOrderDao;
import by.nika_doroshkevich.dao.impl.ApartamentDaoImpl;
import by.nika_doroshkevich.dao.impl.UserOrderDaoImpl;
import by.nika_doroshkevich.entity.Apartment;
import by.nika_doroshkevich.entity.UserOrder;
import by.nika_doroshkevich.exeptions.DaoException;
import by.nika_doroshkevich.exeptions.ServiceException;
import by.nika_doroshkevich.service.api.ApartmentService;
import by.nika_doroshkevich.service.validator.Validator;
import by.nika_doroshkevich.service.validator.ValidatorFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApartmentServiceImpl implements ApartmentService {
    @Override
    public List<Apartment> retrieveApartamentByType(String type) throws ServiceException {
        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentsDao();

            List<Apartment> result = null;
            result = apartamentDao.findByType(type);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    @Override
    public List<Apartment> retrieveApartamentByStatus(String status) throws ServiceException {
        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentsDao();

            List<Apartment> result = null;
            result = apartamentDao.findByStatus(status);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public List<Apartment> retrieveApartamentsByUserOrders(List<UserOrder> userOrders) throws ServiceException {
        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentsDao();

            List<Apartment> result = new ArrayList<>();
            for (UserOrder userOrder : userOrders) {
                result.add(apartamentDao.findById(userOrder.getApartmentId()).get());
            }
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Apartment> retrieveApartamentById(int apartament) throws ServiceException {

        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentsDao();
            Optional<Apartment> result;
            result = apartamentDao.findById(apartament);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Apartment> retrieveApartamentsByUserId(int userId) throws ServiceException {
        try {
            UserOrderDao userOrderDao=DaoFactory.getInstance().getUserOrderDao();
            List<UserOrder> userOrders=userOrderDao.findByUserId(userId);
            List<Apartment> result=new ArrayList<>();
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentsDao();
            for (UserOrder userOrder : userOrders) {
                result.add(apartamentDao.findById(userOrder.getApartmentId()).get());
            }
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Apartment> retrieveALLApartaments() throws ServiceException {
        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentsDao();
            List<Apartment> result;
            result = apartamentDao.findAll();
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void removeApartmentById(int apartmentId) throws ServiceException {
        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentsDao();
            UserOrderDaoImpl userOrderDao=DaoFactory.getInstance().getUserOrderDao();

            List<UserOrder> userOrders=userOrderDao.findByApartmentID(apartmentId);
            for (UserOrder userOrder : userOrders) {
                userOrderDao.removeById(userOrder.getId());
            }
            apartamentDao.removeById(apartmentId);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean addNewApartment(String status, String type, String StringNumberOfRooms,
                                   String StringApartmentNumber, String StringNumberOfBeds, String StringPrice,String photo) throws ServiceException {

        if(status==null || type==null || StringNumberOfBeds ==null ||
                StringApartmentNumber ==null || StringNumberOfRooms ==null || StringPrice ==null || photo==null){
            return false;
        }
        Validator priceValidator= ValidatorFactory.getInstance().getPriceValidator();
        Validator naturalNumberValidator=ValidatorFactory.getInstance().getNaturalNumberValidator();

        if(!(priceValidator.isValid(StringPrice) && naturalNumberValidator.isValid(StringNumberOfBeds)
                && naturalNumberValidator.isValid(StringNumberOfRooms))){
            return false;
        }

        int numberOfBeds=Integer.parseInt(StringNumberOfBeds);
        int numberOfRooms=Integer.parseInt(StringNumberOfRooms);
        int apartamentNumber=Integer.parseInt(StringApartmentNumber);
        double price=Double.parseDouble(StringPrice);

        ApartamentDao apartamentDao=new ApartamentDaoImpl();
        Apartment apartment=buildApartment(status,type,numberOfRooms,apartamentNumber,numberOfBeds,price,photo);
        try {
            apartamentDao.save(apartment);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateApartmentInformation(String StringId, String status, String type, String StringNumberOfRooms,
                                              String StringApartmentNumber, String StringNumberOfBeds, String StringPrice,String photo) throws ServiceException {
        if(status==null || type==null || StringNumberOfBeds ==null ||
                StringApartmentNumber ==null || StringNumberOfRooms ==null || StringPrice ==null || photo==null){
            return false;
        }
        Validator priceValidator= ValidatorFactory.getInstance().getPriceValidator();
        Validator naturalNumberValidator=ValidatorFactory.getInstance().getNaturalNumberValidator();
        Validator idValidator=ValidatorFactory.getInstance().getIdValidator();
        Validator statusValidator=ValidatorFactory.getInstance().getStatusValidator();

        if(!(priceValidator.isValid(StringPrice) && naturalNumberValidator.isValid(StringNumberOfBeds)
                && naturalNumberValidator.isValid(StringNumberOfRooms) && idValidator.isValid(StringId)) && statusValidator.isValid(status)){
            return false;
        }

        int id=Integer.parseInt(StringId);
        int numberOfBeds=Integer.parseInt(StringNumberOfBeds);
        int numberOfRooms=Integer.parseInt(StringNumberOfRooms);
        int apartamentNumber=Integer.parseInt(StringApartmentNumber);
        double price=Double.parseDouble(StringPrice);

        ApartamentDao apartamentDao=new ApartamentDaoImpl();
        Apartment apartment=buildApartment(status,type,numberOfRooms,apartamentNumber,numberOfBeds,price,photo);
        try {
            apartamentDao.updateApartmentById(id,apartment);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateApartmentStatusById(int id,String status) throws ServiceException {
        ApartamentDao apartamentDao=DaoFactory.getInstance().getApartamentsDao();
        try {
            apartamentDao.updateApartmentStatusById(id,status);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private Apartment buildApartment(String status, String type, int numberOfRooms,
                                     int apartmentNumber, int numberOfBeds, double  price, String photo){
        Apartment apartment=new Apartment();
        apartment.setStatus(status);
        apartment.setType(type);
        apartment.setRooms(numberOfRooms);
        apartment.setApartments(apartmentNumber);
        apartment.setBeds(numberOfBeds);
        apartment.setPrice(price);
        apartment.setPhoto(photo);
        return apartment;
    }


}
