/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimiento;

import data.Bodega;
import data.Producto;
import datasessionbeans.Data_BodegaFacadeLocal;
import datasessionbeans.Data_ProductoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo
 */
public class crearMov extends HttpServlet {
    @EJB
    private Data_ProductoFacadeLocal productoFacade;
    @EJB
    private Data_BodegaFacadeLocal bodegaFacade;
    public List<Bodega> pr;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Movimiento</title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<h1>Crear Movimiento</h1>");
            out.println("<h3>Lista de Productos</h3>");
            
            out.println("<form action=\"ingresarMovimiento\" method=\"post\">");
            
           out.println(" <select name=\"id_p\" id=\"id_p\">");
           for(Producto p : productoFacade.findAll()) {
                out.println("<option>"+ p.getId() +"</option>");
               
            }
           out.println("</select>");
          pr =bodegaFacade.findAll();
          out.println("<p>");
           out.println("<h3>Lista de Bodegas</h3>");
           out.println("<label>Bodega Origen: </label>");
            
           out.println("<select name=\"id_bo\" id=\"id_bo\">");
            
           for(Bodega b : pr) {
                out.println("<option>"+ b.getId()+"</option>");
               
            }
           out.println("</select>");
           out.println("</p>");
           
             out.println("<p>");
           out.println("<h3>Lista de Bodegas</h3>");
           out.println("<label>Bodega Destino: </label>");
            
           out.println("<select name=\"id_bd\" id=\"id_bd\">");
            
           for(Bodega b : pr) {
                out.println("<option>"+ b.getId()+"</option>");
               
            }
           out.println("</select>");
           out.println("</p>");
           
           
           
           
           
              out.println("<p>");
              
            out.println("<h3>Cantidad</h3>");
            out.println("<input type=\"text\" name=\"cantidad\">");
          out.println("</p>");
          
          out.println("<p>");
           out.println("<h3>Tipo de Movimiento</h3>");
            
           out.println("<select name=\"tipo_m\" id=\"tipo_m\">");
            
           out.println("<option>INGRESO</option>");
           out.println("<option>EGRESO</option>");
           out.println("<option>EGRESO POR TRASPASO</option>");
           out.println("<option>INGRESO POR TRASPASO</option>");
           
           out.println("</select>");
           out.println("</p>");
           
           out.println("</form>");
           
           out.println("<p>");
           out.println(" <button class=\"btn btn-primary\" type=\"submit\">Guardar</button>");
           out.println("</p>");
           
            out.println("<div>");
           out.println("<a href=\"index.html\"> <i class='fa fa-plus fa-fw'></i> Volver </a>");
             out.println("</div>");
             out.println("</body>");
            out.println("</html>");
           }  catch (Exception e) {
            System.out.println(e.getMessage());
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
