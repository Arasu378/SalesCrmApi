package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.LoginClass;
import model.LoginModel;
import response.LoginResponse;

@Path("/login")
public class LoginAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public LoginResponse login(LoginModel model){
	return LoginClass.login(model);
}
}
