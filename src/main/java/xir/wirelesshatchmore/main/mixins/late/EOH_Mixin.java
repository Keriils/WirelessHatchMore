package xir.wirelesshatchmore.main.mixins.late;

import static gregtech.common.tileentities.machines.multi.GT_MetaTileEntity_FusionComputer.STRUCTURE_PIECE_MAIN;
import static xir.gregtech.machines.hatch_ae.EOH_Hatch.EOH_FLUID_TYPE_AMOUNT;
import static xir.gregtech.machines.hatch_ae.EOH_Hatch.EOH_MATCH_FLUID;

import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.github.technus.tectech.thing.metaTileEntity.multi.GT_MetaTileEntity_EM_EyeOfHarmony;

import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Input;
import gregtech.common.tileentities.machines.GT_MetaTileEntity_Hatch_InputBus_ME;
import gregtech.common.tileentities.machines.GT_MetaTileEntity_Hatch_OutputBus_ME;
import gregtech.common.tileentities.machines.GT_MetaTileEntity_Hatch_Output_ME;
import xir.gregtech.machines.hatch_ae.EOH_Hatch;

@Mixin(value = GT_MetaTileEntity_EM_EyeOfHarmony.class, remap = false)
public class EOH_Mixin {

    GT_MetaTileEntity_EM_EyeOfHarmony emEyeOfHarmony = (GT_MetaTileEntity_EM_EyeOfHarmony) ((Object) this);
    @Shadow
    @Final
    private Map<Fluid, Long> validFluidMap;
    @Shadow
    private boolean recipeRunning;
    @Shadow
    private int spacetimeCompressionFieldMetadata;
    @Shadow
    private int timeAccelerationFieldMetadata;
    @Shadow
    private int stabilisationFieldMetadata;

    @Inject(method = "drainFluidFromHatchesAndStoreInternally", at = @At("HEAD"))
    private void drain(CallbackInfo callbackInfo) {
        if (emEyeOfHarmony.getControllerSlot() != null && !emEyeOfHarmony.mInputHatches.isEmpty()
            && (emEyeOfHarmony.mInputHatches.get(0) instanceof EOH_Hatch eoh_hatch)
            && emEyeOfHarmony.isAllowedToWork()
            && !recipeRunning) {
            if (eoh_hatch.processAeFluid()) {
                fluidAdder(eoh_hatch);
            }
        }
    }

    private void fluidAdder(EOH_Hatch hatch) {
        for (byte i = 0; i < EOH_FLUID_TYPE_AMOUNT; i++) {
            validFluidMap.merge(EOH_MATCH_FLUID[i].getFluid(), hatch.expectedFluidAmount[i], Long::sum);
        }
    }

    /**
     * @author DauphalXir
     * @reason add EOH_Hatch detection logic
     */
    @Overwrite(remap = false)
    public boolean checkMachine_EM(IGregTechTileEntity iGregTechTileEntity, ItemStack itemStack) {

        spacetimeCompressionFieldMetadata = -1;
        timeAccelerationFieldMetadata = -1;
        stabilisationFieldMetadata = -1;

        // Check structure of multi.
        if (!emEyeOfHarmony.structureCheck_EM(STRUCTURE_PIECE_MAIN, 16, 16, 0)) {
            return false;
        }

        // Make sure there are no Crafting Input Buffers/Buses/Slaves.
        if (!emEyeOfHarmony.mDualInputHatches.isEmpty()) {
            return false;
        }

        // Check if there is 1 output bus, and it is a ME output bus.
        {
            if (emEyeOfHarmony.mOutputBusses.size() != 1) {
                return false;
            }

            if (!(emEyeOfHarmony.mOutputBusses.get(0) instanceof GT_MetaTileEntity_Hatch_OutputBus_ME)) {
                return false;
            }
        }

        // Check if there is 1 output hatch, and they are ME output hatches.
        {
            if (emEyeOfHarmony.mOutputHatches.size() != 1) {
                return false;
            }

            if (!(emEyeOfHarmony.mOutputHatches.get(0) instanceof GT_MetaTileEntity_Hatch_Output_ME)) {
                return false;
            }
        }

        // Check there is 1 input bus, and it is not a stocking input bus.
        {
            if (emEyeOfHarmony.mInputBusses.size() != 1) {
                return false;
            }

            if (emEyeOfHarmony.mInputBusses.get(0) instanceof GT_MetaTileEntity_Hatch_InputBus_ME) {
                return false;
            }
        }

        // Make sure there are no energy hatches.
        {
            if (!emEyeOfHarmony.mEnergyHatches.isEmpty()) {
                return false;
            }

            if (!emEyeOfHarmony.getExoticEnergyHatches()
                .isEmpty()) {
                return false;
            }
        }
        if (!tHatchDetectLogic(emEyeOfHarmony)) {
            return false;
        }

        emEyeOfHarmony.mHardHammer = true;
        emEyeOfHarmony.mSoftHammer = true;
        emEyeOfHarmony.mScrewdriver = true;
        emEyeOfHarmony.mCrowbar = true;
        emEyeOfHarmony.mSolderingTool = true;
        emEyeOfHarmony.mWrench = true;

        return true;
    }

    private boolean tHatchDetectLogic(GT_MetaTileEntity_EM_EyeOfHarmony instance) {
        List<GT_MetaTileEntity_Hatch_Input> tHatch = instance.mInputHatches;
        return switch (tHatch.size()) {
            case 1 -> tHatch.get(0) instanceof EOH_Hatch;
            case 2 -> !(tHatch.get(0) instanceof EOH_Hatch || tHatch.get(1) instanceof EOH_Hatch);
            default -> false;
        };
    }
}
