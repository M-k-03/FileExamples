/**
 * 
 */
package com.example.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Muthu
 *
 */
public class FileExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// C:\Users\Muthu\Desktop\FileEx

		try {
			File files = new File("C:/Users/Muthu/Desktop/FileEx/Test.txt");
			String str = "A0001212-A2332FR-B232433-C344343-C344343";
			FileOutputStream outputStream = new FileOutputStream(files);
			byte[] strToBytes = str.getBytes();
			outputStream.write(strToBytes);
			outputStream.close();

			FileOutputStream outputStream1 = null;
			Path path = Paths.get("C:\\Users\\Muthu\\Desktop\\FileEx\\Test.txt");
			try (InputStream in = Files.newInputStream(path);
					BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					Set<String> foo = new HashSet<String>(Arrays.asList(line.split("-")));
					System.out.println("set.." + foo);

					for (String filename : foo) {
						// Create Multiple files
						byte[] br = filename.getBytes();
						outputStream1 = new FileOutputStream(
								new File("C:/Users/Muthu/Desktop/FileEx/" + filename + ".txt"));
						outputStream1.write(br);
						outputStream.close();
					}

				}
			} catch (IOException x) {
				System.err.println(x);
			}

		} catch (IOException x) {
			// Some other sort of failure, such as permissions.
			System.err.format("createFile error: %s%n", x);
		}

	}

}
