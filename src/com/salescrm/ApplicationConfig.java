package com.salescrm;

/**  
* ApplicationConfig.java - class adds the feature of multipart and logging filter.  
* @author  Thirunavukkarasu v
* @version 1.0 
*
*/
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class ApplicationConfig extends Application {

	 /**
	   * This class adds the feature of multipart and logging filter  
	   * 
	   * @param Set the application to access the multipart and loggging.
	   * the command line arguments.
	   * @exception Any exception
	   * @return No return value.
	   */ 
	 @Override
	    public Set<Class<?>> getClasses() {
	        final Set<Class<?>> classes = new HashSet<Class<?>>();
	        classes.add(MultiPartFeature.class);
	        classes.add(LoggingFilter.class);
	        return classes;
	    }
}
