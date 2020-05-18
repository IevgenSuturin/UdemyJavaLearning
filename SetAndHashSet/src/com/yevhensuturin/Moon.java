package com.yevhensuturin;

public class Moon extends HeavenlyBody {
    public Moon(String name, double orbitalPeriod) {
        super(name, BodyType.MOON, orbitalPeriod);
    }
}
