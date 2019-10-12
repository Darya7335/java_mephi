package com.darya7335.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.Random;


import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.codec.digest.MurmurHash3;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    protected Multimap<Integer, String> multiMap;
    private SingltoneSet setId;


    public void init() {
        multiMap = HashMultimap.create();
        setId = SingltoneSet.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int answer = Integer.parseInt(request.getParameter("answer")); //переделываем строку в интеджер
        String hash = request.getParameter("hash");

        if(multiMap.containsKey(answer)) {
            if (multiMap.get(answer).contains(hash)) {
                UUID uuid = UUID.randomUUID();  //сгенерировали UUID
                setId.addSessionId(uuid.toString());
                Cookie cookie = new Cookie("sessionId", uuid.toString());
                response.addCookie(cookie);
                request.getRequestDispatcher("hello_inside.jsp").forward(request, response);
            }
        }
        else {
            response.sendRedirect("/count_to_get_in.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random RandNum = new Random(System.currentTimeMillis());

        int num1 = -125 + RandNum.nextInt(347 + 125 + 1);
        int num2 = -125 + RandNum.nextInt(347 + 125 + 1);

        String hash = Integer.toString(Integer.toString(num1 + num2).hashCode()) + System.currentTimeMillis();
        multiMap.put(num1 + num2, hash);

        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("hashNum", hash);
        request.getRequestDispatcher("/count_to_get_in.jsp").forward(request, response);
    }
}
