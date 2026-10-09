package abstraction_and_interface.class_problems;


abstract class DeliveryNote {
    protected String trackingId;

    DeliveryNote(String trackingId) {
        this.trackingId = trackingId;
    }

    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }
}

class ParcelNote extends DeliveryNote {
    ParcelNote(String trackingId) {
        super(trackingId);
    }

    public String confirmDelivery() {
        return "Parcel " + trackingId + " delivered";
    }
}

class LetterNote extends DeliveryNote {
    LetterNote(String trackingId) {
        super(trackingId);
    }

    public String confirmDelivery() {
        return "Letter " + trackingId + " delivered";
    }
}

public class PackageDropOffLog {
    static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }

    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");
        LetterNote l = new LetterNote("TRK-2");

        System.out.println(p.confirmDelivery());
        System.out.println(p.confirmDelivery("J. Smith"));

        DeliveryNote ref = p;
        logAll(new DeliveryNote[]{ref, l});
    }
}