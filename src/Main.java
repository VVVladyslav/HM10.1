import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter reader = new BufferedWriter(new FileWriter("file.txt"));

        String num1 = "987-123-4567\n";
        String num2 = "123 456 7890\n";
        String num3 = "(123) 456-7890\n";
        String num4 = "123-456 7890\n";
        String num5 = "123-456-7890\n";
        String num6 = "(000) 000-0000";

        reader.write(num1);
        reader.write(num2);
        reader.write(num3);
        reader.write(num4);
        reader.write(num5);
        reader.write(num6);
        reader.close();

        int number = 0;
        int scobca = 0;
        int tire = 0;
        int space = 0;
        boolean spa = false;
        boolean tir = false;

        BufferedReader read = new BufferedReader(new FileReader("file.txt"));
        String c;
        while ((c = read.readLine()) != null) {

            char Simbol1 = c.charAt(0); // (
            char Simbol2 = c.charAt(4); // )

            char Simbol3 = c.charAt(5); // " "

            char Simbol4 = c.charAt(3); // -
            char Simbol5 = c.charAt(7); // -
            char Simbol6 = c.charAt(9); // -


            for (int i = 0; i < c.length(); i++) {
                char firstChar = c.charAt(i);
                int firstCharInt = (int) firstChar;

                if (firstCharInt >= 48 && firstCharInt <= 57) {
                    number = number + 1;
                }

                if (firstCharInt == 40 || firstCharInt == 41) {
                    scobca = scobca + 1;
                }

                if (firstCharInt == 45) {
                    tire = tire + 1;
                }

                if (firstCharInt == 32) {
                    space = space + 1;
                }

                if (space == 0 || space == 1) {
                    spa = true;
                }

                if (tire == 1 || tire == 2) {
                    tir = true;
                }


            }
            if(Simbol1 == '(' && Simbol2 == ')' && Simbol3 == ' ' && Simbol6 == '-' && number == 10 && c.length() == 14) {
                System.out.println(c);
            }

            if(Simbol4 == '-' && Simbol5 == '-' && number == 10 && c.length() == 12) {
                System.out.println(c);
            }
              number = 0;
              scobca = 0;
              tire = 0;
              space = 0;
              spa = false;
              tir = false;
        }
        read.close();
    }
}