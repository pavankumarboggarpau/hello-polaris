// https://documentation.blackduck.com/bundle/coverity-docs/page/checker-ref/checkers/FGH/hardcoded_credentials.html
// https://documentation.blackduck.com/bundle/coverity-docs/page/checker-ref/checkers/VWXYZ/weak_password_hash.html

import java.io.*;
import java.sql.*;
import javax.crypto.spec.SecretKeySpec;

public class HardcodedCredentials {
    public static Connection getCon(String url) throws SQLException {
        String password = System.getProperty("db.password");
        if (password == null) {
            throw new SQLException("Database password not provided");
        }
        return DriverManager.getConnection(url,
            /*username*/ "leroy",
            /*password*/ password);
    }
    public static SecretKeySpec getKeySpec() throws UnsupportedEncodingException {
        String secret = "It's a secret to everybody.";
        SecretKeySpec keyspec = new SecretKeySpec(secret.getBytes("UTF-8"), "MD5");
        return(keyspec);
    }
}
