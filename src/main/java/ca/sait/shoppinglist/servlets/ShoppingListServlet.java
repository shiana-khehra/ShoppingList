package ca.sait.shoppinglist.servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Shiana Khehra
 */
public class ShoppingListServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("name") != null) {
            String query = request.getQueryString();
        
            if(query != null && query.contains("logout")) {
                session.invalidate();
                response.sendRedirect("ShoppingList");
                return;
            }
        } 
        
        String name = (String)session.getAttribute("name");
        
        if(name == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);   
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        
        if(action != null && action.equals("add")) {
            String item = request.getParameter("item");
                
            ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
            
            items.add(item);
            
            session.setAttribute("items", items);
        } else if(action != null && action.equals("delete")) {
            String item = request.getParameter("item");
            
            ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
            
            items.remove(item);
            
            session.setAttribute("items", items);
        } else {
            String name = request.getParameter("name");
            
            ArrayList<String> items = new ArrayList<>();
            
            session.setAttribute("name", name);
            session.setAttribute("items", items);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
