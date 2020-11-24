package phase2;
// James: This is the driver that will give our outputs

import java.math.BigInteger;
import java.util.Arrays;
import phase2.Common.*;
import phase2.*;

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
        }

        System.out.println("\n--- Step #0: START - getRSAKeys()\t" + Common.padding);

        int subStep = 1;

        System.out.println("--- Step #0 - " + subStep + ": Run RSA " + "------------");

        Cryptography crypto = new Cryptography();

        subStep++;
        System.out.println("\n--- Step #0 - " + subStep + ": Gets RSA keys" + "------------");

        // James: Create BigInt arrays to hold key values, fill it with the one that crypto generates
        // and pass it to the user
        BigInteger[] key1 = new BigInteger[2];
        crypto.getPublicKey(key1);
        user.setPubKey(key1);
        BigInteger[] key2 = new BigInteger[2];
        crypto.getPrivateKey(key2);
        user.setPrivateKey(key2);
        
        
        System.out.println(Common.indent2 + "pubKey: " + Arrays.toString(user.getPubKey()));
        System.out.println(Common.indent2 + "privateKey: " + Arrays.toString(user.getPrivateKey()));

        System.out.println("--- Step #0: END of getRSAKeys() \t" + Common.padding + "\n");
        User amySender = createSender("Amy", fixedData);
        User bobReceiver = createReceiver("Bob");

        Network internet = new Network();

        init(amySender, bobReceiver);

        String case1 = "Phase 2: Secure Message Communication (CIA)";

        Packet senderPk = senderOperations(amySender, bobReceiver);

        System.out.println("\n\n==> Sender sends packet to Network: \n" + senderPk.toString());

        internet.pkInFromSender(senderPk);
        // internet.pkGetHacked();
        Packet.pkToReceiver = internet.pkOutToReceiver();

        BigInteger msg = receiverOperations(bobReceiver, amySender, pkToReceiver);

        System.out.println("\n==> Receiver decrypts msg: " + msg.toString() + "\n\n");
    }

    public static void init(User amyUser, User bobReceiver)
    {
        String case01 = "Phase 2: #0_1 | Initalize Sender";
        System.out.println(caseSeperator("+", case01));

        
        // James: This can probably be copied and pasted from our tests ran in Phase 1
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

        int subStep = 1;

        System.out.println("\n--- Step #" + step + "-" + subStep + ": Run RSA " + "------------");

        //TODO
        
    }
}