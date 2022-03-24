import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    Character cs;
    Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
        this('a', 'n');
    }


    public String crypt(String text) throws UnsupportedOperationException {
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//        String encrypt = "";
//        for(int i = 0; i < alphabet.length(); i++) {
//            if (i < alphabet.length()/4) {
//                encrypt += alphabet.charAt(i) + 13;
//            } else if (i > alphabet.length()/4) {
//                encrypt += alphabet.charAt(i) - 13;
//            }
//         }
        String crypt = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                if (text.charAt(i) > 65 && text.charAt(i) < 79) {
                    crypt += text.charAt(i) + 13;
                } else if (text.charAt(i) > 78 && text.charAt(i) < 92) {
                    crypt += text.charAt(i) - 13;
                }
            }
            if (Character.isLowerCase((text.charAt(i)))) {
                if (text.charAt(i) > 97 && text.charAt(i) < 111) {
                    crypt += text.charAt(i) + 13;
                } else if (text.charAt(i) > 110 && text.charAt(i) < 124) {
                    crypt += text.charAt(i) - 13;
                }
            }
        }
        System.out.println(crypt);
        return crypt;
    }

    public String encrypt(String text) {
        return text;
    }

    public String decrypt(String text) {
        return text;
    }

    public static String rotate(String s, Character c) {

        return "";
    }

}
