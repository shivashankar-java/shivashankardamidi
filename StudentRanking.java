package pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentRanking {

	public static void main(String[] args) {
		 String csvFile = "\\E:\\shiva.csv\\"; // Path to the CSV file
	        String line;
	        String csvSplitBy = ",";
	        List<Student> students = new ArrayList<>();

	        
	     // Read CSV file and process data
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	            // Skip the header line
	            br.readLine();
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(csvSplitBy);
	                int rollNo = Integer.parseInt(data[0]);
	                String name = data[1];
	                int English = Integer.parseInt(data[2]);
	                int Maths = Integer.parseInt(data [3]);
	                int science = Integer.parseInt(data[4]);
	                int Geography = Integer.parseInt(data[5]);
	                int totalMarks = English + Maths + science + Geography;
	                students.add(new Student(rollNo, name, totalMarks));

	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        // Sort students by total marks in descending order
	        Collections.sort(students, Comparator.comparingInt(s -> -s.totalMarks));

	        // Assign ranks
	        for (int i = 0; i < students.size(); i++) {
	            students.get(i).rank = i + 1;
	        }

	        // Display the results
	        System.out.println("rollNo\tTotal Marks\tRank");
	        for (Student student : students) {
	            System.out.println(student.rollNo + "\t" + student.totalMarks + "\t\t" + student.rank);
	        }
	}

}
