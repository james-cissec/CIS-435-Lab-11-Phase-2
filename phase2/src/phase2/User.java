/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package phase1Base;

package phase2;
import java.math.BigInteger;
import java.util.Arrays;
 import static phase2.Common.*;
import phase2.Common.Role;
import java.util.Random;

/**
 * @author #04 | Moom Firdous 
 * @author #10 | Meridith Kcoh 
 * @author #12 | James Mckean
 * @author #15 | Logan Ross
 */
public class User {

    private String name;
    private Role role;

    private BigInteger msg, ks, hashBase;
    BigInteger[] pubKey = new BigInteger[2]; // (n, e)
    BigInteger[] privateKey = new BigInteger[2]; // (n, d)

    User(String name, Role role, boolean fixedData) {

        this.name = name;
        this.role = role;

        
        if (fixedData && role.equals(Role.SENDER) ) {
            this.msg = BigInteger.valueOf(17);
            this.ks = BigInteger.valueOf(5);
            this.hashBase = BigInteger.valueOf(13);
        } else  if (!fixedData && role.equals(Role.SENDER) ){
            // James: If not using fixed data for a , generate random values
            Random r = new Random();
            int randMsg = r.nextInt((100-1) + 1) + 1;
            int randKs = r.nextInt((10-1) + 1) + 1;
            int randHashbase = r.nextInt((50-1) + 1) + 1;
            this.msg = BigInteger.valueOf(randMsg);
            this.ks = BigInteger.valueOf(randKs);
            this.hashBase = BigInteger.valueOf(randHashbase);
        } else if (!fixedData && !role.equals(Role.SENDER))
        {
            this.msg = null;
            this.ks = null;
            this.hashBase = null;
        }

    }

    User(String name, Role role) {
        this.name = name;
        this.role = role;

        // James: If not using fixed data, generate random values
        if (role.equals(Role.SENDER)){
            Random r = new Random();
            int randMsg = r.nextInt((100-1) + 1) + 1;
            int randKs = r.nextInt((10-1) + 1) + 1;
            int randHashbase = r.nextInt((50-1) + 1) + 1;
            this.msg = BigInteger.valueOf(randMsg);
            this.ks = BigInteger.valueOf(randKs);
            this.hashBase = BigInteger.valueOf(randHashbase);
        }
        else
        {
            this.msg = null;
            this.ks = null;
            this.hashBase = null;
        }
        
    }

    User(BigInteger msg, BigInteger ks, BigInteger hashBase) {

        this.msg = msg;
        this.ks = ks;
        this.hashBase = hashBase;

    }

    public void printDetails() {

        System.out.println(indent1 + "Original Msg from Sender (msg): " + getMsg());
        System.out.println(indent1 + "Random Session Key (Ks): "
                + getKs());
        System.out.println(indent1 + "Choose hash function with (hashBase): "
                + getHashBase());

    }

    @Override
    public String toString() {

        if (role.equals(Role.RECEIVER)) {

            return "Receiver {" + "name=" + name + ", msg=" + msg + ", ks=" + ks + ", hashBase=" + hashBase
                    + ", pubKey=" + Arrays.toString(pubKey) + ", privateKey=" + Arrays.toString(privateKey) + '}';
        }

        return "Sender {" + "name=" + name + ", msg=" + msg + ", ks=" + ks + ", hashBase=" + hashBase
                + ", pubKey=" + Arrays.toString(pubKey) + ", privateKey=" + Arrays.toString(privateKey) + '}';
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger[] getPubKey() {
        return pubKey;
    }

    public void setPubKey(BigInteger[] pubKey) {
        this.pubKey = pubKey;
    }

    public BigInteger[] getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(BigInteger[] privateKey) {
        this.privateKey = privateKey;
    }

    public BigInteger getMsg() {
        return msg;
    }

    public void setMsg(BigInteger msg) {
        this.msg = msg;
    }

    public BigInteger getKs() {
        return ks;
    }

    public void setKs(BigInteger ks) {
        this.ks = ks;
    }

    public BigInteger getHashBase() {
        return hashBase;
    }

    public void setHashBase(BigInteger hashBase) {
        this.hashBase = hashBase;
    }

}
