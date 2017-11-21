package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.DeleteLanguageClass;
import model.LanguageModel;
import response.LanguageResponse;

@Path("/deleteLanguage")
public class DeleteLanguageAPI {
@DELETE
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public LanguageResponse deleteLanguage(LanguageModel model){
	return DeleteLanguageClass.deleteLanguage(model);
}
}
