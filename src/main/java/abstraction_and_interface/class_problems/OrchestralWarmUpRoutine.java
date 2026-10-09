package abstraction_and_interface.class_problems;



abstract class Instrument {
    public String play() {
        return "";
    }
}

class StringInstrument extends Instrument {
    public String play() {
        super.play();
        return "Strumming the strings";
    }
}

class Violin extends StringInstrument {
    public String play() {
        return super.play() + ", with a bow drawn across four strings";
    }
}

public class OrchestralWarmUpRoutine {
    public static void main(String[] args) {
        StringInstrument s = new StringInstrument();
        Violin v = new Violin();

        System.out.println(s.play());
        System.out.println(v.play());
    }
}