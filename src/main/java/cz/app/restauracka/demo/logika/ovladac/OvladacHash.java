package cz.app.restauracka.demo.logika.ovladac;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Component
public class OvladacHash {

    public String sha512hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            StringBuilder hashtext = new StringBuilder(no.toString(16));

            while (hashtext.length() < 32) {
                hashtext.insert(0, "0");
            }

            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
