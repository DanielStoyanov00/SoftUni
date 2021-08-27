package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (this.capacity > this.data.size()){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet : this.data){
            if (pet.getName().equals(name)){
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        return this.data.stream()
                .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public int getCount(){
        if (this.data.isEmpty()){
            return 0;
        }
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : this.data){
            sb.append(String.format("%s %s", pet.getName(),pet.getOwner()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
