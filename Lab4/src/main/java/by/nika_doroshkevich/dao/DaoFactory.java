package by.nika_doroshkevich.dao;

import by.nika_doroshkevich.dao.impl.ApartamentDaoImpl;
import by.nika_doroshkevich.dao.impl.RoleDaoImpl;
import by.nika_doroshkevich.dao.impl.UserDaoImpl;
import by.nika_doroshkevich.dao.impl.UserInformationDaoImpl;
import by.nika_doroshkevich.dao.impl.UserOrderDaoImpl;


public class DaoFactory {

    private final UserDaoImpl userDao = new UserDaoImpl();
    private final RoleDaoImpl roleDao = new RoleDaoImpl();
    private final UserInformationDaoImpl userInformationDao = new UserInformationDaoImpl();
    private final UserOrderDaoImpl userOrderDao=new UserOrderDaoImpl();
    private final ApartamentDaoImpl apartamentsDao =new ApartamentDaoImpl();

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public RoleDaoImpl getRoleDao() {
        return roleDao;
    }

    public UserInformationDaoImpl getUserInformationDao() {
        return userInformationDao;
    }

    public UserOrderDaoImpl getUserOrderDao() {
        return userOrderDao;
    }

    public ApartamentDaoImpl getApartamentsDao() {
        return apartamentsDao;
    }

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return Holder.INSTANCE;
    }


    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }
}