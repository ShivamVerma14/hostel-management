package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utils.Student;
import utils.StudentDAO;

public class AddStudentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String regNo = request.getParameter("regno");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String dob = request.getParameter("dob");
        char hostelBlock = request.getParameter("hostel").charAt(0);
        double hostelFee = Double.parseDouble(request.getParameter("Hostelfee"));
        double messFee = Double.parseDouble(request.getParameter("Messfee"));
        double feePaid = Double.parseDouble(request.getParameter("Feepaid"));
        String course = request.getParameter("course");
        int courseDuration = Integer.parseInt(request.getParameter("course_duration"));
        
        Student student = new Student(regNo, name, email, mobile, dob, hostelFee, messFee, feePaid, course, courseDuration, hostelBlock);
        StudentDAO.addStudent(student);
        
        response.sendRedirect("Student.jsp");
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
