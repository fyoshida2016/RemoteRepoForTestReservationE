package model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class RoominfoTest {

	@Test
	public void test() {
		Roominfo ri=new Roominfo();
		ri.setRid(1);
		ri.setBuilding("総合研究棟");
		ri.setFloor("6階");
		ri.setNumber("607室");
		ri.setArea(60);
		ri.setCapacity(60);

		assertThat(ri.getRid(),is(1));
		assertThat(ri.getBuilding(),is("総合研究棟"));
		assertThat(ri.getFloor(),is("6階"));
		assertThat(ri.getNumber(),is("607室"));
		assertThat(ri.getArea(),is(60));
		assertThat(ri.getCapacity(),is(60));

	}

}
