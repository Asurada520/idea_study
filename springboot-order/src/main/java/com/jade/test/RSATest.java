package com.jade.test;

import com.jade.utils.RSAUtil;
import org.apache.commons.lang.StringUtils;

import javax.crypto.Cipher;

public class RSATest {

    public static void main(String[] args) {

        RSAUtil.generateKey();

        String publicKey = RSAUtil.publicKey;
        String privateKey = RSAUtil.privateKey;

        System.out.println("public key:"+ publicKey);
        System.out.println("private key:"+privateKey);

        String value = "yeLin";

        String encryptByPublicKey = RSAUtil.encryptByPublicKey(value, publicKey, Cipher.ENCRYPT_MODE);
        System.out.println("encryptByPublicKey:" + encryptByPublicKey);

        String encryptByPrivateKey = RSAUtil.encryptByprivateKey(encryptByPublicKey, privateKey, Cipher.DECRYPT_MODE);
        System.out.println("encryptByPrivateKey:" + encryptByPrivateKey);


    }
}
