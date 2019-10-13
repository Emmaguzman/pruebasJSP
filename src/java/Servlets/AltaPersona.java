/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Conexion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denis
 */
@WebServlet(name = "AltaPersona", urlPatterns = {"/AltaPersona"})
public class AltaPersona extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Conexion con=new Conexion();
            
            String modo = request.getParameter("modo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher(modo != null && modo.equals("lista") ? "/listaPersonas.jsp" : "/formPersonas.jsp");
            rd.forward(request, response);        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
