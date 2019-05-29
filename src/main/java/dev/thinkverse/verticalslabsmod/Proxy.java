package dev.thinkverse.verticalslabsmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Proxy {
    Proxy() {
        VerticalSlabsMod.LOGGER.debug("Proxy init");

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::preInit);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imcEnqueue);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imcProcess);

        MinecraftForge.EVENT_BUS.addListener(this::serverAboutToStart);
    }

    /**
     * Called after registry events, so we know blocks, items, etc. are registered
     *
     * @param event The event
     */
    private void preInit(final FMLCommonSetupEvent event) {
    }

    /**
     * Send IMC messages to other mods
     *
     * @param event The event
     */
    private void imcEnqueue(final InterModEnqueueEvent event) {
    }

    /**
     * Receive and process IMC messages from other mods
     *
     * @param event The event
     */
    private void imcProcess(final InterModProcessEvent event) {
    }

    private void serverAboutToStart(FMLServerStartingEvent event) {
    }

    static class Client extends Proxy {
        Client() { FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup); }

        private void clientSetup(final FMLClientSetupEvent event) {
        }
    }

    static class Server extends Proxy {
        Server() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        }

        private void serverSetup(FMLDedicatedServerSetupEvent event) {
        }
    }
}
