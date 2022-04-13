package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

  boolean supports(Object handler); // handler를 처리할 수 있는 어댑터가 있는지 확인

  ModelView handler(HttpServletRequest req, HttpServletResponse resp, Object handler) throws ServletException, IOException;

}
