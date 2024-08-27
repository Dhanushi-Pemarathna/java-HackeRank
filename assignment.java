// You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them
// according to their CGPA in decreasing order. If two student have the same CGPA, then arrange them
// according to their first name in alphabetical order. If those two students also have the same first name,
// then order them according to their ID. No two students have the same ID.
// Hint: You can use comparators to sort a list of objects.

// Input Format

// The first line of input contains an integer N, representing the total number of students. The next
// lines contains a list of student information in the following structure:
// ID Name CGPA
// Constraints
// 2 ≤ N ≤ 1000
// 0 ≤ ID ≤ 100000
// 5 ≤ |Name| ≤ 30
// 0 ≤ CGPA ≤ 4.00
// The name contains only lowercase English letters. The contains only integer numbers without leading
// zeros. The CGPA will contain, at most, 2 digits after the decimal point.
// Output Format
// After rearranging the students according to the above rules, print the first name of each student on
// a separate line.
// Sample Input
// 5
// 33 Rumpa 3.68
// 85 Ashis 3.85
// 56 Samiha 3.75
// 19 Samara 3.75
// 22 Fahim 3.76

// Sample Output
// Ashis
// Fahim
// Samara
// Samiha
// Rumpa



import java.util.*;

public class assignment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        // Define a 2D array to store student information (ID, name, CGPA)
        String[][] studentInfo = new String[numStudents][3];

        // get student information
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student " + (i + 1) + " ID, name, and CGPA: ");
            int id = input.nextInt();
            String name = input.next();
            double cgpa = input.nextDouble();

            // Store student information in the array
            studentInfo[i][0] = String.valueOf(id);
            studentInfo[i][1] = name;
            studentInfo[i][2] = String.valueOf(cgpa);
        }

        // Sort studentInfo array based on CGPA, first name, and then ID
        Arrays.sort(studentInfo, new Comparator<String[]>() {
            
            public int compare(String[] student1, String[] student2) {
                double cgpa1 = Double.parseDouble(student1[2]);
                double cgpa2 = Double.parseDouble(student2[2]);

                // Compare CGPA
                if (cgpa1 != cgpa2) {
                    return Double.compare(cgpa2, cgpa1); // Sort by CGPA in descending order
                } else {
                    // if CGPA is same, compare by first name
                    int nameComparison = student1[1].compareTo(student2[1]); // Sort by first name alphabetically
                    if (nameComparison != 0) {
                        return nameComparison;
                    } else {
                        // if first name is same, compare by ID
                        int id1 = Integer.parseInt(student1[0]);
                        int id2 = Integer.parseInt(student2[0]);
                        return Integer.compare(id1, id2); // Sort by ID in ascending order
                    }
                }
            }
        });

        // Print the student information
        System.out.println("\nStudent Information (Sorted by CGPA):");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(studentInfo[i][0] + " : " + studentInfo[i][1]);
        }
    }
}
