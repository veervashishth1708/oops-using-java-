import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class project6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String hospitalName = "CITY CARE HOSPITAL";
        String hospitalAddress = "Panipat, Haryana";
        String gstNo = "06ABCDE1234F1Z5";

        System.out.println("========================================");
        System.out.println("        " + hospitalName);
        System.out.println("========================================");

        System.out.print("Enter Patient Name : ");
        String patientName = sc.nextLine();

        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender : ");
        String gender = sc.nextLine();

        System.out.print("Enter Disease/Problem : ");
        String disease = sc.nextLine();

        System.out.println("\nSelect Doctor");
        System.out.println("1. Dr. Sharma (General Physician) - Rs.500");
        System.out.println("2. Dr. Gupta (Cardiologist) - Rs.1000");
        System.out.println("3. Dr. Mehta (Orthopedic) - Rs.800");
        System.out.println("4. Dr. Verma (Dermatologist) - Rs.700");

        System.out.print("Enter Choice : ");
        int choice = sc.nextInt();

        String doctorName = "";
        double consultationFee = 0;

        switch(choice) {
            case 1:
                doctorName = "Dr. Sharma";
                consultationFee = 500;
                break;

            case 2:
                doctorName = "Dr. Gupta";
                consultationFee = 1000;
                break;

            case 3:
                doctorName = "Dr. Mehta";
                consultationFee = 800;
                break;

            case 4:
                doctorName = "Dr. Verma";
                consultationFee = 700;
                break;

            default:
                doctorName = "General Doctor";
                consultationFee = 500;
        }

        int patientID = (int)(Math.random() * 90000) + 10000;

        double registrationFee = 100;
        double gst = consultationFee * 0.05;
        double totalBill = registrationFee + consultationFee + gst;

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("\n\n");
        System.out.println("=================================================");
        System.out.println("              " + hospitalName);
        System.out.println("=================================================");
        System.out.println("Address : " + hospitalAddress);
        System.out.println("GST No  : " + gstNo);
        System.out.println("Date    : " + format.format(now));
        System.out.println("Patient ID : " + patientID);

        System.out.println("-------------------------------------------------");
        System.out.println("Patient Name : " + patientName);
        System.out.println("Age          : " + age);
        System.out.println("Gender       : " + gender);
        System.out.println("Disease      : " + disease);
        System.out.println("Doctor       : " + doctorName);

        System.out.println("-------------------------------------------------");
        System.out.printf("Registration Fee      : Rs. %.2f%n",
                registrationFee);

        System.out.printf("Consultation Fee      : Rs. %.2f%n",
                consultationFee);

        System.out.printf("GST (5%%)             : Rs. %.2f%n",
                gst);

        System.out.println("-------------------------------------------------");

        System.out.printf("TOTAL BILL            : Rs. %.2f%n",
                totalBill);

        System.out.println("=================================================");
        System.out.println("       THANK YOU FOR VISITING US");
        System.out.println("          GET WELL SOON");
        System.out.println("=================================================");

        sc.close();
    }
}