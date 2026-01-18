package DIV.gtcsolo.registry;

import DIV.gtcsolo.Gtcsolo;
import DIV.gtcsolo.fluid.VoidFluidType;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModFluids {
    private ModFluids() {}

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Gtcsolo.MODID);

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Gtcsolo.MODID);

    public static final RegistryObject<FluidType> LIQUID_VOID_TYPE =
            FLUID_TYPES.register("liquid_void",
                    () -> new VoidFluidType(FluidType.Properties.create()
                            .temperature(273) // 「-0度」= 0℃
                            .density(4000)
                            .viscosity(6000)
                            .canDrown(true)
                            .canSwim(true)
                            .canPushEntity(false)));

    // 先に Fluid の RegistryObject を宣言（ここでは Properties をstaticフィールドで持たない）
    public static final RegistryObject<ForgeFlowingFluid.Source> LIQUID_VOID =
            FLUIDS.register("liquid_void", () -> new ForgeFlowingFluid.Source(voidProperties()));

    public static final RegistryObject<ForgeFlowingFluid.Flowing> FLOWING_LIQUID_VOID =
            FLUIDS.register("flowing_liquid_void", () -> new ForgeFlowingFluid.Flowing(voidProperties()));

    /**
     * ★根本解決ポイント★
     * Propertiesをstaticフィールドで作ると「前方参照」でコンパイルが死ぬ。
     * メソッドで作れば、呼ばれるのは登録処理の後（実行時）なので安全。
     */
    private static ForgeFlowingFluid.Properties voidProperties() {
        return new ForgeFlowingFluid.Properties(
                LIQUID_VOID_TYPE,
                LIQUID_VOID,
                FLOWING_LIQUID_VOID
        )
                .slopeFindDistance(4)
                .levelDecreasePerBlock(1)
                .tickRate(5)
                .explosionResistance(100.0f)
                .block(ModBlocks.LIQUID_VOID_BLOCK)
                .bucket(ModItems.LIQUID_VOID_BUCKET);
    }

    public static void register(IEventBus bus) {
        FLUID_TYPES.register(bus);
        FLUIDS.register(bus);
    }
}
