import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class InteractiveMode {

    private String args[];

    public void Interactive(String args[]) {
        boolean exit = true;
        String path = "";
        System.out.println("<you chose interactive mode>");

        while (exit == true) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("Сhoose a hashing algorithm:\n 1- md5\n 2- sha256\n 3- Exit");
                String num = in.nextLine();

                while (!(num.equals("1")) && !(num.equals("2")) && !(num.equals("3"))) {
                    System.out.println("Enter the correct number: ");
                    num = in.nextLine();
                }
                switch (num) {
                    case "1":
                        System.out.println("Enter the path to the file: \n");
                        path = in.nextLine();
                        System.out.println("File checksum md5:  " + DigestUtils.md5Hex(new FileInputStream(path)));
                        break;

                    case "2":
                        System.out.println("Enter the path to the file: \n");
                        path = in.nextLine();
                        System.out.println("File checksum sha256:  " + DigestUtils.sha256Hex(new FileInputStream(path)));
                        break;
                    case "3":
                        exit = false;
                        break;
                }

            } catch (IOException ex) {
                System.out.println("Invalid file path, try again.\n");
            }
        }
    }
}




