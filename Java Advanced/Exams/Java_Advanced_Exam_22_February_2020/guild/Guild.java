package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    public String name;
    public int capacity;
    public List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public int count() {
        return this.roster.size();
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                } else {
                    break;
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                } else {
                    break;
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] player = this.roster.stream().filter(p -> p.getClazz().equals(clazz)).toArray(Player[]::new);
        this.roster = this.roster.stream().filter(p -> !p.getClazz().equals(clazz)).collect(Collectors.toList());
        return player;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:", this.name)).append(System.lineSeparator());
        for (Player player : this.roster) {
            sb.append(player).append(System.lineSeparator());
        }
        return sb.toString();
    }


}
