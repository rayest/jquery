package cn.rayest.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rayest on 2016/7/4 0004.
 */
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("load".equals(action)){
            this.load(request, response);
        }else if ("post".equals(action)){
            this.post(request, response);

        }
    }

    private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name);
        System.out.println(age);
        out.println("Hello, Jquery and Ajax!");
        out.flush();
        out.close();
    }

    private void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        // 在后台，将前台的参数取出来：id
        String id = request.getParameter("id");
        System.out.println(id);
        out.println("{name:'张三', age:14}");
        out.flush();
        out.close();

    }
}
