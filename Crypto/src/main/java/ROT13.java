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
        String crypt = "";
        char[] textArr = text.toCharArray();
        char[] textArr2 = text.toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            if (Character.isUpperCase(textArr[i])) {
                if (textArr[i] > 65 && textArr[i] < 78) {
                    textArr[i] = (char) (textArr2[i] + 13);
                } else if (textArr[i] >= 79 && textArr[i] < 92) {
                    textArr[i] = (char) (textArr2[i] - 13);
                }
            }
            if (Character.isLowerCase((textArr[i]))) {
                if (textArr[i] > 97 && textArr[i] < 110) {
                    textArr[i] = (char) (textArr2[i] + 13);
                } else if (text.charAt(i) >= 111 && text.charAt(i) < 124) {
                    textArr[i] = (char) (textArr2[i] - 13);
                }
            }
            crypt += textArr[i];
        }
        return crypt;
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        String crypt = "";
        char[] textArr = text.toCharArray();
        char[] textArr2 = text.toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            if (Character.isUpperCase(textArr[i])) {
                if (textArr[i] > 65 && textArr[i] <= 78) {
                    textArr[i] = (char) (textArr2[i] + 13);
                } else if (textArr[i] >= 79 && textArr[i] < 92) {
                    textArr[i] = (char) (textArr2[i] - 13);
                }
            }
            if (Character.isLowerCase((textArr[i]))) {
                if (textArr[i] > 97 && textArr[i] <= 110) {
                    textArr[i] = (char) (textArr2[i] + 13);
                } else if (text.charAt(i) >= 111 && text.charAt(i) < 124) {
                    textArr[i] = (char) (textArr2[i] - 13);
                }
            }
            crypt += textArr[i];
        }
        return crypt;
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
