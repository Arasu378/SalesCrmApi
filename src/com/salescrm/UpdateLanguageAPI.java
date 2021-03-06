package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpadateLanguageClass;
import model.LanguageModel;
import response.LanguageResponse;

@Path("/updateLanguage")
public class UpdateLanguageAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public LanguageResponse updateLanguage(LanguageModel model){
	return UpadateLanguageClass.updateLanguage(model);
}
}
