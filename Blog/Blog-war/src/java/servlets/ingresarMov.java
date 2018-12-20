/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import data.Bodega;
import data.Movimiento;
import data.Producto;
import datasessionbeans.Data_BodegaFacadeLocal;
import datasessionbeans.Data_MovimientoFacadeLocal;
import datasessionbeans.Data_ProductoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ingresarMov extends HttpServlet {
    @EJB
    private Data_MovimientoFacadeLocal movimientoFacade;
    private Movimiento movimiento;
    
     @EJB
    private Data_ProductoFacadeLocal productoFacade;
    private Producto producto;
    
    @EJB
    private Data_BodegaFacadeLocal bodegaFacade;
    private Bodega bodega;
  
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Capturamos los valores
         String tipoM = request.getParameter("tipo_m").toUpperCase();
         String id_producto = request.getParameter("id_p").toUpperCase();
         String bodega_origen = request.getParameter("id_bo").toUpperCase();
         String cantidad = request.getParameter("cantidad").toUpperCase();
         
         Long id_produc = Long.parseLong(id_producto);
         Long id_bodega_origen = Long.parseLong(bodega_origen);
         
          int cant = Integer.parseInt(cantidad);
          Calendar c1 = Calendar.getInstance();
        
     producto = productoFacade.find(id_produc);
     bodega = bodegaFacade.find(id_bodega_origen);
    if(tipoM.equals("INGRESO")){
                
        movimiento = new Movimiento();
        movimiento.setProducto(producto);
        movimiento.setBodega(bodega);
        movimiento.setCantidad(cant);
        movimiento.setTipoMovimiento(tipoM);
       movimiento.setTotalUnidades(cant);
        movimiento.setFecha(c1);
        
        
         try {
            movimientoFacade.create(movimiento); 
        response.sendRedirect("index.html");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
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
