import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class ManualMode {

    private String args[];

    public void GetHash(String args[]) {
	if (!(args[1].equals("-f"))){
		      System.out.println("input error, try again");
		  }
        System.out.println("<you chose manual mode>");
        try {
            switch (args[0]) {
                case "-md5":
                    System.out.println("File checksum md5:  " + DigestUtils.md5Hex(new FileInputStream(args[2])));
                    break;

                case "-sha256":
                    System.out.println("File checksum sha256:  " + DigestUtils.sha256Hex(new FileInputStream(args[2])));
                    break;
            }
        } catch (IOException ex) {
            System.out.println("Invalid file path, try again.\n");
        }
    }
}
