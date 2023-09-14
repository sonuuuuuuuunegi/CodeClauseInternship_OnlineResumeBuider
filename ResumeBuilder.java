package codeclause;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ResumeBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Resume Builder");
        System.out.println("Please enter your details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Objective: ");
        String objective = scanner.nextLine();

        System.out.println("\nEducation:");
        System.out.print("Degree: ");
        String degree = scanner.nextLine();
        System.out.print("Institution: ");
        String institution = scanner.nextLine();
        System.out.print("Year: ");
        String eduYear = scanner.nextLine();

        System.out.println("\nWork Experience:");
        System.out.print("Job Title: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Company: ");
        String company = scanner.nextLine();
        System.out.print("Year: ");
        String workYear = scanner.nextLine();

        // Create a resume
        Resume resume = new Resume(name, email, phone, objective);
        resume.addEducation(degree, institution, eduYear);
        resume.addWorkExperience(jobTitle, company, workYear);

        // Generate and display the resume
        String generatedResume = resume.generate();
        System.out.println("\nGenerated Resume:");
        System.out.println(generatedResume);

        // Save the resume to a file (optional)
        try {
            FileWriter writer = new FileWriter("resume.txt");
            writer.write(generatedResume);
            writer.close();
            System.out.println("Resume saved to resume.txt");
        } catch (IOException e) {
            System.err.println("Error saving the resume to a file: " + e.getMessage());
        }

        scanner.close();
    }
}

class Resume {
    private String name;
    private String email;
    private String phone;
    private String objective;
    private String education;
    private String workExperience;

    public Resume(String name, String email, String phone, String objective) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.objective = objective;
        this.education = "";
        this.workExperience = "";
    }

    public void addEducation(String degree, String institution, String year) {
        education += "Degree: " + degree + "\n";
        education += "Institution: " + institution + "\n";
        education += "Year: " + year + "\n\n";
    }

    public void addWorkExperience(String jobTitle, String company, String year) {
        workExperience += "Job Title: " + jobTitle + "\n";
        workExperience += "Company: " + company + "\n";
        workExperience += "Year: " + year + "\n\n";
    }

    public String generate() {
        StringBuilder resume = new StringBuilder();
        resume.append("Name: ").append(name).append("\n");
        resume.append("Email: ").append(email).append("\n");
        resume.append("Phone: ").append(phone).append("\n");
        resume.append("Objective: ").append(objective).append("\n\n");

        resume.append("Education:\n").append(education).append("\n");
        resume.append("Work Experience:\n").append(workExperience);

        return resume.toString();
    }
}
