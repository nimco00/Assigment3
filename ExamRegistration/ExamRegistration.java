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
    public static void registerStudent(String studentId, String studentName, int age,
        double examMark, int subjects) throws InvalidRegistrationException {
        if (studentId.isEmpty()) {
            throw new InvalidRegistrationException("Student ID cannot be empty.");
        }
        if (age < 18) {
            throw new InvalidRegistrationException("Age must be at least 18.");
        }
        if (examMark < 0 || examMark > 100) {
            throw new InvalidRegistrationException(
                    "Exam mark must be between 0 and 100.");
        }

        if (subjects < 1) {
            throw new InvalidRegistrationException("Minimum allowed subjects is 1.");
        }

        if (subjects > 5) {
            throw new InvalidRegistrationException("Maximum allowed subjects is 5.");
        }

        // Successful registration
        System.out.println("Registration Successful");
        System.out.println("Student: " + studentName);
        System.out.println("Registered Subjects: " + subjects);
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("===== EXAM REGISTRATION SYSTEM =====");

            System.out.print("Enter Student ID: ");
            String studentId = input.nextLine();

            System.out.print("Enter Student Name: ");
            String studentName = input.nextLine();

            System.out.print("Enter Age: ");
            int age = input.nextInt();

            System.out.print("Enter Exam Mark: ");
            double examMark = input.nextDouble();

            System.out.print("Enter Number of Subjects: ");
            int subjects = input.nextInt();

            registerStudent(studentId, studentName, age, examMark, subjects);

        } catch (InvalidRegistrationException e){
            System.out.println("Registration");
            System.out.println("Eror :"+e.getMessage());
        }finally {
            System.out.println("Registration attempt complete");
            input.close();
        }
    }
}

