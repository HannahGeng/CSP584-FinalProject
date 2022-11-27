package com.iit.servlet.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import com.iit.bean.Near;
import com.iit.servlet.base.ModelBaseServlet;
import com.google.maps.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NearByServlet extends ModelBaseServlet {
    public void showMap(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        if(type.equals("near-me")) {
            processTemplate("product/near-by", request, response);
        }
    }


    GeocodingApiRequest geocodingApiRequest;
    public void getAddress (HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException, ApiException {
        String address = request.getParameter("address");

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyBvJ0-vbqwdWJdOYGGQOhkxfdF9JkRSLwo")
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context,address).await();

        double lat = results[0].geometry.location.lat;
        double lng = results[0].geometry.location.lng;

        LatLng location = new LatLng(lat, lng);

        PlacesSearchResponse res =
            PlacesApi.nearbySearchQuery(context, location)
                    .radius(5000)
                    .rankby(RankBy.DISTANCE)
                    .language("en")
                    .openNow(true)
                    .type(PlaceType.ATM,PlaceType.BANK)
                    .pageToken("next-page-token")
                    .await();



        Near near1 = new Near(res.results[0].name,res.results[0].formattedAddress);
        Near near2 = new Near(res.results[1].name,res.results[1].formattedAddress);


        // Invoke .shutdown() after your application is done making requests
        context.shutdown();
    }
}
