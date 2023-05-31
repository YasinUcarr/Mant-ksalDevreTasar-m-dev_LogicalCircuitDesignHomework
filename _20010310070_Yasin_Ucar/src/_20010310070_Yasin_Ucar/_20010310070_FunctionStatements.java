package _20010310070_Yasin_Ucar;

import java.util.ArrayList;

public class _20010310070_FunctionStatements {

	private String[][] truthTable;
	private ArrayList<String> variableList;

	public _20010310070_FunctionStatements(String[][] truthTable, ArrayList<String> variableList) {
		this.truthTable = truthTable;
		this.variableList = variableList;
		System.out.println("fonksiyon ifadeleri:");
		printMinterm("F = ");
		printMaxterm("F = ");
		getComplementOfTruthTable();
		printMinterm("F' = ");
		printMaxterm("F' = ");
	}

	private void printMinterm(String complement) {
		ArrayList<String> mintermList = new ArrayList<>();
		String minterm = "";
		System.out.print(complement);
		for (int i = 1; i < truthTable.length; i++) {
			String value = truthTable[i][variableList.size()];
			if (value.equals("1")) {
				for (int j = 0; j < variableList.size(); j++) {
					if (truthTable[i][j].equals("1")) {
						minterm = minterm + variableList.get(j);
					} else {
						minterm = minterm + variableList.get(j) + "'";
					}
				}
				mintermList.add(minterm);
				minterm = "";
			}
		}
		String minterms = mintermList.toString();
		minterms = minterms.substring(1, minterms.length() - 1);
		minterms = minterms.replace(", ", " + ");
		System.out.println(minterms);
	}

	private void printMaxterm(String complement) {
		ArrayList<String> maxtermList = new ArrayList<>();
		String maxterm = "";
		System.out.print(complement);
		for (int i = 1; i < truthTable.length; i++) {
			String value = truthTable[i][variableList.size()];
			if (value.equals("0")) {
				for (int j = 0; j < variableList.size(); j++) {
					if (truthTable[i][j].equals("0")) {
						maxterm = maxterm + variableList.get(j);
					} else {
						maxterm = maxterm + variableList.get(j) + "'";
					}
					if (variableList.size() - 1 != j) {
						maxterm = maxterm + " + ";
					}
				}
				maxtermList.add("(" + maxterm + ")");
				maxterm = "";
			}
		}
		String maxterms = maxtermList.toString();
		maxterms = maxterms.substring(1, maxterms.length() - 1);
		maxterms = maxterms.replace(", ", ".");
		System.out.println(maxterms);
	}

	private void getComplementOfTruthTable() {
		for (int i = 1; i < truthTable.length; i++) {
			String bit = truthTable[i][variableList.size()];
			if (bit.equals("1")) {
				truthTable[i][variableList.size()] = "0";
			} else {
				truthTable[i][variableList.size()] = "1";
			}
		}
	}
}
