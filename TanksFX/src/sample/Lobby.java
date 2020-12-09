package sample;

public class Lobby {
    private String name;
    private int currentCount;

    public Lobby(String name, int currentCount) {
        this.name = name;
        this.currentCount = currentCount;
    }

    public String getName() {
        return name;
    }

    public int getCurrentCount() {
        return currentCount;
    }
}
