package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String returnedProducts = "";
		
		//Instantiate httpclient
	     CloseableHttpClient httpclient = HttpClients.createDefault();
	      try {
	          HttpGet httpGet = new HttpGet("http://api.walmartlabs.com/v1/trends?format=json&apiKey=wyxj39pxu4g3xsyghhbgb9ak");
	          CloseableHttpResponse response1 = httpclient.execute(httpGet);
	          try {
	              System.out.println(response1.getStatusLine());
	              HttpEntity entity1 = response1.getEntity();
	              if(entity1 != null){
	                	returnedProducts =  EntityUtils.toString(entity1);
	                	System.out.println(returnedProducts);
	                } else {
	                	// and ensure it is fully consumed
	                	EntityUtils.consume(entity1);
	                }
	              EntityUtils.consume(entity1);
	          } finally {
	              response1.close();
	          }
              
	 	     try {
	 			JSONObject myObject = new JSONObject(returnedProducts);
	 			String myOb = myObject.toString();
	 			
	 			response.setContentType("application/json");
	 		    response.setCharacterEncoding("UTF-8");
	 		    response.getWriter().write(myOb);
	 		    
	 		} catch (JSONException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}

	      } finally {
	          httpclient.close();
	      }    
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
