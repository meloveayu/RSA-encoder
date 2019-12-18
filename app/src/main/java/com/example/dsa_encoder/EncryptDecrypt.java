package com.example.dsa_encoder;

import java.math.BigInteger;
import java.util.Scanner;

public class EncryptDecrypt {
    private RSA rsa = new RSA();
    public Scanner in = new Scanner(System.in);
    //加密函数
    public BigInteger encrypt(BigInteger m){
        BigInteger c = rsa.encryptByPublic(m);
        return c;
    }
    //解密函数
    public BigInteger decrypt(BigInteger c){
        BigInteger m = rsa.decryptByPrivate(c);
        return m;
    }
    //设置密钥的长度
    public void reset(int len){
        rsa.init(len>>1);
    }
    public BigInteger getPrime(){
        return rsa.getN();
    }
    public BigInteger getPrivateKey(){
        return rsa.getPrivateKey();
    }
    public BigInteger getPublicKey(){
        return rsa.getPublicKey();
    }
    public BigInteger getRandomOne(){
        return rsa.getP();
    }
    public BigInteger getRandomTwo(){
        return rsa.getQ();
    }
}
