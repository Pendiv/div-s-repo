package DIV.gtcsolo.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class VoidFluidType extends FluidType {

    // 紫（ARGB）
    private static final int TINT = 0xFF8B5CF6;

    // まずは水テクスチャ流用（後で専用テクスチャに差し替え可）
    private static final ResourceLocation STILL = new ResourceLocation("minecraft", "block/water_still");
    private static final ResourceLocation FLOW = new ResourceLocation("minecraft", "block/water_flow");
    private static final ResourceLocation OVERLAY = new ResourceLocation("minecraft", "block/water_overlay");

    public VoidFluidType(Properties properties) {
        super(properties);
    }

    @Override
    public void initializeClient(@NotNull Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override public ResourceLocation getStillTexture() { return STILL; }
            @Override public ResourceLocation getFlowingTexture() { return FLOW; }
            @Override public ResourceLocation getOverlayTexture() { return OVERLAY; }
            @Override public int getTintColor() { return TINT; }
        });
    }
}
