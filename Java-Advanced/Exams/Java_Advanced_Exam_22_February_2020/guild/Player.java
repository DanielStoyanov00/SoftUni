package guild;

public class Player {
    public String name;
    public String clazz;
    public String rank;
    public String description;

    public Player(String name, String clazz){
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return String.format("Player %s: %s\nRank: %s\nDescription: %s", this.name,this.clazz,this.rank,this.description);
    }
}
