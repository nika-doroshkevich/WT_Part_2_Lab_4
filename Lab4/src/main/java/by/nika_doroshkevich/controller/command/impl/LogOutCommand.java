package by.nika_doroshkevich.controller.command.impl;

import by.nika_doroshkevich.controller.command.Command;
import by.nika_doroshkevich.controller.command.CommandResult;
import by.nika_doroshkevich.controller.command.CommandResultType;
import by.nika_doroshkevich.controller.context.RequestContext;
import by.nika_doroshkevich.controller.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;

public class LogOutCommand implements Command {

    private static final String LOGIN_PAGE = "command=logIn";
    private static final String USER = "user";
    private static final String ROLE = "role";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();
        requestContext.removeSessionAttribute(USER);
        requestContext.removeSessionAttribute(ROLE);
        helper.updateRequest(requestContext);
        return new CommandResult(LOGIN_PAGE, CommandResultType.REDIRECT);
    }
}