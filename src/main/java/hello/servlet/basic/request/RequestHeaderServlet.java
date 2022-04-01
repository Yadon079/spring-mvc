package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
    printHeaderUtils(req);
    printEtc(req);
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

  // header 간편 조회 -> 이름으로 직접 꺼낼 수 있음
  private void printHeaderUtils(HttpServletRequest req) {
    System.out.println("--- HEADER 편의 조회 - START ---");

    System.out.println("[Host 편의 조회]");
    System.out.println("req.getServerName() = " + req.getServerName());
    System.out.println("req.getServerPort() = " + req.getServerPort());
    System.out.println();

    System.out.println("[Accept-Language 편의 조회]");
    req.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
    System.out.println("req.getLocales() = " + req.getLocales());
    System.out.println();

    System.out.println("[cookies 편의 조회]");
    if (req.getCookies() != null) {
      for (Cookie cookie : req.getCookies()) {
        System.out.println(cookie.getName() + " : " + cookie.getValue());
      }
    }
    System.out.println();

    System.out.println("[Content 편의 조회]");
    System.out.println("req.getContentType() = " + req.getContentType());
    System.out.println("req.getContentLength() = " + req.getContentLength());
    System.out.println("req.getC = " + req.getCharacterEncoding());

    System.out.println("--- HEADER 편의 조회 - END ---");
    System.out.println();
  }

  // 기타 정보 조회
  private void printEtc(HttpServletRequest req) {
    System.out.println("--- ETC - START ---");

    System.out.println("[Remote 정보]");
    System.out.println("req.getRemoteHost() = " + req.getRemoteHost());
    System.out.println("req.getRemoteHost() = " + req.getRemoteAddr());
    System.out.println("req.getRemoteHost() = " + req.getRemotePort());
    System.out.println();

    System.out.println("[Local 정보]");
    System.out.println("req.getLocalName() = " + req.getLocalName());
    System.out.println("req.getLocalName() = " + req.getLocalAddr());
    System.out.println("req.getLocalName() = " + req.getLocalPort());

    System.out.println("--- ETC - END ---");
    System.out.println();
  }

}
