import hd.soft.mowItNow.Position;
import hd.soft.mowItNow.Tondeuse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static hd.soft.mowItNow.Position.pos;

public class TestTondeuse {

	final int MAX_X = 5, MAX_Y=5;

	@Test
	void testProgramOne() {
		final Position startPos= pos(1, 2, 'N');
		final String program = "GAGAGAGAA";
		final Position actualEndPosition = new Tondeuse(startPos, MAX_X, MAX_Y, program).execute();
		final Position expectedPosition = pos(1, 3, 'N');

		assertEquals(expectedPosition, actualEndPosition);

	}

	@Test
	void testProgramTwo() {
		final Position startPos= pos(3, 3, 'E');
		final String program = "AADAADADDA";
		final Position actualEndPosition = new Tondeuse(startPos, MAX_X, MAX_Y, program).execute();
		final Position expectedPosition = pos(5, 1, 'E');

		assertEquals(expectedPosition, actualEndPosition);

	}
}
