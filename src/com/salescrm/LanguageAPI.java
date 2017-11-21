package com.salescrm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.LanguageClass;
import response.LanguageResponse;

@Path("/getLanguage")
public class LanguageAPI {
@GET
@Secured
@Produces(MediaType.APPLICATION_JSON)
public LanguageResponse getLanguage(){
	return LanguageClass.getLanguage();
}
}
