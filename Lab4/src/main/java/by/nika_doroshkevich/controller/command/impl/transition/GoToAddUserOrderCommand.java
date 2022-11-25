package by.nika_doroshkevich.controller.command.impl.transition;

import by.nika_doroshkevich.controller.command.Command;
import by.nika_doroshkevich.controller.command.CommandResult;
import by.nika_doroshkevich.controller.command.CommandResultType;
import by.nika_doroshkevich.controller.context.RequestContext;
import by.nika_doroshkevich.controller.context.RequestContextHelper;


import javax.servlet.http.HttpServletResponse;

public class GoToAddUserOrderCommand implements Command {

    private static final String PAGE = "WEB-INF/view/addUserOrder.jsp";
    private static final String APARTMENT_ID = "apartment_id";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();
     /*   String apartmentId=requestContext.getRequestParameter(APARTMENT_ID);
        requestContext.addRequestAttribute(APARTMENT_ID,apartmentId);*/
        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
