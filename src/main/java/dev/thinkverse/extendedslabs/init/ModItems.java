package dev.thinkverse.extendedslabs.init;

import dev.thinkverse.extendedslabs.core.ExtendedSlabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = ExtendedSlabs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    static final Map<String, ItemBlock> BLOCKS_TO_REGISTER = new LinkedHashMap<>();


    @SubscribeEvent
    public static void RegisterModItems(RegistryEvent.Register<Item> event) {
        if (!event.getName().equals(ForgeRegistries.ITEMS.getRegistryName())) return;

        BLOCKS_TO_REGISTER.forEach(ModItems::register);
    }

    /**
     * Register the item. Also sets the registry name.
     *
     * @param name The path of the item ID
     * @param item The item
     * @param <T>  The item class
     * @return The item
     */
    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = ExtendedSlabs.location(name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }

}