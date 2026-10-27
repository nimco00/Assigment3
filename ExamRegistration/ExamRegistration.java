package Asigment3;

import java.util.Scanner;

//costum Exception
class InvalidRegistrationException extends Exception{
    public InvalidRegistrationException(String Message){
        super(Message);
    }
}

public class ExamRegistration {
    // Registration method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String studentId;
        String name;
        int age;
        double examMark;
        int subjects;

        System.out.println("======= EXAM REGISTRATION SYSTEM======= ");
        System.out.println();

        try {
            System.out.print("Enter Student ID: ");
            studentId = input.nextLine();

            if (studentId =="") {
                throw new InvalidRegistrationException(
                        "Student ID cannot be empty."
                );
            }

            System.out.print("Enter Student Name: ");
            name = input.nextLine();

            System.out.print("Enter Age: ");
            age = input.nextInt();

            if (age < 18) {
                throw new InvalidRegistrationException(
                        "Age must be at least 18."
                );
            }

            System.out.print("Enter Exam Mark: ");
            examMark = input.nextDouble();

            if (examMark < 0 || examMark > 100) {
                throw new InvalidRegistrationException(
                        "Exam mark must be between 0 and 100."
                );
            }

            System.out.print("Enter Number of Subjects: ");
            subjects = input.nextInt();

            if (subjects < 1 || subjects > 5) {
                throw new InvalidRegistrationException(
                        "Maximum allowed subjects is 5."
                );
            }

            System.out.println();
            System.out.println("Registration Successful");
            System.out.println("Student: " + name);
            System.out.println("Registered Subjects: " + subjects);

        } catch (InvalidRegistrationException e) {
            System.out.println();
            System.out.println("Registration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println();
            System.out.println("Registration Failed!");
            System.out.println("Error: Invalid input. Please enter the correct data type.");

        } finally {
            System.out.println();
            System.out.println("Registration attempt completed.");
            input.close();
        }
    }
}

