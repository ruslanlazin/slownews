
package ua.pp.lazin.slownews.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Laz on 24.08.2016.
 */
@WebServlet("/login")
public class Login extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html; charset=utf-8");

        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);

    }
}