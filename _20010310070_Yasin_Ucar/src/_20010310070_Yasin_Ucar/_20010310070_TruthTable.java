package _20010310070_Yasin_Ucar;

import java.util.ArrayList;
import java.util.HashMap;

public class _20010310070_TruthTable {

	private ArrayList<String> dataList;
	private ArrayList<String> variableList;
	private String[][] truthTable;
	private HashMap<String, String> diagramMap;

	public _20010310070_TruthTable(ArrayList<String> dataList) {
		this.dataList = dataList;
		getVariables();
		createTruthTable();
		new _20010310070_FunctionStatements(truthTable, variableList);
	}

	private void getVariables() {
		variableList = new ArrayList<String>();
		String variableLine = dataList.get(0);
		String variables = variableLine.substring(13, variableLine.length());

		for (String variable : variables.split(", ")) {
			variableList.add(variable);
		}
	}

	private void createTruthTable() {
		int variableCount = variableList.size();
		int row = (int) Math.pow(2, variableCount) + 1;
		int column = variableCount + 1;
		truthTable = new String[row][column];

		for (int i = 0; i < column; i++) {
			if (column - 1 != i) {
				truthTable[0][i] = variableList.get(i);
			} else {
				truthTable[0][i] = "F";
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < column - 1; j++) {
				truthTable[i][j] = Character.toString(getNBitBinary(variableCount, i - 1)[j]);
			}
		}

		setDiagramMap(variableCount);

		for (String key : diagramMap.keySet()) {
			int indis = Integer.valueOf(key);
			truthTable[indis + 1][variableCount] = diagramMap.get(key);
		}
		printTable(row, column);
	}

	private void setDiagramMap(int variableCount) {
		diagramMap = new HashMap<>();
		String[] mapIndexThreeVariable = { "0", "1", "3", "2", "4", "5", "7", "6" };
		String[] mapIndexFourVariable = { "0", "1", "3", "2", "4", "5", "7", "6", "12", "13", "15", "14", "8", "9",
				"11", "10" };
		int j = 0;
		for (int i = 2; i < dataList.size(); i++) {
			if (variableCount == 3) {
				for (String value : dataList.get(i).split(" ")) {
					diagramMap.put(mapIndexThreeVariable[j], value);
					j++;
				}
			} else {
				for (String value : dataList.get(i).split(" ")) {
					diagramMap.put(mapIndexFourVariable[j], value);
					j++;
				}
			}
		}
	}

	private void printTable(int row, int column) {
		System.out.println("doğruluk tablosu:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(truthTable[i][j] + " ");
			}
			System.out.println();
		}
	}

	private char[] getNBitBinary(int n, int number) {
		char[] binaryArray = new char[n];
		String binary = Integer.toBinaryString(number);

		while (binary.length() < n) {
			binary = "0" + binary;
		}

		binaryArray = binary.toCharArray();
		return binaryArray;
	}
}
