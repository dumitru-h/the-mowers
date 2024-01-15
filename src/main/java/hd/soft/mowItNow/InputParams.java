package hd.soft.mowItNow;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.io.File;

import static java.lang.System.exit;

@Data
@Slf4j
public class InputParams {
	public static final int
			EXIT_ON_ARG_PARSE_ERROR = 1,
			EXIT_ON_FILE_NOT_FOUND = 2;

	private String file;

	public static InputParams from(String[] args) {
		ArgumentParser parser = ArgumentParsers
				.newFor("lanceTondeuses").build()
				.defaultHelp(true)
				.description("Lance les tondeuses une après l'autres selon le program du fichier en entrée.");

		parser.addArgument("-f", "--file")
				.required(true)
				.help("fichier avec les coordonées et le programme des tondeuses");

		Namespace ns = null;
		try {
			ns = parser.parseArgs(args);
		} catch (ArgumentParserException e) {
			parser.handleError(e);
			exit(EXIT_ON_ARG_PARSE_ERROR);
		}

		File inputFile = new File(ns.getString("file"));
		if (!inputFile.exists()) {
			log.error("Fichier d'entrée non trouvé: " + inputFile);
			exit(EXIT_ON_FILE_NOT_FOUND);
		}

		InputParams params = new InputParams();
		params.setFile(inputFile.getAbsolutePath());

		return params;
	}
}
