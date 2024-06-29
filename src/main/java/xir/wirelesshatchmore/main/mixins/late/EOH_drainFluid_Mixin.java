package xir.wirelesshatchmore.main.mixins.late;

import java.util.List;
import java.util.Map;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.github.technus.tectech.thing.metaTileEntity.multi.GT_MetaTileEntity_EM_EyeOfHarmony;

@Mixin(value = GT_MetaTileEntity_EM_EyeOfHarmony.class, remap = false)
public class EOH_drainFluid_Mixin {

    @Shadow
    @Final
    private Map<Fluid, Long> validFluidMap;

    @Redirect(
        method = "onPreTick",
        at = @At(
            value = "INVOKE",
            target = "Lcom/github/technus/tectech/thing/metaTileEntity/multi/GT_MetaTileEntity_EM_EyeOfHarmony;drainFluidFromHatchesAndStoreInternally()V"))
    private void drainFluid(GT_MetaTileEntity_EM_EyeOfHarmony instance) {
        boolean shouldDrain = instance.getBaseMetaTileEntity()
            .isAllowedToWork();
        if (shouldDrain) {
            List<FluidStack> fluidStacks = instance.getStoredFluids();
            for (FluidStack fluidStack : fluidStacks) {
                if (validFluidMap.containsKey(fluidStack.getFluid())) {
                    validFluidMap.merge(fluidStack.getFluid(), (long) fluidStack.amount, Long::sum);
                    fluidStack.amount = 0;
                }
            }
            instance.updateSlots();
        }
    }
}
