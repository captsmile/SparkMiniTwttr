package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GravatarUtil {
    private static String hex(byte[] array){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            stringBuffer.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return stringBuffer.toString();

    }

    private static String md5Hex(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return hex(md.digest(message.getBytes("CP1252")));
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

    public static String gravatarURL(String email, String defaultImage, int size) {
        return String.format(
                "http://www.gravatar.com/avatar/%s?d=%s&s=%d",
                md5Hex(email),
                defaultImage,
                size
        );
    }
}
