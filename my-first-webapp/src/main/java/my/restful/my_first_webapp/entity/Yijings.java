package my.restful.my_first_webapp.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Yijings {
	private Links links;
	private List<Yijing> guas;
}
