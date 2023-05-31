package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(
        description= "Login Servlet Testing",
        urlPatterns= { "/LoginServlet" } ,
        initParams = {
                @WebInitParam(name = "user", value = "arpit"),
                @WebInitParam(name = "password", value = "123")
        }
)

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//get request parameters for user-JD and password
        String user = request.getParameter( "user") ;
        String pwd = request.getParameter( "pwd");
        //get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
        if(userID.equals(user)&& password.equals(pwd))
        {
            request.setAttribute( "user", user);
            request.getRequestDispatcher("LoginSuccess.jsp") .forward(request, response);
        }
        else{
            RequestDispatcher rd =getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color = red> user name or password is </font>");
            rd.include(request, response);
        }
    }
}
