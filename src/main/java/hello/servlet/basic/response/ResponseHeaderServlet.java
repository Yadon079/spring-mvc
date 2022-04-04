package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // [status-line]
    resp.setStatus(HttpServletResponse.SC_OK);
//    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

    // [response-headers]
    resp.setHeader("Content-Type", "text/plain");
    resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    resp.setHeader("Pragma", "no-cache");
    resp.setHeader("my-header", "hello");

    // [Header 편의 메서드]
    content(resp);
    cookie(resp);
    redirect(resp);

    // [message body]
    PrintWriter writer = resp.getWriter();
    writer.println("OK");
  }

  /* set 필드명을 통해서 하나씩 지정 가능 */
  private void content(HttpServletResponse response) {
    // Content-Type: text/plain;charset=utf-8
    // Content-Length: 2
    // response.setHeader("Content-Type", "text/plain;charset=utf-8");
    response.setContentType("text/plain");
    response.setCharacterEncoding("utf-8");
    // response.setContentLength(2); //(생략시 자동 생성)
  }

  /* set 필드명을 통해서 하나씩 지정 가능 */
  private void cookie(HttpServletResponse response) {
    // Set-Cookie: myCookie=good; Max-Age=600;
    // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

    /* 다음 번 Http request에는 cookie가 자동으로 포함되서 요청 */
    Cookie cookie = new Cookie("myCookie", "good");
    cookie.setMaxAge(600); //600초
    response.addCookie(cookie);
  }

  private void redirect(HttpServletResponse response) throws IOException {
    /* Status Code가 302 + Location -> Redirect된 것 */
    // Status Code 302
    // Location: /basic/hello-form.html

    /* 두 줄로 된 Code를 하나로 대체 가능 */
    // response.setStatus(HttpServletResponse.SC_FOUND); //302
    // response.setHeader("Location", "/basic/hello-form.html");
    response.sendRedirect("/basic/hello-form.html");
  }

}
