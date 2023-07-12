package com.example.mgc_library;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/book"})
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read game information from request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String name = jsonRequest.getString("name");
        String author = jsonRequest.getString("author");
        String publishDate = jsonRequest.getString("publish_date");
        String ISBN = jsonRequest.getString("ISBN");
        float price = jsonRequest.getFloat("price");
        // Print game information to IDE console
        System.out.println("Name is: " + name);
        System.out.println("Author is: " + author);
        System.out.println("Publish date is: " + publishDate);
        System.out.println("ISBN is: " + ISBN);
        System.out.println("Price is: " + price);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        JSONObject book = new JSONObject();
        book.put("name", "David and Goliath");
        book.put("author", "John Smith");
        book.put("publish_date", "Jan 11, 1999");
        book.put("ISBN", "1234567890");
        book.put("price", 49.99);

        // Write game information to response body
        response.getWriter().print(book);

    }
}
