package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
   // private static final Logger log = getLogger(MealServlet.class);
        private static final Logger LOG = getLogger(MealServlet.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("redirect to meals");
      //  req.setAttribute("mealList", MealsUtil.);
        req.getRequestDispatcher("/meals.jsp").forward(req, resp);


       // resp.sendRedirect("meals.jsp");
    }
}
