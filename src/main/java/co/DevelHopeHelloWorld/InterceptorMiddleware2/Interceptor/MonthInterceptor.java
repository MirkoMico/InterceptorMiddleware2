package co.DevelHopeHelloWorld.InterceptorMiddleware2.Interceptor;

import co.DevelHopeHelloWorld.InterceptorMiddleware2.Month;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    List<Month>monthList=new ArrayList<>(Arrays.asList(
            new Month(1,"January","Gennaio","Januar"),
            new Month(2,"February","Febbraio","Februar"),
            new Month(3,"March","Marzo","Marz"),
            new Month(4,"April","Aprile","April"),
            new Month(5,"May","Maggio","Mai"),
            new Month(6,"June","Giugno","Juni")
    ));


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String monthNumberString = request.getHeader("monthNumber");
        if (monthNumberString == null) {
            response.setStatus(400);
            return false;
        }
        long monthNumber = Long.parseLong(monthNumberString);
        Optional<Month> month = monthList.stream().filter(singleMonth -> singleMonth.getMonthNumber()== monthNumber)
        .findFirst();
        if (month.isPresent()) {
            request.setAttribute("month",month.get());
            } else {   request.setAttribute("month ",new Month(1,"nope","nope",
                "nope"));

        }

        return true;
    }



    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {


    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

    }

}
