package phase2;
// James: This is the driver that will give our outputs

import java.math.BigInteger;
import java.util.Arrays;
import phase2.Common.*;
import phase2.Network;

public class Simulator{
    public static void main(String[] args)
    {
        boolean fixedData = true;
        if (fixedData)
        {
            System.out.println("----- Using FIXED Data -----\n");

        }
        else {
            System.out.println("----- Using RANDOM Data -----\n");
            !fixedData;
        }

        User amySender = createSender("Amy", fixedData);
        User bobReceiver = createReceiver("Bob");

        Network internet = new Network();

        init(amySender, bobReceiver);

        String case1 = "Phase 2: Secure Message Communication (CIA)";

        Packet senderPk = senderOperations(amySender, bobReceiver);

        System.out.println("\n\n==> Sender sends packet to Network: \n" + senderPk.toString());

        internet.pkInFromSender(senderPk);
        // internet.pkGetHacked();
        Packet pkToReceiver = internet.pkOutToReceiver();

        BigInteger msg = receiverOperations(bobReceiver, amySender, pkToReceiver);

        System.out.println("\n==> Receiver decrypts msg: " + msg.toString() + "\n\n");
    }

    public static void init(User amyUser, User bobReceiver)
    {
        String case01 = "Phase 2: #0_1 | Initalize Sender";
        System.out.println(Common.caseSeperator("+", case01));
        


        
        // James: Some of this can probably be copied and pasted from our tests ran in Phase 1
    }

    public static User createSender(String name, boolean fixedData) {

        System.out.println("\n--- Step #" + step + ": START - Sender generates\t" + Common.padding);
        Role sendRole = Role.SENDER;
        User send = new User(name, sendRole, fixedData);
        System.out.print("   | "+ send.toString()+ "\n");
        send.toString();
        send.printDetails();
        System.out.println("--- Step #" + step + ": END of this Step \t\t" + Common.padding + "\n");
        return send;
    }

    public static User createReceiver(String name) {

        step = 1;
        System.out.println("\n--- Step #" + step + ": START - Receiver generates\t" + Common.padding);
        Role recvRole = Role.RECEIVER;
        User recv = new User(name, recvRole);
        System.out.print("   | "+ recv.toString()+ "\n");
        recv.toString();
        recv.printDetails();
        System.out.println("--- Step #" + step + ": END of this Step \t\t" + Common.padding + "\n");
        return recv;
    }

    public static void useCryptography(User user) {

        Cryptography crypto = new Cryptography();
        // James: I honestly don't remember what's supposed to go in here

        //TODO
        
    }

    public static BigInteger senderOperations(User sender, User receiver, Packet packet)
    {
        //TODO
        // Get message
        System.out.println("\nStep #01: Get message\n" + Common.indent1 + "Message: " + packet.getCipher());
        // Hash message
        Cryptography crypto = new Cryptography();
        BigInteger hash = crypto.hash(packet.getCipher(), sender.getHashBase());
        System.out.println("\nStep #02: Hash message\n" + Common.indent1 + "Hash: " + hash);
        // Encrypt hashed message to generate the digsig
        System.out.println("\nStep #03: Encrypt hased message to generate the digital signature\n" + Common.indent1);
        hash = crypto.CBC(packet.getCipher(), sender.getHashBase());
        System.out.println("Digital Signature: " + hash);
        // Generate random symmetric key (Ks)
        System.out.println("\nStep #04: Generate random symmetric key\n" + Common.indent1 + "Session Key (Ks): " + sender.getKs());
        // Encrypt Ks with Receiver's public key
        // NEEDS TO BE FIXED
        System.out.println("\nStep #05: Encrypt Ks with Receiver's public key\n" + Common.indent1);
        BigInteger eKs = crypto.CBC(sender.getKs(), receiver.getPubKey());
        System.out.println("Encrypted Ks: " + eKs);
        // Encrypt the message with Ks
        System.out.println("\nStep #06: Encrypt the message with Ks\n" + Common.indent1);
        packet.setCipher(crypto.shift(sender.getMsg(), sender.getKs()));
        System.out.println("Encrypted message: " + packet.getCipher());
        
        // Encrypt the digsig from step 3
        System.out.println("\nStep #07: Encrypt the digital signature from Step #03\n" + Common.indent1);
        hash = crypto.shift(hash, sender.getKs());
        System.out.println("Encrypted digital signature: " + hash);

        // make a packet composed of Encrypted Ks + Encrypted message + Encrypted digsig
        System.out.println("\nStep #08: Make a packet containing outputs from Steps 04, 06 and 07\n" + Common.indent1);
        packet.setEncryptedKs(eKs);
        // Ciphertext is already in packet
        packet.setKsDigSig(hash);
        System.out.println("\n" + packet.toString());
        
    }

    public static BigInteger receiverOperations(User sender, User receiver, Packet packet)
    {
        //TODO
        // Receive packet from the Network
        // Split the three fields of the packet
        // Decrypt Ks with its private key
        // Decrypt message with the session key
    }
}