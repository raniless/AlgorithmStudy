package question.testdome;

import java.io.*;

public class Needle {
    public static int count(String needle, InputStream haystack) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(haystack));
        int count = 0;
        String readLine = "";
        while((readLine = br.readLine()) != null) {
            if(readLine.contains(needle)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";

        try(InputStream inStream = new ByteArrayInputStream(inMessage.getBytes())) {
            System.out.println(Needle.count("there", inStream));
        }
    }
}