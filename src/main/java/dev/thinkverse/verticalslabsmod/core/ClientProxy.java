package dev.thinkverse.verticalslabsmod.core;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {
    protected static Minecraft MC = Minecraft.getInstance();

    @Override
    public void init() { }

    public World getClientWorld() { return MC.world; }
}
