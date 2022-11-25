package by.nika_doroshkevich.controller.command;

import by.nika_doroshkevich.controller.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;

public interface Command {

    CommandResult execute(RequestContextHelper helper, HttpServletResponse response);
}
