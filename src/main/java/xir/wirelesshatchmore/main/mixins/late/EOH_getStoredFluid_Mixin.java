package xir.wirelesshatchmore.main.mixins.late;

import java.util.ArrayList;

import net.minecraftforge.fluids.FluidStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Input;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_MultiBlockBase;
import gregtech.api.util.GT_Utility;
import xir.gregtech.machines.hatch_ae.EOH_Hatch;

@Mixin(value = GT_MetaTileEntity_MultiBlockBase.class, remap = false)
public abstract class EOH_getStoredFluid_Mixin {

    @Shadow
    public ArrayList<GT_MetaTileEntity_Hatch_Input> mInputHatches = new ArrayList<>();

    @Inject(method = "getStoredFluids", at = @At(value = "TAIL"), cancellable = true)
    public void addEOHStoredFluids(CallbackInfoReturnable<ArrayList<FluidStack>> cir) {
        ArrayList<FluidStack> rList = cir.getReturnValue();

        for (GT_MetaTileEntity_Hatch_Input tHatch : GT_Utility.filterValidMTEs(mInputHatches)) {
            if (tHatch instanceof EOH_Hatch eohHatch) {
                rList.addAll(eohHatch.getStoredFluids());
                eohHatch.invokeArgsFirst();
            }
        }
    }
}
