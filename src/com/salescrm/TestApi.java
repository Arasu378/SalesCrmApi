package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.TestClass;


@Path("/getTest")
public class TestApi {
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public String loginuser(){
		return TestClass.getTest();
	}
}
