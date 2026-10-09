package abstraction_and_interface.assignment_problems;


abstract class ArtPiece {
    private static int count = 0;
    private final int pieceId;
    String title;

    ArtPiece(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }

        this.title = title;
        pieceId = ++count;
    }

    public int getPieceId() {
        return pieceId;
    }

    public abstract String describe();
}

class Painting extends ArtPiece {
    Painting(String title) {
        super(title);
    }

    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    Sculpture(String title) {
        super(title);
    }

    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

public class GalleryDescriptionCards {
    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        Sculpture s = new Sculpture("The Thinker II");

        System.out.println(p.describe());
        System.out.println(s.describe());

        System.out.println(p.getPieceId());
        System.out.println(s.getPieceId());
    }
}