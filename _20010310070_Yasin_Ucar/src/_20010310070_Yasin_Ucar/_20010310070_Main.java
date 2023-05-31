package _20010310070_Yasin_Ucar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _20010310070_Main {

	public static void main(String[] args) {
		String fileName = "karnaugh.txt";
		new _20010310070_TruthTable(read(fileName));
	}

	private static ArrayList<String> read(String fileName) {
		ArrayList<String> dataList = new ArrayList<>();
		File file = new File(fileName);
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				dataList.add(line);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(fileName + " dosyası okundu.");
		return dataList;
	}
}
