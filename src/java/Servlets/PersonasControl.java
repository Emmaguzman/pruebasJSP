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

@WebServlet(name = "PersonasControl", urlPatterns = {"/PersonasControl"})
public class PersonasControl extends HttpServlet {

    private Conexion conn;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            conn = new Conexion();
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

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
                case "CARGA":
                    cargarPersona(request, response);
                    break;
                case "BORRAR":
                    borrarPersona(request, response);
                    break;
                case "ACTUALIZAR":
                    actualizarPersona(request,response);
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

    private void agregarPersona(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        Persona p = new Persona(nombre, apellido);
        conn.agregarPersona(p);
        listaPersonas(request, response);

    }

    private void listaPersonas(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Persona> lista = conn.listarPersonas();
        request.setAttribute("List", lista);
        RequestDispatcher rd = request.getRequestDispatcher("/listaPersona.jsp");
        rd.forward(request, response);
    }

    private void cargarPersona(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
        Persona miPersona = conn.traerPersona(request.getParameter("idPersona"));
        request.setAttribute("miPersona", miPersona);
        RequestDispatcher rd = request.getRequestDispatcher("/Actualizar_Persona.jsp");
        rd.forward(request, response);
    }
    

    private void borrarPersona(HttpServletRequest request, HttpServletResponse response)throws Exception {        
        conn.borrarPersona((request.getParameter("idPersona")));
        listaPersonas(request, response);
    }

    private void actualizarPersona(HttpServletRequest request, HttpServletResponse response) throws Exception{  
        int id=Integer.parseInt(request.getParameter("idPersona"));
        String nombre=request.getParameter("txtNombre");
        String apellido=request.getParameter("txtApellido");
        Persona p=new Persona(id,nombre,apellido);
        
        conn.actualizarPersona(p);
        listaPersonas(request,response);
    }

}
