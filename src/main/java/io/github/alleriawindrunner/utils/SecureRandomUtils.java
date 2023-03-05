package io.github.alleriawindrunner.utils;


import java.security.SecureRandom;

/**
 * SecureRandomUtils
 *
 * @author eleven
 * @date 2023年02月17日 10:43 PM
 * @see <a href="https://github.com/web3j/web3j/blob/master/crypto/src/main/java/org/web3j/crypto/SecureRandomUtils.java>Secure implementation</a>
 * @since 1.0.0
 */

public class SecureRandomUtils {
    private static final SecureRandom SECURE_RANDOM;

    static {
        if (isAndroidRuntime()) {
            new LinuxSecureRandom();
        }
        SECURE_RANDOM = new SecureRandom();
    }

    public static SecureRandom secureRandom() {
        return SECURE_RANDOM;
    }

    private static int isAndroid = -1;

    static boolean isAndroidRuntime() {
        if (isAndroid == -1) {
            final String runtime = System.getProperty("java.runtime.name");
            isAndroid = (runtime != null && runtime.equals("Android Runtime")) ? 1 : 0;
        }
        return isAndroid == 1;
    }

    private SecureRandomUtils() {
    }
}
