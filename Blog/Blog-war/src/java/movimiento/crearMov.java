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
             out.println("  <!-- IMPORTANDO ICONOS -->\n" +
"    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n" +
"    \n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"    <title>Panel Admin</title>\n" +
"     <link rel=\"stylesheet\" href=\"admin/css/bootstrap.min.css\" type=\"text/css\"/>\n" +
"     <link rel=\"stylesheet\" href=\"admin/css/metisMenu.min.css\" type=\"text/css\"/>\n" +
"     <link rel=\"stylesheet\" href=\"admin/css/sb-admin-2.css\" type=\"text/css\"/>\n" +
"     <link rel=\"stylesheet\" href=\"admin/css/font-awesome.min.css\" type=\"text/css\"/>\n" +
"      <link rel=\"stylesheet\" href=\"admin/css/tabla_scroll.css\" type=\"text/css\"/>\n" +
"\n" +
"    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
"\n" +
"    <script type=\"text/javascript\" src=\"js/Chart.bundle.js\"></script>\n" +
"      <script type=\"text/javascript\" src=\"js/Chart.bundle.min.js\"></script>\n" +
"      <script type=\"text/javascript\" src=\"js/Chart.js\"></script>\n" +
"      <script type=\"text/javascript\" src=\"js/Chart.min.js\"></script>\n" +
"      \n" +
"      <script type=\"text/javascript\" src=\"admin/js/jquery.min.js\"></script>\n" +
"      <script type=\"text/javascript\" src=\"admin/js/bootstrap.min.js\"></script>\n" +
"      <script type=\"text/javascript\" src=\"admin/js/metisMenu.min.js\"></script>\n" +
"      <script type=\"text/javascript\" src=\"admin/js/sb-admin-2.js\"></script>");
             
            out.println("</head>");
            out.println("<body>");
            
            out.println("  <div id=\"wrapper\">\n" +
"\n" +
"        \n" +
"        <nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n" +
"            <div class=\"navbar-header\">\n" +
"                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n" +
"                    <span class=\"sr-only\">Toggle navigation</span>\n" +
"                    <span class=\"icon-bar\"></span>\n" +
"                    <span class=\"icon-bar\"></span>\n" +
"                    <span class=\"icon-bar\"></span>\n" +
"                </button>\n" +
"            \n" +
"                <a class=\"navbar-brand\" href=\"index.html\">Admin</a>\n" +
"\n" +
"            </div>\n" +
"           \n" +
"    \n" +
" <ul class=\"nav navbar-top-links navbar-right\">\n" +
"                 <li class=\"dropdown\">\n" +
"                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n" +
"                        <i class=\"fa fa-user fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n" +
"                    </a>\n" +
"                    <ul class=\"dropdown-menu dropdown-user\">\n" +
"                        <li><a href=\"#\"><i></i></a>\n" +
"                        </li>\n" +
"                        <li class=\"divider\"></li>\n" +
"                        <li><a href=\"\"><i class=\"fa fa-sign-out fa-fw\"></i>Cerrar Sección</a>\n" +
"                        </li>\n" +
"                    </ul>\n" +
"                </li>\n" +
"            </ul>\n" +
"\n" +
"            <div class=\"navbar-default sidebar\" role=\"navigation\">\n" +
"                <div class=\"sidebar-nav navbar-collapse\">\n" +
"                    <ul class=\"nav\" id=\"side-menu\">\n" +
"\n" +
"                    \n" +
"                    <li>\n" +
"                            <a href=\"#\"><i class=\"fa fa-film fa-fw\"></i> Producto<span class=\"fa arrow\"></span></a>\n" +
"                            <ul class=\"nav nav-second-level\">\n" +
"                     \n" +
"                                <li>\n" +
"                                \n" +
"                                    <a href=\"plantillaCrear\"><i class='fa fa-plus fa-fw'></i>Agregar </a>\n" +
"                                </li>\n" +
"\n" +
"                                <li>\n" +
"                                    <a href=\"VerProductos\"><i class='fa fa-list-ol fa-fw'></i> Ver </a>\n" +
"                                </li>\n" +
"                            </ul>\n" +
"                        </li>\n" +
"\n" +
"    <li>\n" +
"                            <a href=\"#\"><i class=\"fa fa-film fa-fw\"></i>Bodegas<span class=\"fa arrow\"></span></a>\n" +
"                            <ul class=\"nav nav-second-level\">\n" +
"                         \n" +
"                                <li>\n" +
"                                    <a href=\"plantillaCrearBodega\"> <i class='fa fa-plus fa-fw'></i> Agregar </a>\n" +
"                                </li>\n" +
"                                <li>\n" +
"                                \n" +
"                                    <a href=\"VerBodega\"><i class='fa fa-list-ol fa-fw'></i>Ver</a>\n" +
"                                </li>\n" +
"                            </ul>\n" +
"                        </li>\n" +
"                        \n" +
"                      \n" +
"                        \n" +
"                        <li>\n" +
"                            <a href=\"#\"><i class=\"fa fa-film fa-fw\"></i> Movimientos<span class=\"fa arrow\"></span></a>\n" +
"                            <ul class=\"nav nav-second-level\">\n" +
"                          \n" +
"                                <li>\n" +
"                                    <a href=\"crearMov\"> <i class='fa fa-plus fa-fw'></i> Agregar </a>\n" +
"                                </li>\n" +
"                                <li>\n" +
"                                    <a href=\"verMov\"> <i class='fa fa-plus fa-fw'></i> Ver </a>\n" +
"                                </li>\n" +
"                                \n" +
"                            </ul>\n" +
"                        </li>\n" +
"                        \n" +
"                        \n" +
"\n" +
"                   \n" +
"           \n" +
"\n" +
"                          \n" +
"                    </ul>\n" +
"                </div>\n" +
"            </div>\n" +
"\n" +
"\n" +
"     </nav>\n" +
"\n" +
"  <div id=\"page-wrapper\">\n");
             out.println("<legend><h3>Crear Movimientos</h3></legend>");
            out.println("<h4>Lista de Productos</h4>");
            
            out.println("<form action=\"ingresarMov\" method=\"post\">");
            
            out.println("<div class=\"form-group\">");
           out.println(" <select name=\"id_p\" id=\"id_p\">");
           
          
           for(Producto p : productoFacade.findAll()) {
               
                out.println("<option>"+ p.getId() +"</option>");
               
            }
           out.println("</select>");
            out.println("</div>");
            
            
          pr =bodegaFacade.findAll();
          
          out.println("<div class=\"form-group\">");
          out.println("<p>");
           out.println("<h4>Lista de Bodegas</h4>");
           out.println("<label>Bodega Origen: </label>");
           
             out.println("<div class=\"form-group\">");
           out.println("<select name=\"id_bo\" id=\"id_bo\">");
            
           for(Bodega b : pr) {
              
                out.println("<option>"+ b.getId()+"</option>");
               
            }
           out.println("</select>");
            out.println("</div>");
           out.println("</p>");
           
         
          
           out.println("<label>Bodega Destino: </label>");
            
            out.println("<div class=\"form-group\">");
                out.println("<p>");
           out.println("<select name=\"id_bd\" id=\"id_bd\">");
              out.println("<option>---</option>");
           for(Bodega b : pr) {
                out.println("<option>"+ b.getId()+"</option>");
               
            }
           out.println("</select>");
           out.println("</p>");
            out.println("</div>");
           
         out.println("<div class=\"form-group\">");
              out.println("<p>");
              
            out.println("<h4>Cantidad</h4>");
            out.println("<input type=\"text\" name=\"cantidad\">");
          out.println("</p>");
          
          out.println("<p>");
           out.println("<h4>Tipo de Movimiento</h4>");
            
           out.println("<select name=\"tipo_m\" id=\"tipo_m\">");
            
           out.println("<option>INGRESO</option>");
           out.println("<option>EGRESO</option>");
           out.println("<option>EGRESO POR TRASPASO</option>");
           out.println("<option>INGRESO POR TRASPASO</option>");
           
           out.println("</select>");
           out.println("</p>");
           
            out.println("<p>");
           out.println(" <button class=\"btn btn-primary\" type=\"submit\">Guardar</button>");
           out.println("</p>");
           
           out.println("</div>");
           out.println("</form>");
           
          
           
        

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
