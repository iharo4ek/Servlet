package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( value = "/test", name = "Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("num1");
        String s2 = s; // использую еще одну устроку чтобы не вывбивало ошибку при попытке преобразования в double
        double result = 0;
        double num1 = Double.parseDouble(s2);
        s = req.getParameter("type");
        s2 = s;
        Operationtypes operationtypes;
        operationtypes=Operationtypes.valueOf(s2);
        s = req.getParameter("num2");
        s2=s;
        double num2 = Double.parseDouble(s2);
        switch (operationtypes) {
            case SUM: {
                result = num1+num2;
                break;
            }
            case SUB: {
                result = num1-num2;
                break;
            }
            case MUL: {
                result = num1*num2;
                break;
            }
            case DIV: {
                result = num1/num2;
                break;
            }
            default: break;
        }
        resp.getWriter().print("result " + result);


    }
}
