/**
 * 
 */
package com.salescrm;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import consumeclass.InsertTokenClass;

/**
 * @author thirunavukkarasu
 *
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter  {

	/* (non-Javadoc)
	 * @see javax.ws.rs.container.ContainerRequestFilter#filter(javax.ws.rs.container.ContainerRequestContext)
	 */
	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		String authorizationHeader=
				requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if(authorizationHeader==null || !authorizationHeader.startsWith("Kyros ")){
			throw new NotAuthorizedException("Authorization header must be provided");
			
		}
		String token=authorizationHeader.substring("Kyros".length()).trim();
		System.out.println("System Token : "+token);
		try{
			validateToken(token);
		}catch(Exception e){
			e.printStackTrace();
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			
		}
		
	}
	private void validateToken(String token)throws Exception{
		boolean value=InsertTokenClass.findTokenIfExist(token);
		System.out.println("Authentication value : "+value);
		if(!value){
			throw new NotAuthorizedException("Invalid Token!");
		}
		
	}

}
