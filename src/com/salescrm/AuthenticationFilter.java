/**
 * 
 */
package com.salescrm;

import java.io.IOException;
import java.util.StringTokenizer;

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
		if(authorizationHeader==null){
			throw new NotAuthorizedException("Authorization header must be provided");
			
		}
	//	String token=authorizationHeader.substring("Kyros".length()).trim();
		int UserProfileId=getUserProfileId(authorizationHeader);
		String headerToken=getToken(authorizationHeader);
		System.out.println("System Token : "+headerToken);
		try{
		//	validateToken(token);
			validateTokenWithUserProfileId(UserProfileId,headerToken);
		}catch(Exception e){
			e.printStackTrace();
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			
		}
		
	}
	private static void validateTokenWithUserProfileId(int userProfileId,String token)throws Exception{
		String orginalToken=InsertTokenClass.getTokenByUserProfileId(userProfileId);
		System.out.println("Authentication value : "+orginalToken);
		if(!orginalToken.equals(token)){
			throw new NotAuthorizedException("Invalid Token!");	
		}
		
	}
	private static int getUserProfileId(String token){
		StringTokenizer stringTokenizer=new StringTokenizer(token);
		String firstOne=stringTokenizer.nextToken("|");
		String secondOne=stringTokenizer.nextToken();
		return Integer.parseInt(firstOne);
	}
	private static String getToken(String token){
		StringTokenizer stringTokenizer=new StringTokenizer(token);
		String firstOne=stringTokenizer.nextToken("|");
		return stringTokenizer.nextToken();
	}
	
	@SuppressWarnings("unused")
	private void validateToken(String token)throws Exception{
		boolean value=InsertTokenClass.findTokenIfExist(token);
		System.out.println("Authentication value : "+value);
		if(!value){
			throw new NotAuthorizedException("Invalid Token!");
		}
		
	}

}
