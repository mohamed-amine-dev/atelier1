package ma.fstt.atelier1.controllers;

import ma.fstt.atelier1.dao.ClientDAO;
import ma.fstt.atelier1.dao.OrderDAO;
import ma.fstt.atelier1.dao.OrderLineDAO;
import ma.fstt.atelier1.dao.ProductDAO;
import ma.fstt.atelier1.entities.Client;
import ma.fstt.atelier1.entities.Order;
import ma.fstt.atelier1.entities.OrderLine;
import ma.fstt.atelier1.entities.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private OrderDAO orderDAO;
    private ClientDAO clientDAO;
    private ProductDAO productDAO;
    private OrderLineDAO orderLineDAO;

    @Override
    public void init() throws ServletException {

      try {
          orderDAO = new OrderDAO();
          clientDAO = new ClientDAO();
          productDAO = new ProductDAO();
          orderLineDAO = new OrderLineDAO();
      }catch (Exception e) {
          System.out.println(e.getMessage());
      }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                listOrders(request, response);
            } else {
                switch (action) {
                    case "add":
                        showAddForm(request, response);
                        break;
                    case "view":
                        viewOrder(request, response);
                        break;
                    case "delete":
                        deleteOrder(request, response);
                        break;
                    default:
                        listOrders(request, response);
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
        try {
            addOrder(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Order> orders = orderDAO.getAll();
        List<Client> clients = clientDAO.getAll();
        request.setAttribute("orders", orders);
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("/WEB-INF/views/order/orders.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Client> clients = clientDAO.getAll();
        List<Product> products = productDAO.getAll();
        request.setAttribute("clients", clients);
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/views/order/order-form.jsp").forward(request, response);
    }

    private void viewOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        long id = Long.parseLong(request.getParameter("id"));
        Order order = orderDAO.getOne(id);
        Client client = clientDAO.getOne(order.getClientId());
        List<OrderLine> orderLines = orderLineDAO.getLinesByOrder(id);

        request.setAttribute("order", order);
        request.setAttribute("client", client);
        request.setAttribute("orderLines", orderLines);
        request.setAttribute("products", productDAO.getAll());
        request.getRequestDispatcher("/WEB-INF/views/order/order-view.jsp").forward(request, response);
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        long clientId = Long.parseLong(request.getParameter("clientId"));

        Order order = new Order();
        order.setClientId(clientId);
        order.setDateCommand(LocalDateTime.now());
        order.setTotalAmount(0);

        orderDAO.add(order);
        response.sendRedirect(request.getContextPath() + "/orders");
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        long id = Long.parseLong(request.getParameter("id"));
        Order order = orderDAO.getOne(id);
        if (order != null) {
            orderDAO.delete(order);
        }
        response.sendRedirect(request.getContextPath() + "/orders");
    }
}