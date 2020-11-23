package phase1Base;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Set;
import static phase1Base.Common.*;
import static phase1Base.TestingMethods.*;

/**
 * @author #04 | Moom Firdous 
 * @author #10 | Meridith Kcoh 
 * @author #12 | James Mckean
 * @author #15 | Logan Ross
 */
public class TestCase1 {

    public static void main(String[] args) {

        //SENDER Steps:        
        // Hash Message
        // Encrypt that hash value using n and d
        // Combine message and encypted hash value in array
        // Generate session key
        // Encrypt the session key with RECEIVER's public key
        // Encrypt combined message with session key (shift cipher [and/or CBC?])
        // Combine the previous message with the encrypted session key
        // Send to RECEIVER
        
        //RECEIVER Steps:
        // Split the session key and message
        // Decrypt the session key with RECEIVER's private key
        // Decrypt the message with the session key (undo shift cipher [and/or CBC?])
        // Split the message and signature
        // Hash the message
        // Decrypt the signature with SENDER's public key
        // Compare the hashes
        
        // Hash = hash function
        // Symmetric encryption = shift function
        
        String case01 = "CASE #0_1 | Initialize Sender (Fixed Data) ";
        System.out.println(caseSeperator("*", case01));

        // true for using fixed msg, ks, and hash value, other wise random data
        boolean fixedData = true;
        User amySender = createSender("Amy", fixedData);
        getRSAKeys(amySender);
        System.out.println("==> Sender's Status | " + amySender.toString() + "\n");

        String case02 = "CASE #0_2 | Initialize Receiver (Fixed Data) ";

        System.out.println(caseSeperator("*", case02));

        User bobReceiver = createReceiver("Bob");
        getRSAKeys(bobReceiver);

        System.out.println("==> Receiver's Status | " + bobReceiver.toString() + "\n");

        String case1 = "CASE #1: Suppose Sender wants to send a secret message to Receiver using public key cryptography";

        System.out.println(caseSeperator("*", case1));

        String senderCase1 = "Sender Operations";
        System.out.println(caseSeperator("+", senderCase1));

        BigInteger cipher = senderCase1(amySender, bobReceiver);
        System.out.println("==> Sender sends out cipher = | " + cipher + "\n");
        String receiverCase1 = "Receiver Operations";
        System.out.println(caseSeperator("+", receiverCase1));

        BigInteger msg = receiverCase1(bobReceiver, cipher);

        System.out.println("==> Receiver receives and decrypt msg = | " + msg + "\n");

    }


}
