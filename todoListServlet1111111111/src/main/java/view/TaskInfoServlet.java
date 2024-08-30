package view;

import controller.dao.TaskDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/read-task")
public class TaskInfoServlet extends HttpServlet {
    private TaskDAO dao;

    @Override
    public void init(ServletConfig config) {
        dao = TaskDAO.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        try {
            dispatcher = req.getRequestDispatcher("/WEB-INF/task-info.jsp");
            req.setAttribute("task", dao.getById(Integer.parseInt(req.getParameter("id"))));
            dispatcher.forward(req, resp);
        } catch (RuntimeException exception) {
            dispatcher = req.getRequestDispatcher("/WEB-INF/error-page.jsp");
            req.setAttribute("error_type", "Task with id '%s' not found in TODO list!".formatted(req.getParameter("id")));
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            dispatcher.forward(req, resp);
        }
    }

}
