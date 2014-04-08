package edu.kdm.reccomendation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class replace {
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("/home/varun/Desktop/KDM/datasets/midterm/Book_Ratings.csv"));
		
		
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("/home/varun/Desktop/KDM/datasets/midterm/Book_Ratings2.csv")));
		long count = 0;
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			System.out.println("---------");
			
			System.out.println(line);
			System.out.println("----------");
			
			int a = line.indexOf(';');
			int b = line.indexOf(a,';');
			int c = line.indexOf(b,';');
			if(line.indexOf(c, ';') !=-1)
			{
				System.out.println(line);
			}
			count++;
			line = line.replaceAll("::", "\",\"");
			out.write("\""+line+"\"");
			out.write("\n");
		}
		System.out.println("count -->"+count);
		scan.close();
		out.close();
	}

}
