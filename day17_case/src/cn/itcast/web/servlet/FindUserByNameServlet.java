package cn.itcast.web.servlet;

import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserByNameServlet")
public class FindUserByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService service = new UserServiceImpl();
        String username = request.getParameter("name");
        boolean flag = service.findByName(username);
        response.setContentType("application/json;charset=utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag) {
            map.put("userExist", true);
            map.put("msg", "此用户名太受欢迎，请更换另一个");
        } else {
            map.put("userExist", false);
            map.put("msg", "用户名可用");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
