package com.example.dsa_encoder;

import java.math.BigInteger;
import java.util.Random;

public class RSA {
    private BigInteger n;
    private BigInteger publicKey;//公钥
    private BigInteger privateKey;//私钥
    private BigInteger p,q;
    private BigInteger eul;//eul表示n的欧拉数

    public BigInteger getN() {
        return n;
    }

    public BigInteger getPublicKey() {
        return publicKey;
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void init(int len){
        Random random = new Random();
        p = BigInteger.probablePrime(len, random);//生成一个长度为len的随机质数
        q = BigInteger.probablePrime(len, random);
        n = p.multiply(q);//两数相乘
        eul = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));//eul = (p-1)*(q-1)
        //设置解密指数e和d
        createExponent(eul);
    }
    public BigInteger encryptByPublic(BigInteger m){
        return m.modPow(publicKey, n);
    }
    public BigInteger decryptByPrivate(BigInteger c){
        return c.modPow(privateKey, n);
    }
    //digital signature
    public BigInteger encryptByPrivate(BigInteger m){
        return decryptByPrivate(m);
    }
    public BigInteger decryptByPublic(BigInteger c){
        return encryptByPublic(c);
    }
    //from an eula number create public and private xx
    private void createExponent(BigInteger eul){
        publicKey = new BigInteger("65537");//publicKey为质数65537，所以一定和eul互质
        privateKey = publicKey.modInverse(eul);//privateKey = (eul + 1)/publicKey,privateKey是publicKey的模反元素
    }
}
