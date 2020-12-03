package phase2;
import java.math.BigInteger;
// James: This is probably going to be an object that is sent back and forth
//        between the user that can store the message, MAC and whatnot

public class Packet{

    private BigInteger encryptedKs;
    private BigInteger cipher;
    private BigInteger KsDigSig;

    Packet(){
        encryptedKs = BigInteger.ZERO;
        cipher = BigInteger.ZERO;
        KsDigSig = BigInteger.ZERO;
    }

    public BigInteger getEncryptedKs(){
        return encryptedKs;
    }

    public void setEncryptedKs(BigInteger newKs){
        this.encryptedKs = newKs;
    }

    public BigInteger getCipher(){
        return this.cipher;
    }

    public void setCipher(BigInteger newVal){
        this.cipher = newVal;
    }

    public BigInteger getKsDigSig(){
        return this.KsDigSig;
    }

    public void setKsDigSig(BigInteger newDigSig)
    {
        this.KsDigSig = newDigSig;
    }

    @Override
    public String toString(){
        return "\n--> Packet contains  | Cipher: " + this.getCipher() + " | Ks: " + this.getEncryptedKs()
                    + " | DigSig: " + this.getKsDigSig() + " |  <--\n";
    }
}