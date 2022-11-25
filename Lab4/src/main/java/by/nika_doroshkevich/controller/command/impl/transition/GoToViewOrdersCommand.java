package by.nika_doroshkevich.controller.command.impl.transition;

import by.nika_doroshkevich.controller.command.Command;
import by.nika_doroshkevich.controller.command.CommandResult;
import by.nika_doroshkevich.controller.command.CommandResultType;
import by.nika_doroshkevich.controller.context.RequestContext;
import by.nika_doroshkevich.controller.context.RequestContextHelper;
import by.nika_doroshkevich.entity.Apartment;
import by.nika_doroshkevich.entity.User;
import by.nika_doroshkevich.entity.UserInformation;
import by.nika_doroshkevich.entity.UserOrder;
import by.nika_doroshkevich.exeptions.ServiceException;
import by.nika_doroshkevich.service.ServiceFactory;
import by.nika_doroshkevich.service.api.ApartmentService;
import by.nika_doroshkevich.service.api.UserInformationService;
import by.nika_doroshkevich.service.api.UserOrderService;
import by.nika_doroshkevich.service.api.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToViewOrdersCommand implements Command {

    private static final String PAGE = "WEB-INF/view/viewOrders.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String USER_ORDERS = "userOrders";
    private static final String USERS = "users";
    private static final String APARTMENTS = "apartments";
    private static final String USER_INFORMATION = "userInformation";
    private static final String EXPECTED = "booked";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {
            UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
            List<UserOrder> userOrders = userOrderService.retrieveUserOrderByStatus(EXPECTED);
            requestContext.addRequestAttribute(USER_ORDERS, userOrders);

            UserService userService = ServiceFactory.getInstance().getUserService();
            List<User> users = userService.getUsersFromOrders(userOrders);
            requestContext.addRequestAttribute(USERS, users);

            ApartmentService apartmentService = ServiceFactory.getInstance().getApartmentService();
            List<Apartment> apartments = apartmentService.retrieveApartamentsByUserOrders(userOrders);
            requestContext.addRequestAttribute(APARTMENTS, apartments);

            UserInformationService userInformationService = ServiceFactory.getInstance().getUserInformationService();
            List<UserInformation> userInformation = userInformationService.getUserInformationFromUsers(users);
            requestContext.addRequestAttribute(USER_INFORMATION, userInformation);

        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
