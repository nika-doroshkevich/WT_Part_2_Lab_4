package by.nika_doroshkevich.controller.command.impl.transition;

import by.nika_doroshkevich.controller.command.Command;
import by.nika_doroshkevich.controller.command.CommandResult;
import by.nika_doroshkevich.controller.command.CommandResultType;
import by.nika_doroshkevich.controller.context.RequestContext;
import by.nika_doroshkevich.controller.context.RequestContextHelper;
import by.nika_doroshkevich.entity.Apartment;
import by.nika_doroshkevich.entity.User;
import by.nika_doroshkevich.exeptions.ServiceException;
import by.nika_doroshkevich.service.ServiceFactory;
import by.nika_doroshkevich.service.api.ApartmentService;
import by.nika_doroshkevich.service.api.RoleService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToCatalogCommand implements Command {

    private static final String PAGE = "WEB-INF/view/catalog.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String APARTMENTS = "apartments";
    private static final String STATUS = "доступно";
    private static final String USER = "user";
    private static final String ADMIN_ROLE = "admin";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        User user = (User) requestContext.getSessionAttribute(USER);
        if (user == null) {
            helper.updateRequest(requestContext);
            ApartmentService apartmentService = ServiceFactory.getInstance().getApartmentService();
            try {
                List<Apartment> apartment = apartmentService.retrieveApartamentByStatus(STATUS);
                requestContext.addRequestAttribute(APARTMENTS, apartment);
                helper.updateRequest(requestContext);
            } catch (ServiceException e) {
                return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
            }
            return new CommandResult(PAGE, CommandResultType.FORWARD);
        }

        try {
            RoleService roleService = ServiceFactory.getInstance().getRoleService();
            ApartmentService apartmentService = ServiceFactory.getInstance().getApartmentService();
            List<Apartment> apartment;
            if (roleService.retrieveRoleById(user.getRoleId()).get().getName().equals(ADMIN_ROLE)) {
                apartment = apartmentService.retrieveALLApartaments();
            } else {
                apartment = apartmentService.retrieveApartamentByStatus(STATUS);
            }
            requestContext.addRequestAttribute(APARTMENTS, apartment);

        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}

