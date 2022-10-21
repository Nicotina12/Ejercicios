package figuras;

import static org.junit.Assert.*;

import org.junit.Test;

public class Lololo {

	@Test
public void FiguraTest() {
		Elipse el1 = new Elipse (8, 4);
		assertEquals (el1.getArea(),100.53,0);
		
	}
}
