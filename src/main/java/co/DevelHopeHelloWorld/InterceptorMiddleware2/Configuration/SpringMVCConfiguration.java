package co.DevelHopeHelloWorld.InterceptorMiddleware2.Configuration;

import co.DevelHopeHelloWorld.InterceptorMiddleware2.Controllers.BasicController;
import co.DevelHopeHelloWorld.InterceptorMiddleware2.Controllers.MonthController;
import co.DevelHopeHelloWorld.InterceptorMiddleware2.Interceptor.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class SpringMVCConfiguration implements WebMvcConfigurer {

    @Autowired
    private MonthInterceptor monthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(monthInterceptor);

}
    }
