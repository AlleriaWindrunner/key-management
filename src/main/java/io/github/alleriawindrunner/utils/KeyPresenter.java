package io.github.alleriawindrunner.utils;

import org.bouncycastle.util.BigIntegers;
import org.web3j.utils.Numeric;

import java.math.BigInteger;

/**
 * KeyPresenter
 *
 * @author eleven
 * @date 2023年02月17日 10:43 PM
 * @see
 * @since 1.0.0
 */

public class KeyPresenter {

    private KeyPresenter() {
    }

    /**
     * Convert key bytes to hex string
     *
     * @param keyBytes can be private key or public key
     * @return String
     */
    public static String asString(byte[] keyBytes) {
        String s = Numeric.toHexString(keyBytes);
        if (s.contains("0x") || s.contains("0X")) return s;
        return "0x" + s;
    }

    /**
     * Convert key bytes to big integer
     *
     * @param keyBytes can be private key or public key
     * @return BigInteger
     */
    public static BigInteger asBigInteger(byte[] keyBytes) {
        return new BigInteger(1, keyBytes);
    }

    /**
     * Return key bytes
     *
     * @param hexKey Hex format key. Can be private key or public key
     * @return byte[]
     */
    public static byte[] asBytes(String hexKey) {
        byte[] bytes = Numeric.hexStringToByteArray(hexKey);
        return bytes;
    }

    /**
     * Return key bytes
     *
     * @param bigIntegerKey BigInteger format key. Can be private key or public key
     * @return byte[]
     */
    public static byte[] asBytes(BigInteger bigIntegerKey, int len) {
        return BigIntegers.asUnsignedByteArray(len, bigIntegerKey);
    }


}
