package matyja.projects.interceotor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        log.debug("Prehandle method called. Handler = {}", handler);
        log.debug("URL = {}", request.getRequestURL());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("PostHandle method called. Handler = {}", handler);
        log.debug("URL = {}", request.getRequestURL());
        log.debug("Model = {}",modelAndView.getModel());
        log.debug("View = {}", modelAndView.getViewName());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        log.debug("After Completion method called. Handler = {}", handler);
        log.debug("URL = {}", request.getRequestURL());

    }
}
