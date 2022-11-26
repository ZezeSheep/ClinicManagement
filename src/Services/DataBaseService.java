package Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataBaseService {
	private String dbName;
	private FileWriter dbWriter;
	private BufferedReader dbReader;

	public DataBaseService(String dbName) throws IOException {
		File dbFile = new File(dbName);
		this.dbWriter = new FileWriter(dbFile);
		this.dbReader = new BufferedReader(new FileReader(dbFile));
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void writeLine(String newDbLine) throws IOException {
		dbWriter.write(newDbLine);
		dbWriter.flush();
	}

	public ArrayList<String> readLines() throws IOException {
		String lineRead;
		ArrayList<String> linesRead = new ArrayList<String>();
		while ((lineRead = dbReader.readLine()) != null) {
			linesRead.add(lineRead);
		}
		return linesRead;
	}

	public String findLine(String match) throws IOException {
		String lineRead;
		while ((lineRead = dbReader.readLine()) != null) {
			if (lineRead.contains(match)) {
				return lineRead;
			}
		}
		return null;
	}

	public void closeConnection() throws IOException {
		dbReader.close();
		dbWriter.close();
	}

}
