package by.nika_doroshkevich.dao.api;

import by.nika_doroshkevich.dao.Dao;
import by.nika_doroshkevich.entity.Apartment;
import by.nika_doroshkevich.exeptions.DaoException;

import java.util.List;

public interface ApartamentDao extends Dao<Apartment> {

    List<Apartment> findByStatus(String status) throws DaoException;

    List<Apartment> findByType(String type) throws DaoException;

    void updateApartmentById(int id, Apartment apartment) throws DaoException;

    void updateApartmentStatusById(int id, String status) throws DaoException;

}
