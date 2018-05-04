package my.restful.my_first_webapp.app;

import java.util.HashSet;
import java.util.Set;

import my.restful.my_first_webapp.MyResource;

//@ApplicationPath("/webapi/*")
public class AirApplication /* extends Application */ {
	// @Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(MyResource.class);
		return classes;
	}
}
