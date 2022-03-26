import sun.nio.cs.US_ASCII;

import java.io.*;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    Character cs;
    Character cf;
    Integer shift;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
        this.shift = cf - cs;
    }

    ROT13() {
        this('a', 'n');
    }


    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder crypt = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) {
                c += shift;
            } else if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) {
                c -= shift;
            }
            crypt.append(c);
        }
        return crypt.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        int shift = c - 'A';
        StringBuilder rotate = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char r = s.charAt(i);
            if (i < s.length()/2) {
                r += shift;
            } else if (i >= s.length()/2) {
                r -= shift;
            }
            rotate.append(r);
        }
        return rotate.toString();
    }

    public String sonnetReader() {
        String line = "";
        String file = "";
        Scanner reader = null;
        try {
            reader = new Scanner(new File("/Users/nusera/Development/SimpleCrypt/sonnet18.txt"));
            {
                while (reader.hasNext()) {
                    line = reader.nextLine();
                    file += line + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert reader != null;
            reader.close();
        }
        return file;
    }

    public String sonnetEnc() {
        String sonnet18 = crypt(sonnetReader());
        return sonnet18;
    }

    public static void createFile() {
        try {
            File sonnet18enc = new File("/Users/nusera/Development/SimpleCrypt/sonnet18.enc");
            if (sonnet18enc.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void fileWriter() {
        createFile();
        try {
            FileWriter sonnetEnc = new FileWriter("/Users/nusera/Development/SimpleCrypt/sonnet18.enc"); {
                sonnetEnc.write(sonnetEnc());
                sonnetEnc.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sonnetEncReader() {
        fileWriter();
        String line = "";
        String file = "";
        Scanner reader = null;
        try {
            reader = new Scanner(new File("/Users/nusera/Development/SimpleCrypt/sonnet18.enc"));
            {
                while (reader.hasNext()) {
                    line = reader.nextLine();
                    file += line + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert reader != null;
            reader.close();
        }
        return file;
    }

}
