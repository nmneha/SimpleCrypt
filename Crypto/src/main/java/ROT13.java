import sun.nio.cs.US_ASCII;

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
        String crypt = encrypt(text);
        return crypt;
    }

    public String encrypt(String text) {
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

    public String decrypt(String text) {

        return text;
    }

    public static String rotate(String s, Character c) {
        int shift = c - 'A';
        String s1 = "";
        char[] sArr = s.toCharArray();
        char[] sArr2 = s.toCharArray();
        int j = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (i < s.length()/2) {
                sArr[i] = sArr2[j + shift];
            } else if (i >= s.length()/2) {
                sArr[i] = sArr2[j - shift];
            }
            j++;
            s1 += sArr[i];
        }
        return s1;
    }

    public Integer getShift() {
        return shift;
    }
}
