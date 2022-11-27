package com.iit.servlet.model;

import com.iit.bean.Product;
import com.iit.bean.Review;
import com.iit.service.ProductService;
import com.iit.service.impl.ProductServiceImpl;
import com.iit.servlet.base.ModelBaseServlet;
import com.iit.utils.MongoDBDataStoreUtilities;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ProductServlet extends ModelBaseServlet {
    MongoDBDataStoreUtilities mdsu;
    ProductService productService = new ProductServiceImpl();
    public void showProductList(HttpServletRequest request,HttpServletResponse response) {
        String type = request.getParameter("type");
        String manufacturer = request.getParameter("manufacturer");
        List<Product> productlist = new ArrayList<Product>();
        try {
            if(manufacturer==null) {
                productlist = productService.filterByType(type);
            }else {
                productlist = productService.filterByManufacturer(type, manufacturer);
            }
            request.setAttribute("type",type);
            request.setAttribute("productlist",productlist);
            processTemplate("product/productlist",request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toViewProductPage(HttpServletRequest request,HttpServletResponse response) throws IOException {

        int productID = Integer.parseInt(request.getParameter("id"));
        try {
            Product product = productService.filterById(productID);
            request.setAttribute("product",product);
            mdsu = new MongoDBDataStoreUtilities();
            HashMap<String, ArrayList<Review>> reviews = mdsu.readReview(productID);
            ArrayList<Review> review = reviews.get(request.getParameter("id"));
            request.setAttribute("review",review);
        } catch (Exception e) {
            e.printStackTrace();
        }
        processTemplate("product/viewproduct",request,response);
    }

    public void storeReviewToMongo(HttpServletRequest request,HttpServletResponse response) {
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        try {
            storeDataToMongoDB(request, response, productId);
            response.sendRedirect(request.getContextPath()+"/product?method=toViewProductPage&id="+productId);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void storeDataToMongoDB(HttpServletRequest request, HttpServletResponse response,
                                    Integer productId) {
        Product product;
        try {
            product = productService.filterById(productId);
            int prodId = product.getProductid();
            String productName = product.getName();
            double productPrice = product.getPrice();
            String type = product.getType();
            String manufacturer = product.getManufacturer();
            String manufacturerRebate="Yes";
            boolean productOnSale = (product.getQuantity() > 0 ? true : false);
            String retailername = request.getParameter("retailername");
            String retailerzip = request.getParameter("retailerzip");
            String retailercity = request.getParameter("retailercity");
            String retailerstate = request.getParameter("retailerstate");
            String username = request.getParameter("reviewername");
            String age = request.getParameter("reviewerage");
            String gender = request.getParameter("reviewergender");
            String occupation = request.getParameter("revieweroccupation");
            int rating = Integer.parseInt(request.getParameter("ratings"));
            String review = request.getParameter("review");
            String time = new Date(System.currentTimeMillis()).toString();
            // System.out.println(time);
            Review rev = new Review(prodId, productName, productPrice, type, manufacturer,manufacturerRebate, productOnSale ,retailername, retailerzip, retailercity, retailerstate,
                    username, age, gender, occupation, rating, review, time);
            mdsu = new MongoDBDataStoreUtilities();
            mdsu.storeReview(rev);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
