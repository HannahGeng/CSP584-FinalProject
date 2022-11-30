package com.iit.servlet.model;

import com.iit.bean.User;
import com.iit.constant.StoreConstants;
import com.iit.servlet.base.ModelBaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RecommendServlet extends ModelBaseServlet {
    public void showRecommend(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        if(type.equals("recommend")) {
            processTemplate("product/recommend", request, response);
        }
    }
    public void getRecommend(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getSession().getAttribute(StoreConstants.USERSESSIONKEY);
        String preference = user.getPreference();

    }

}
