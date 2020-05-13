import java.util.*;

public class AdventureMain {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of computer and learnong Java"));
        locations.put(1, new Location(1, "You are standing at the end of road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of the hill"));
        locations.put(3, new Location(3, "You are inside building, a well house for a smzll spring"));
        locations.put(4, new Location(4, "You are in the valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("QUIT", "S");

        int loc=1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc==0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are");
            for(String exit: exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length()>1) {
                String[] worlds = direction.split(" ");
                for (String world : worlds) {
                    if (vocabulary.containsKey(world)) {
                        direction = vocabulary.get(world);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)){
                loc=exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction!");
            }
        }
    }
}
