package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertLanguageClass;
import model.LanguageModel;
import response.LanguageResponse;

@Path("/insertLanguage")
public class InsertLanguageAPI {
@POST
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public LanguageResponse insertLanguage(LanguageModel model){
	return InsertLanguageClass.insertLanguage(model);
}
}
