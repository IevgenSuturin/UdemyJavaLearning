package com.yevhensuturin;

public class DwarfPlanet extends HeavenlyBody {
    public DwarfPlanet(String name, double orbitalPeriod) {
        super(name, BodyType.DWARF_PLANET, orbitalPeriod);
    }
}
