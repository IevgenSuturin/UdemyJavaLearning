package com.yevhensuturin;

import java.util.HashSet;
import java.util.Set;

enum BodyType{
    PLANET, MOON, STAR
}

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyType bodyType;

    public HeavenlyBody(String name, BodyType bodyType, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = bodyType;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        if(this.bodyType == BodyType.PLANET && moon.bodyType != BodyType.MOON){
            return false;
        }
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    @Override
    public final boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            if (this.name.equals(theObject.getName())){
                return this.bodyType == theObject.getBodyType();
            }
        }

        return false;
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + this.bodyType.hashCode() + 57;
    }

    @Override
    public String toString() {
        return name + ": " + bodyType + ", "+ orbitalPeriod;
    }
}
