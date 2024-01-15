package hd.soft.mowItNow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static hd.soft.mowItNow.Position.toOutputFormat;
import static java.lang.System.out;

@Slf4j
public class Main {


	public static void main(String[] args) {
		InputParams params = InputParams.from(args);

		List<Position> result = new Runner(params).execute();

		out.println(toOutputFormat(result));
	}

}
