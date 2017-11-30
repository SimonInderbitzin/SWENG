package ch.fhnw.richards.lecture08_JavaFX_lists_tables.nationalAssemblyElection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NA_Model {
	private static final String FILE_NAME = "NationalAssemblyElections2007.txt";
	private static final String TAB = "\\t";

	private final ObservableList<Result> results = FXCollections.observableArrayList();

	public NA_Model() {
		results.addAll(loadFile());
	}

	/**
	 * Read the data from the file
	 */
	private List<Result> loadFile() {
		try (Stream<String> stream = getStreamOfLines(FILE_NAME, true)) {
			return stream.skip(1)                              // Skip the header line
			             .map(s -> new Result(s.split(TAB)))   // Create new object from each line
			             .collect(Collectors.toList());        // Collect all objects into a list
		}
	}

	/**
	 * This is how we could save the data - not used in this example
	 */
	public void saveFile() {
		try (BufferedWriter writer = Files.newBufferedWriter(getPath(FILE_NAME, true))) {
			writer.write("Gemeinde-Nr.\tBFS Gemeinden\tKanton\tFDP\tCVP\tSPS\tSVP\tLPS\tEVP\tCSP\tGLP\tPdA\tSol.\tFGA\tGPS\tSD\tEDU\tFPS\tLega\tÜbrige\tWahlberechtigte\tWählende");
			writer.newLine();
			results.stream().forEach(result -> {
				try {
					writer.write(result.infoAsLine());
					writer.newLine();
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			});
		} catch (IOException e) {
			throw new IllegalStateException("save failed");
		}
	}

	/**
	 * In our case, the data file is in the same location as the class.
	 * Otherwise, located at the project root
	 */
	private Stream<String> getStreamOfLines(String fileName, boolean locatedInSameFolder) {
		try {
			return Files.lines(getPath(fileName, locatedInSameFolder), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private Path getPath(String fileName, boolean locatedInSameFolder)  {
		try {
			if(!locatedInSameFolder) fileName = "/" + fileName;
			return Paths.get(getClass().getResource(fileName).toURI());
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
	}

	// all getters and setters

	public ObservableList<Result> getResults() {
		return results;
	}
}
