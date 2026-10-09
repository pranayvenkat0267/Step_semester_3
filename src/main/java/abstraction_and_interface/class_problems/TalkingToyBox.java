package abstraction_and_interface.class_problems;



abstract class Toy {
    private static int count = 1000;
    private final String toyId;
    protected String name;

    Toy(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
        toyId = "TOY-" + (++count);
    }

    public String getToyId() {
        return toyId;
    }

    public abstract String makeSound();
}

class ToyCar extends Toy {
    ToyCar(String name) {
        super(name);
    }

    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    ToyRobot(String name) {
        super(name);
    }

    public String makeSound() {
        return name + ": Beep boop!";
    }
}

public class TalkingToyBox {
    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        ToyRobot r = new ToyRobot("Bolt");

        System.out.println(c.makeSound());
        System.out.println(r.makeSound());
        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}