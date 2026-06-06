import java.util.Scanner;

public class MessageFile {
        private final Scanner scMassage = new Scanner(System.in);

        public String getMassage() {
            System.out.println("Your message: ");
            return scMassage.nextLine();
        }

}
