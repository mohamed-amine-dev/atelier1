package ma.fstt.atelier1.controllers;

import ma.fstt.atelier1.dao.ClientDAO;
import ma.fstt.atelier1.entities.Client;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="client",value="/clients")
public class ClientServlet extends HttpServlet {
    private ClientDAO clientDAO;

    @Override
    public void init() throws ServletException {
        try {
            clientDAO = new ClientDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                listClients(request, response);
            } else {
                switch (action) {
                    case "add":
                        showAddForm(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteClient(request, response);
                        break;
                    default:
                        listClients(request, response);
                        break;
                }
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("update".equals(action)) {
                updateClient(request, response);
            } else {
                addClient(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listClients(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Client> clients = clientDAO.getAll();
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("/WEB-INF/views/client/clients.jsp").forward(request, response);

    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/client/client-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        long id = Long.parseLong(request.getParameter("id"));
        Client client = clientDAO.getOne(id);
        request.setAttribute("client", client);
        request.getRequestDispatcher("/WEB-INF/views/client/client-form.jsp").forward(request, response);
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String adress = request.getParameter("adress");
        String phoneNumber = request.getParameter("phoneNumber");

        Client client = new Client(0, name, email, adress, phoneNumber);
        clientDAO.add(client);
        response.sendRedirect(request.getContextPath() + "/clients");
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String adress = request.getParameter("adress");
        String phoneNumber = request.getParameter("phoneNumber");

        Client client = new Client(id, name, email, adress, phoneNumber);
        clientDAO.update(client);
        response.sendRedirect(request.getContextPath() + "/clients");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        long id = Long.parseLong(request.getParameter("id"));
        Client client = clientDAO.getOne(id);
        if (client != null) {
            clientDAO.delete(client);
        }
        response.sendRedirect(request.getContextPath() + "/clients");
    }
}