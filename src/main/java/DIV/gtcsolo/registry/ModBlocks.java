package DIV.gtcsolo.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import DIV.gtcsolo.Gtcsolo;

public final class ModBlocks {
    private ModBlocks() {}

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Gtcsolo.MODID);

    public static final RegistryObject<LiquidBlock> LIQUID_VOID_BLOCK = BLOCKS.register(
            "liquid_void",
            () -> new LiquidBlock(
                    ModFluids.LIQUID_VOID,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_PURPLE)
                            .noCollission()
                            .strength(100.0f)
                            .noLootTable()
            )
    );

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
