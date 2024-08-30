package view;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import controller.dao.TaskDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Task;

import java.io.IOException;

@WebServlet("/delete-task")
public class DeleteTaskServlet extends HttpServlet {
    private static TaskDAO dao;

    @Override
    public void init(ServletConfig config) {
        dao = TaskDAO.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskIdStr = req.getParameter("id");
        if (taskIdStr != null) {
            try {
                int taskId = Integer.parseInt(taskIdStr);
                System.out.println(taskId);
                boolean success = dao.deleteById(taskId);
                if (success) resp.sendRedirect(req.getContextPath() + "/tasks-list");
                else {
                    req.setAttribute("error_type", "Cannot delete entity because task with provided id '%s' not found!".formatted(taskIdStr));
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    req.getRequestDispatcher("/WEB-INF/error-page.jsp").forward(req, resp);
                }
            } catch (NumberFormatException exception) {
                req.setAttribute("error_type", "Cannot delete entity because provided id '%s' is not a number!".formatted(taskIdStr));
                req.getRequestDispatcher("/WEB-INF/error-page.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error_type", "Provided id is null!");
            req.getRequestDispatcher("/WEB-INF/error-page.jsp").forward(req, resp);
        }
    }
}