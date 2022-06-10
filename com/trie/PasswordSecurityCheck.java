package com.trie;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordSecurityCheck {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String checker = "guoj@#2$";
        String hexValue = "71A65E395AB54A48C74FEFEF8406C05DCB0B3977EC9C81BBBD30B771C767FFB1";
        PasswordSecurityCheck pcCheck = new PasswordSecurityCheck();
        System.out.println(pcCheck.toHex(pcCheck.getEncryptedAnswer(checker)));
        System.out.println(hexValue.equalsIgnoreCase(pcCheck.toHex(pcCheck.getEncryptedAnswer(checker))));
    }

	private byte[] getEncryptedAnswer (String securityAnswer) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(securityAnswer.getBytes(StandardCharsets.UTF_8));
    }

	public static String toHex(byte[] bb) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bb) {
            byte2hex(b, sb);
        }
        return sb.toString();
    }

    public static void byte2hex(byte b, StringBuilder sb) {
        char[] hexChars =
            { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        int high = ((b & 0xf0) >> 4);
        int low = (b & 0x0f);
        sb.append(hexChars[high]);
        sb.append(hexChars[low]);
    }
}
