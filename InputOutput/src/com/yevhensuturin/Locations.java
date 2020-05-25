package com.yevhensuturin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {

        try (FileWriter localFile = new FileWriter("locations.txt");
             FileWriter dirFile = new FileWriter("directions.txt") ){
            for(Location location: locations.values()){
                localFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction: location.getExits().keySet()){
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }

//        FileWriter localFile = null;
//        try {
//            localFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                localFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//            }
//        } finally {
//            System.out.println("In finally block");
//            if(localFile != null) {
//                 System.out.println("Attempting to close localFile");
//                 localFile.close();
//            }
//        }
    }

    static {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNext()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ": " + description);
                Map<String, Integer> tempExits = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExits));
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (scanner != null){
                scanner.close();
            }
        }

        //Now read the exits
        try{
            scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
            scanner.useDelimiter(",");
            while (scanner.hasNext()){
//                int loc = scanner.nextInt();
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt(dest);

                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(scanner!=null){
                scanner.close();
            }
        }

//        Map<String, Integer> tmpExit = new HashMap<>();
//        locations.put(0, new Location(0,"You are sitting in front of a computer learning Java", null));
//
//        tmpExit = new HashMap<>();
//        tmpExit.put("W", 2);
//        tmpExit.put("E", 3);
//        tmpExit.put("S", 4);
//        tmpExit.put("N", 5);
//        locations.put(1, new Location(1,"You are standing at the end of a road before small brick building", tmpExit));
//
//        tmpExit = new HashMap<>();
//        tmpExit.put("N", 5);
//        locations.put(2, new Location(2,"You are at the top of the hill", tmpExit));
//
//        tmpExit = new HashMap<>();
//        tmpExit.put("W", 1);
//        locations.put(3, new Location(3,"You are inside a building, a well house for a small spring", tmpExit));
//
//        tmpExit = new HashMap<>();
//        tmpExit.put("N", 1);
//        tmpExit.put("W", 2);
//        locations.put(4, new Location(4,"You are in the valley beside a stream", tmpExit));
//
//        tmpExit = new HashMap<>();
//        tmpExit.put("S", 1);
//        tmpExit.put("W", 2);
//        locations.put(5, new Location(5,"You are in the forest", tmpExit));
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
