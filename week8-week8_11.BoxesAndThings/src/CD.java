public class CD implements ToBeStored {

    private String artist, title;
    private int publishYear;

    public CD(String artist, String title, int publishYear) {
        this.artist = artist;
        this. title = title;
        this.publishYear = publishYear;
    }

    @Override
    public double weight() {
        return 0.1;
    }

    @Override
    public String toString() {
        return artist + ": " + title + " (" + publishYear + ")";
    }
}
