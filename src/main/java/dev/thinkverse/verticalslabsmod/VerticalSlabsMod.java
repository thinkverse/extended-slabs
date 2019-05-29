package dev.thinkverse.verticalslabsmod;

import dev.thinkverse.verticalslabsmod.util.CreativeTab;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.Random;

@Mod(VerticalSlabsMod.MODID)
public class VerticalSlabsMod
{
    public static final String MODID = "verticalslabsmod";
    public static final String VERSION = "0.1.1";

    public static VerticalSlabsMod INSTANCE;
    public static Proxy PROXY;

    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final ItemGroup GROUP = new CreativeTab();
    public static final Random RANDOM = new Random();

    public VerticalSlabsMod() {
        INSTANCE = this;
        PROXY = DistExecutor.runForDist(() -> () -> new Proxy.Client(), () -> () -> new Proxy.Server());
    }

    /**
     * Get the version of the mod. In a development environment, the version will always be "NONE".
     *
     * @return The version number, or NONE
     */
    public static String getVersion(boolean correctInDev) {
        Optional<? extends ModContainer> o = ModList.get().getModContainerById(MODID);
        if (o.isPresent()) {
            String str = o.get().getModInfo().getVersion().toString();
            if (correctInDev && "NONE".equals(str))
                return VERSION;
            return str;
        }
        return "0.0.0";
    }

    /**
     * Determines if the mod is a dev build. Sometimes it is useful to register objects or event
     * handlers for debugging purposes, but you may not want these to make it into release builds.
     * <p>
     * This method is a bit naive, as it assumes that if the version is "NONE" we are in a
     * development environment. But it works. If you know a better way, let me know.
     *
     * @return True if this is a development environment, false otherwise.
     */
    public static boolean isDevBuild() {
        return "NONE".equals(getVersion(false));
    }

    /**
     * Convenience method for creating {@link ResourceLocation}s. These are needed frequently, and
     * the namespace will typically be your mod ID. This creates a {@link ResourceLocation} with the
     * mod ID as the namespace and the given path. Note that this can throw an exception if the path
     * is invalid.
     *
     * @param path The path of the resource
     * @return A ResourceLocation equivalent to {@code "modid:path"}
     */
    public static ResourceLocation getId(String path) {
        return new ResourceLocation(MODID, path);
    }
}
