package phase1Base;

import java.math.BigInteger;
import static phase1Base.Common.*;

/**
 * @author #04 | Moom Firdous 
 * @author #10 | Meridith Kcoh 
 * @author #12 | James Mckean
 * @author #15 | Logan Ross
 */
public class Cryptography {

    private RSA rsa;

    Cryptography() {

        System.out.println(indent2 + "Run Cryptography --------");
    
        rsa = new RSA ();        
        System.out.println(indent2 + rsa.toString());
    
    }

   
    // Use the mapping provided in our ICE, and you can modify the header of this method
    static public BigInteger CBC(BigInteger msg, BigInteger hashBase) {   
        //TODO
        return BigInteger.ZERO;
    }

    static public BigInteger hash(BigInteger msg, BigInteger hashBase) {
        BigInteger msgCopy = msg;
        BigInteger hashValue = msgCopy.mod(hashBase);
        return hashValue;
    }

    static public BigInteger shift(BigInteger msg, BigInteger ks) {
        return msg.add(ks);
    }

    //(n, e)
    public void getPublicKey(BigInteger[] pubKey) {
       
        pubKey[0] = rsa.getN();
        pubKey[1] = rsa.getE();
     
    }

    // (n, d)
    public void getPrivateKey(BigInteger[] privateKey) {
       
       privateKey[0]= rsa.getN();
       privateKey[1]= rsa.getD();
       
    }

}
