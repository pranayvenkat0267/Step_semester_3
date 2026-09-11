package oop_inheritance_polymorphism.assignment_problems;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LibraryMemberJavaBean {

    private String membershipId;
    private String name;
    private boolean premiumMember;

    private String securityAnswer;

    private boolean membershipIdSet = false;

    // Required public no-argument constructor
    public LibraryMemberJavaBean() {
    }

    // JavaBean getter
    public String getMembershipId() {
        return membershipId;
    }

    // Write-once setter
    public void setMembershipId(String id) {

        if (!membershipIdSet) {
            membershipId = id;
            membershipIdSet = true;
        }
    }

    // JavaBean getter
    public String getName() {
        return name;
    }

    // JavaBean setter
    public void setName(String name) {
        this.name = name;
    }

    // Boolean JavaBean getter
    public boolean isPremiumMember() {
        return premiumMember;
    }

    // JavaBean setter
    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    // Write-only security answer
    public void setSecurityAnswer(String answer) {

        try {

            MessageDigest digest =
                    MessageDigest.getInstance("SHA-256");

            byte[] hash =
                    digest.digest(
                            answer.getBytes(
                                    StandardCharsets.UTF_8));

            StringBuilder result =
                    new StringBuilder();

            for (byte b : hash) {
                result.append(
                        String.format("%02x", b));
            }

            securityAnswer = result.toString();

        } catch (NoSuchAlgorithmException e) {

            securityAnswer =
                    Integer.toHexString(
                            answer.hashCode());
        }
    }

    public static void main(String[] args) {

        LibraryMemberJavaBean m =
                new LibraryMemberJavaBean();

        m.setMembershipId("LIB-8841");

        m.setName("Priya Nair");

        m.setPremiumMember(true);

        // Second call is ignored
        m.setMembershipId("FAKE-0000");

        System.out.println(
                m.getMembershipId());

        System.out.println(
                m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");

        // No getSecurityAnswer() exists.
    }
}