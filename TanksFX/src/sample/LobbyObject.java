package sample;

import java.util.ArrayList;


public class LobbyObject {
    private ArrayList<Lobby> listOfLobbies = new ArrayList<>();

    public ArrayList<Lobby> getListOfLobby() {
        return listOfLobbies;
    }

    public void addLobby(Lobby lobby) {
        listOfLobbies.add(lobby);
    }

    public void removeLobby(Lobby lobby) {
        listOfLobbies.remove(lobby);
    }

    public int size() {
        return listOfLobbies.size();
    }

    public Lobby getLobby(int i) {
        return listOfLobbies.get(i);
    }
}
