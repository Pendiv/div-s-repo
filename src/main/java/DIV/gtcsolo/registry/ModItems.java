package DIV.gtcsolo.registry;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import DIV.gtcsolo.Gtcsolo;

public final class ModItems {
    private ModItems() {}

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Gtcsolo.MODID);

    public static final RegistryObject<Item> LIQUID_VOID_BUCKET = ITEMS.register(
            "liquid_void_bucket",
            () -> new BucketItem(
                    ModFluids.LIQUID_VOID,
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            )
    );
    public static final RegistryObject<Item> CHAOSVOID_INGOT = ITEMS.register(
            "chaosvoid_ingot",
            () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
