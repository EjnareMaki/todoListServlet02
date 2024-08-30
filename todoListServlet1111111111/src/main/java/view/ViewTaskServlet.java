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

@WebServlet("/tasks-list/*")
public class ViewTaskServlet extends HttpServlet {
    private static TaskDAO dao;

    @Override
    public void init(ServletConfig config) {
        dao = TaskDAO.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/task-list.jsp");
        req.setAttribute("tasks", dao.getAll());
        rd.forward(req, resp);
    }
}
