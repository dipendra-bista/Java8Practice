package com.punojsoft.java8practice;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 *
 */
public class SecureRamdomExample {
    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException {
        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");

        //Get 128 random bytes
        byte[] randomBytes = new byte[128];
        secureRandomGenerator.nextBytes(randomBytes);

        //get random inteeger
        int r = secureRandomGenerator.nextInt();
        //Get random integer in range
        int randInRange = secureRandomGenerator.nextInt(999999);

        /**
         * Secure Random Best Practices
         *i.If performance is a premier consideration, then use SHA1PRNG,
         *  which seeds from /dev/urandom. SHA1PRNG can be 17 times faster
         *  than NativePRNG,but seeding options are fixed.
         *
         * ii.Dont accept default;specify the PRNG and the provider you want to use
         *
         *
         **/
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");

        /**
         * iii.mProvide more oppurtunities increase entropy
         *
         */
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        sr.setSeed(SecureRandom.getSeed(200));
        /**
         *
         */

    }
}
