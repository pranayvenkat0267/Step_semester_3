package Access_Modifiers_and_Encapsulation.class_problems;


public class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // Public no-argument constructor
    public MovieBookingProfile() {
        this.name = "";
        this.confirmed = false;
    }

    // Constructor chaining
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    // JavaBean getter
    public String getName() {
        return name;
    }

    // JavaBean setter
    public void setName(String name) {
        this.name = name;
    }

    // JavaBean getter
    public boolean isConfirmed() {
        return confirmed;
    }

    // JavaBean setter
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // Write-only OTP property
    public void setOtp(String otp) {
        this.otp = otp;
    }

    public static void main(String[] args) {

        MovieBookingProfile p =
                new MovieBookingProfile("Rahul Dev");

        System.out.println(p.getName());

        p.setConfirmed(true);

        System.out.println(p.isConfirmed());

        p.setOtp("4471");

        // No getOtp() method exists.
    }
}