package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 1) @WebServlet 애노테이션으로 Servlet 이름지정 / 연결 url 지정
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet { // 2) HttpServlet을 상속

  // 3) protected 접근 지정자를 갖는 service를 override
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 4) 비즈니스 로직 작성
    
    System.out.println("HelloServlet.service");
    System.out.println("req = " + req);
    System.out.println("resp = " + resp);

    // request 파라미터
    String username = req.getParameter("username");
    System.out.println("username = " + username);

    // response 메시지
    // response header content-type
    resp.setContentType("text/plain");
    resp.setCharacterEncoding("utf-8");

    // response body
    resp.getWriter().write("hello " + username);
    
  }

}
