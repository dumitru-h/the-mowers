package hd.soft.mowItNow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static hd.soft.mowItNow.Position.pos;
import static java.util.stream.Collectors.toList;

public class Runner {
	private final String filePath;

	public Runner(InputParams params) {
		this.filePath = params.getFile();
	}

	public List<Position> execute() {
		try (Scanner input = new Scanner(new FileInputStream(filePath))) {

			int
					maxX = input.nextInt(),
					maxY = input.nextInt();
			List<Tondeuse> tondeuses = new ArrayList<>();
			while (input.hasNext()) {
				int x = input.nextInt(), y = input.nextInt();
				String direction = input.next();
				String program = input.next();
				tondeuses.add(
						new Tondeuse(
								pos(x, y, direction.charAt(0)),
								maxX, maxY,
								program));
			}

			return tondeuses.stream().map(Tondeuse::execute).collect(toList());

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
