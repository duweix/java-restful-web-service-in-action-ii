package my.restful.my_first_webapp.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import my.restful.my_first_webapp.entity.Link;
import my.restful.my_first_webapp.entity.Links;
import my.restful.my_first_webapp.entity.Yijing;
import my.restful.my_first_webapp.entity.Yijings;

@Path("query-resource")
public class QueryResourceImpl {
	private static final List<Yijing> globalList = new ArrayList<>();

	static {
		globalList.add(new Yijing(1L));
		globalList.add(new Yijing(2L));
		globalList.add(new Yijing(3L));
		globalList.add(new Yijing(4L));
		globalList.add(new Yijing(5L));
		globalList.add(new Yijing(6L));
		globalList.add(new Yijing(7L));
		globalList.add(new Yijing(8L));
		globalList.add(new Yijing(9L));
		globalList.add(new Yijing(10L));
		globalList.add(new Yijing(11L));
		globalList.add(new Yijing(12L));
		globalList.add(new Yijing(13L));
		globalList.add(new Yijing(14L));
		globalList.add(new Yijing(15L));
		globalList.add(new Yijing(16L));
		globalList.add(new Yijing(17L));
		globalList.add(new Yijing(18L));
		globalList.add(new Yijing(19L));
		globalList.add(new Yijing(20L));
	}

	@GET
	@Path("yijings")
	@Produces(MediaType.TEXT_PLAIN)
	public String getByPaging(@QueryParam("start") final int start, @QueryParam("size") final int size) {
		Links links = new Links();
		List<Yijing> yijings = new ArrayList<>();
		Yijings result = new Yijings();
		UriBuilder ub = UriBuilder.fromUri("query-resource/yijings");

		int listSize = globalList.size();
		final int max = size > listSize ? listSize : size;
		IntStream.range(0, max).mapToObj(idx -> globalList.get(start - 1 + idx)).forEach(yijing -> {
			final URI location = ub.clone().queryParam("id", yijing.getSequence()).build();
			final Link link = new Link("detail", location.toASCIIString(), MediaType.APPLICATION_XML);
			links.add(link);
			yijings.add(yijing);
		});
		result.setLinks(links);
		result.setGuas(yijings);

		return result.toString();
	}
}
