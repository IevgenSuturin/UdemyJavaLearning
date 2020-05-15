package com.yevhensuturin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetAndHashSetMain {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", BodyType.PLANET, 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        temp = new HeavenlyBody("Venus", BodyType.PLANET, 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        temp = new HeavenlyBody("Earth", BodyType.PLANET, 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", BodyType.MOON, 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Mars", BodyType.PLANET, 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", BodyType.MOON, 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new HeavenlyBody("Phobos", BodyType.MOON,0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new HeavenlyBody("Jupiter", BodyType.PLANET, 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", BodyType.MOON, 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Europa", BodyType.MOON, 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Ganymede", BodyType.MOON, 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", BodyType.MOON, 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new HeavenlyBody("Saturn",  BodyType.MOON,10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", BodyType.PLANET, 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", BodyType.PLANET,165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", BodyType.PLANET, 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of "+body.getName());
        for (HeavenlyBody moon:body.getSatellites() ) {
            System.out.println("\t"+moon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planets:planets) {
            moons.addAll(planets.getSatellites());
        }

        System.out.println("All Moons");
        for (HeavenlyBody moon: moons) {
            System.out.print("\t"+moon.getName());
        }

        HeavenlyBody pluto = new HeavenlyBody("Pluto", BodyType.PLANET,842);
        planets.add(pluto);
        for (HeavenlyBody planet: planets) {
            System.out.println(planet.getName() + ": "+ planet.getOrbitalPeriod());
        }
    }
}
