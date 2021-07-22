package by.bntu.fitr.util;

import by.bntu.fitr.constants.Constants;
import by.bntu.fitr.entity.Account;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookiesUtils {

    public static void setCookies(HttpServletRequest request, HttpServletResponse response) {
        Account account = (Account) request.getSession().getAttribute(Constants.USER);
        Cookie cookie = new Cookie(Constants.USER, account.getUserName());
        cookie.setMaxAge(1000);
        response.addCookie(cookie);
    }

    public static Cookie getCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String key = Constants.USER;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static void destroyCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String key = Constants.USER;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }
}
