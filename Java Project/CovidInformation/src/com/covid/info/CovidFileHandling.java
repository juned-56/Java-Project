package com.covid.info;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CovidFileHandling {
	public static void main(String[] args) {
		String file = "C:\\Users\\javed\\Desktop\\owid-covid-data.csv";
		BufferedReader reader = null;
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				for(String index : row) {
					System.out.printf("%-10s", index);
				}
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
