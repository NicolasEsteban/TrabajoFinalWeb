/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import data.Producto;
import datasessionbeans.Data_ProductoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo
 */
public class VerProductos extends HttpServlet {

    @EJB
    public Data_ProductoFacadeLocal productoFacade;
    public List<Producto> pr;
      
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         pr = productoFacade.findAll();
            
 response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Productos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Productos</h1>");
            
            int i = 1;
            
           for(Producto p : pr) {
                out.println("<h4>Producto " + i + "- ID: " + p.getId()+ " Nombre :"+ p.getNombreProducto() + ".</h4>");
                i++;
            }
            out.println("<h3>Eliminar:<h3>");
            out.println(" <div>");
              out.println("<form action=\"eliminarProducto\" method=\"post\">");
              out.println("<label for=\"nombre\">ID: </label>");
               out.println("<input type=\"text\" name=\"idP\">");
               out.println(" <button class=\"btn btn-primary\" type=\"submit\">Eliminar</button>");
                out.println(" </form>");
           out.println(" </div>");
           
             out.println("<h3>Editar:<h3>");
            out.println(" <div>");
              out.println("<form action=\"editarProducto\" method=\"post\">");
              out.println("<label for=\"nombre\">ID: </label>");
               out.println("<input type=\"text\" name=\"id_p\">");
               out.println(" <button class=\"btn btn-primary\" type=\"submit\">Editar</button>");
                out.println(" </form>");
           out.println(" </div>");
           
           out.println("<a href=\"index.html\"> <i class='fa fa-plus fa-fw'></i> Volver </a>");
             out.println("</body>");
            out.println("</html>");
        }
        
    }
    
    
    public void cargar( HttpServletResponse response){
         pr = productoFacade.findAll();
 
          try (PrintWriter out = response.getWriter()) {
          
  
            int i = 1;
            
            for(Producto p : pr) {
                out.println("<h2>Productos " + i + ": " + p.getNombreProducto() + ".</h2>");
                i++;
            }
        
        } catch (IOException ex) {
            Logger.getLogger(VerProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
