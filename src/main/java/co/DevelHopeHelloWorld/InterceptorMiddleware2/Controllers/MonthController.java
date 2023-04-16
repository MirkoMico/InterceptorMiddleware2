package co.DevelHopeHelloWorld.InterceptorMiddleware2.Controllers;

import co.DevelHopeHelloWorld.InterceptorMiddleware2.Month;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/month")
public class MonthController {

    @GetMapping
    public Month get(HttpServletRequest request) {

        Month month = (Month) request.getAttribute("month");
        return month;
    }

}
