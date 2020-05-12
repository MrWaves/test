package com.example.test.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Package: com.example.test.web.servlet
 * @Author: Mr.Waves
 * @Date: 2020-02-01 10:27
 * @Description: 自定义webServlet
 **/
@WebServlet(urlPatterns = "/servlet")
public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello WebServlet!");
    }

}
