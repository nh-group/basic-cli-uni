package fr.pantheonsorbonne.ufr27.app;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

import fr.pantheonsorbonne.ufr27.Secured;
import fr.pantheonsorbonne.ufr27.action.EducationAction;
import fr.pantheonsorbonne.ufr27.configuration.AppConfiguration;
import fr.pantheonsorbonne.ufr27.console.ConsoleEventParser;
import fr.pantheonsorbonne.ufr27.exception.EducationException;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		LOG.info(new App().toString());
		Arrays.stream(App.class.getDeclaredFields()).forEach((Field f) -> LOG.info("field in App: " + f.getName()));

		Injector injector = Guice.createInjector(new AppConfiguration());
		Scanner scanner = new Scanner(System.in);
		String line = "";
		ConsoleEventParser parser = injector.getInstance(ConsoleEventParser.class);
		LOG.info("}]]] " + parser.toString());

		while (!(line = scanner.nextLine()).isEmpty()) {
			EducationAction action;
			try {
				action = parser.parse(line);
				action.perform();
			} catch (EducationException e) {
				LOG.warn(e.getMessage(), e);
			}

		}
		scanner.close();

	}

	
	public String toString() {
		return "compiled message";

	}
}
