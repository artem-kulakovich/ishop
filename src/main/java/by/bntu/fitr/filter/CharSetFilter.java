package by.bntu.fitr.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CharSetFilter")
public class CharSetFilter implements Filter {
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");

        // если не установлена - устанавливаем Cp1251
        if (encoding == null)
            encoding = "UTF-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}
