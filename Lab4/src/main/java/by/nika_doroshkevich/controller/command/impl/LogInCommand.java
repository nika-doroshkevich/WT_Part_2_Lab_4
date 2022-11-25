package by.nika_doroshkevich.controller.command.impl;

import by.nika_doroshkevich.controller.command.Command;
import by.nika_doroshkevich.controller.command.CommandResult;
import by.nika_doroshkevich.controller.command.CommandResultType;
import by.nika_doroshkevich.controller.context.RequestContext;
import by.nika_doroshkevich.controller.context.RequestContextHelper;
import by.nika_doroshkevich.entity.Role;
import by.nika_doroshkevich.entity.User;
import by.nika_doroshkevich.exeptions.ServiceException;
import by.nika_doroshkevich.service.ServiceFactory;
import by.nika_doroshkevich.service.api.RoleService;
import by.nika_doroshkevich.service.api.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LogInCommand implements Command {

    private static final String PROFILE_PAGE = "command=profile";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String LOGIN_PAGE = "WEB-INF/view/login.jsp";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String EMAIL_PARAMETER = "email";
    private static final String USER = "user";
    private static final String ROLE = "role";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        String password = requestContext.getRequestParameter(PASSWORD_PARAMETER);
        String login = requestContext.getRequestParameter(EMAIL_PARAMETER);

        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
            Optional<User> optionalResult = userService.login(login, password);

            if (optionalResult.isPresent()) {
                requestContext.addSessionAttribute(USER, optionalResult.get());

                RoleService roleService = ServiceFactory.getInstance().getRoleService();
                Optional<Role> role = roleService.retrieveRoleById(optionalResult.get().getRoleId());
                role.ifPresent(value -> requestContext.addSessionAttribute(ROLE, value));

                helper.updateRequest(requestContext);
                return new CommandResult(PROFILE_PAGE, CommandResultType.REDIRECT);
            }
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        requestContext.addRequestAttribute(ERROR_MESSAGE, true);
        helper.updateRequest(requestContext);
        return new CommandResult(LOGIN_PAGE, CommandResultType.FORWARD);
    }
}