package com.salescrm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertConnectionsClass;
import model.ConnectionsModel;
import response.ConnectionsResponse;

@Path("/insertConnection")
public class InsertConnectionAPI {
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public ConnectionsResponse insertConnection(ConnectionsModel model){
	return InsertConnectionsClass.insertConnection(model);
}
}
