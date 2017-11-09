package com.salescrm;


import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
/**  
* CORSFILTER.java - class adds the feature of cross platform to access REST API.  
* @author  Thirunavukkarasu v
* @version 1.0 
*
*/
@Provider
public class CORSFILTER implements ContainerResponseFilter {
	 /**
	   * This class adds the feature of cross platform to access REST API  
	   * 
	   * @param Set the application to use CORS feature.
	   * the command line arguments.
	   * @exception Any exception
	   * @return No return value.
	   */ 
   @Override
   public void filter(final ContainerRequestContext requestContext,
                      final ContainerResponseContext cres) throws IOException {
      cres.getHeaders().add("Access-Control-Allow-Origin", "*");
      cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
      cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
      cres.getHeaders().add("Access-Control-Max-Age", "1209600");
   }}

