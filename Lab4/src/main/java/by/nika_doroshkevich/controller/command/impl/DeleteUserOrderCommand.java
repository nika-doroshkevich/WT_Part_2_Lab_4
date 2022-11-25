package by.nika_doroshkevich.controller.command.impl;

import by.nika_doroshkevich.controller.command.Command;
import by.nika_doroshkevich.controller.command.CommandResult;
import by.nika_doroshkevich.controller.command.CommandResultType;
import by.nika_doroshkevich.controller.context.RequestContext;
import by.nika_doroshkevich.controller.context.RequestContextHelper;
import by.nika_doroshkevich.exeptions.ServiceException;
import by.nika_doroshkevich.service.ServiceFactory;
import by.nika_doroshkevich.service.api.UserOrderService;

import javax.servlet.http.HttpServletResponse;

public class DeleteUserOrderCommand implements Command {

    private static final String PAGE = "command=viewOrders";
    private static final String USER_ORDER_ID = "userOrderId";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String CANCELED = "canceled";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {
            int userOrderId = Integer.parseInt(requestContext.getRequestParameter(USER_ORDER_ID));
            UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
            userOrderService.updateStatusAtUserOrderById(userOrderId, CANCELED);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.REDIRECT);
    }
}
