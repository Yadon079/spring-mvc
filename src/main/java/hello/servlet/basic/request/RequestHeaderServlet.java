package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    printStartLine(req);
    printHeaders(req);
  }

  // start-line 정보
  private void printStartLine(HttpServletRequest req) {
    System.out.println("--- REQUEST-LINE - START ---");

    System.out.println("req.getMethod() = " + req.getMethod()); // GET
    System.out.println("req.getProtocol() = " + req.getProtocol()); // HTTP/1.1
    System.out.println("req.getScheme() = " + req.getScheme()); // http

    // http://localhost:8080/request-header
    System.out.println("req.getRequestURL() = " + req.getRequestURL());

    // /request-test
    System.out.println("req.getRequestURI() = " + req.getRequestURI());

    // username = hi
    System.out.println("req.getQueryString() = " + req.getQueryString());
    System.out.println("req.isSecure() = " + req.isSecure()); // https 사용유무

    System.out.println("--- REQUEST-LINE - END ---");
    System.out.println();
  }

  // header 모든 정보
  private void printHeaders(HttpServletRequest req) {
    System.out.println("--- HEADERS - START ---");

    // 과거 스타일
//    Enumeration<String> headerNames = req.getHeaderNames();
//    while (headerNames.hasMoreElements()) {
//      String headerName = headerNames.nextElement();
//      System.out.println(headerName + " : " + headerName);
//    }

    // 요즘 스타일
    req.getHeaderNames().asIterator()
            .forEachRemaining(headerName -> System.out.println(headerName + " : " + headerName));

    System.out.println("--- HEADERS - END ---");
    System.out.println();
  }

}
