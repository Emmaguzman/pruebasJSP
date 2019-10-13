/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Conexion;
import Modelo.Persona;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "personsList", urlPatterns = {"/Personas"})
public class PersonasControl extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String control = request.getParameter("Comando");
        try {
            if (control == null) {
                control = "LISTA";
            }
            switch (control) {
                case "LISTA":
                    listaPersonas(request, response);
                    break;
                case "AGREGAR":
                    agregarPersona(request, response);
                    break;
                default:
                    listaPersonas(request, response);
                    break;
                    
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listaPersonas(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Conexion conn = new Conexion();
        ArrayList<Persona> lista = conn.listarPersonas();
        request.setAttribute("List", lista);
        RequestDispatcher rd = request.getRequestDispatcher("/listaPersona.jsp");
        rd.forward(request, response);
    }

    private void agregarPersona(HttpServletRequest request, HttpServletResponse response) {
        
        

    }

}
