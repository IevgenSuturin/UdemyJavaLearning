package com.yevhensuturin;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        return this.name.equals(((HeavenlyBody) obj).getName());
    }
}
