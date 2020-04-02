package VanzareBilete;

public class Band {
    protected String name;
    protected String genre;

    public Band(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBandName() {
        return "Band: " + this.getName();
    }
}
