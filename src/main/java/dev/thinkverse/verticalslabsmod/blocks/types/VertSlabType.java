package dev.thinkverse.verticalslabsmod.blocks.types;

import net.minecraft.util.IStringSerializable;

public enum VertSlabType implements IStringSerializable {
    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west"),
    DOUBLE("double");

    private final String name;

    private VertSlabType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }
}
