/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ipn.mx.controlador;

import com.google.gson.Gson;
import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.dto.ProductoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cafe_
 */
@WebServlet(name = "Lista", urlPatterns = {"/Lista"})
public class Lista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("opcion");
            ProductoDAO dao = new ProductoDAO();
            if(name.contentEquals("anual")){
                try {
                    List productos = dao.readTop10();

                    String[] arregloFinal = new String[productos.size()];
                    arregloFinal = (String[]) productos.toArray(arregloFinal);

                    Gson gson = new Gson();
                    String user = gson.toJson(arregloFinal);   
                    PrintWriter pw = response.getWriter();
                    response.setContentType("aplication/json");
                    response.setCharacterEncoding("UTF-8");
                    pw.write(user);
                    pw.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }else if(name.contentEquals("mensual")){
                try {
                    List productos = dao.readTop10M();

                    String[] arregloFinal = new String[productos.size()];
                    arregloFinal = (String[]) productos.toArray(arregloFinal);

                    Gson gson = new Gson();
                    String user = gson.toJson(arregloFinal);   
                    PrintWriter pw = response.getWriter();
                    response.setContentType("aplication/json");
                    response.setCharacterEncoding("UTF-8");
                    pw.write(user);
                    pw.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }else if(name.contentEquals("categoria")){
                try {
                    List productos = dao.readTop5();

                    String[] arregloFinal = new String[productos.size()];
                    arregloFinal = (String[]) productos.toArray(arregloFinal);

                    Gson gson = new Gson();
                    String user = gson.toJson(arregloFinal);   
                    PrintWriter pw = response.getWriter();
                    response.setContentType("aplication/json");
                    response.setCharacterEncoding("UTF-8");
                    pw.write(user);
                    pw.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
                } 
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
