package com.iit.servlet.model;

import com.google.gson.JsonObject;
import com.iit.bean.*;
import com.iit.constant.StoreConstants;
import com.iit.service.OrderItemService;
import com.iit.service.OrderService;
import com.iit.service.StoreService;
import com.iit.service.impl.OrderItemServiceImpl;
import com.iit.service.impl.OrderServiceImpl;
import com.iit.service.impl.StoreServiceImpl;
import com.iit.servlet.base.ModelBaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServlet extends ModelBaseServlet {

    StoreService storeService = new StoreServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    OrderItemService orderItemService = new OrderItemServiceImpl();

    public void toPlaceOrderPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Store> storesList = storeService.selectStores();
        request.setAttribute("stores", storesList);

        User user = (User)request.getSession().getAttribute(StoreConstants.USERSESSIONKEY);

        if (user != null) {
            processTemplate("order/placeorder", request, response);
        } else {
            processTemplate("user/login",request,response);
        }
    }

    public void toVieworderPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processTemplate("order/vieworder", request, response);
    }

    public void toOrderdetailPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processTemplate("order/orderdetail", request, response);
    }

    public void placeOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Order order = new Order();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        try {
            BeanUtils.populate(order, parameterMap);
            orderService.saveOrder(order);
            System.out.println(order.toString());
            Map<Integer,CartItem> cartItem = cart.getCartItemMap();
            int orderid = orderService.getLastID();
            for (CartItem cartitem : cartItem.values()) {
                OrderItem orderItem = new OrderItem(cartitem.getProductid(),
                        orderid,cartitem.getCount(),
                        cartitem.getModel(),
                        cartitem.getAmount(),
                        cartitem.getPrice(),
                        null,
                        null,
                        null,
                        0.0,
                        1,
                        cartitem.getProductid());
                System.out.println(orderItem.toString());
                orderItemService.saveOrderItem(orderItem);
            }

            request.setAttribute("orderid",orderid);
            request.setAttribute("deliveryDate",new Date(System.currentTimeMillis()));
            processTemplate("order/order_success", request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}