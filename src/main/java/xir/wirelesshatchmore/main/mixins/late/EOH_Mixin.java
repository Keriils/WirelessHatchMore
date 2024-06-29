package xir.wirelesshatchmore.main.mixins.late;

import static gregtech.common.tileentities.machines.multi.GT_MetaTileEntity_FusionComputer.STRUCTURE_PIECE_MAIN;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.github.technus.tectech.thing.metaTileEntity.multi.GT_MetaTileEntity_EM_EyeOfHarmony;
import com.github.technus.tectech.thing.metaTileEntity.multi.base.GT_MetaTileEntity_MultiblockBase_EM;

import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Input;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_MultiBlockBase;
import gregtech.api.util.GT_Utility;
import gregtech.common.tileentities.machines.GT_MetaTileEntity_Hatch_InputBus_ME;
import gregtech.common.tileentities.machines.GT_MetaTileEntity_Hatch_OutputBus_ME;
import gregtech.common.tileentities.machines.GT_MetaTileEntity_Hatch_Output_ME;
import xir.gregtech.machines.hatch_ae.EOH_Hatch;

@Mixin(value = GT_MetaTileEntity_EM_EyeOfHarmony.class, remap = false)
public class EOH_Mixin {

    @Shadow
    @Final
    private Map<Fluid, Long> validFluidMap;

    @Shadow
    private int spacetimeCompressionFieldMetadata;
    @Shadow
    private int timeAccelerationFieldMetadata;
    @Shadow
    private int stabilisationFieldMetadata;

    @Redirect(
        method = "onPreTick",
        at = @At(
            value = "INVOKE",
            target = "Lcom/github/technus/tectech/thing/metaTileEntity/multi/GT_MetaTileEntity_EM_EyeOfHarmony;drainFluidFromHatchesAndStoreInternally()V"))
    private void drainFluid(GT_MetaTileEntity_EM_EyeOfHarmony instance) {
        boolean lok = false;
        for (GT_MetaTileEntity_Hatch_Input tHatch : GT_Utility.filterValidMTEs(instance.mInputHatches)) {
            if (tHatch instanceof EOH_Hatch) {
                lok = true;
                break;
            }
        }
        processFluids(instance, lok);
    }

    private void processFluids(GT_MetaTileEntity_EM_EyeOfHarmony instance, boolean lok) {
        if (lok && instance.isAllowedToWork()) {
            GT_MetaTileEntity_Hatch_Input tHatch = instance.mInputHatches.get(0);
            if (tHatch instanceof EOH_Hatch eohHatch) {
                long[] eohFluidAmount = eohHatch.getEOHFluidAmount();
                for (int i = 0; i < EOH_Hatch.EOH_HATCH_SLOTS; i++) {
                    validFluidMap.merge(EOH_Hatch.eohMatchFluid[i].getFluid(), eohFluidAmount[i], Long::sum);
                    eohFluidAmount[i] = 0;
                }
                eohHatch.invokeArgsFirst();// DEBUG
            }
        } else {
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

    /**
     * @author DauphalXir
     * @reason add EOH_Hatch detection logic
     */
    @Overwrite(remap = false)
    public boolean checkMachine_EM(IGregTechTileEntity iGregTechTileEntity, ItemStack itemStack) {

        spacetimeCompressionFieldMetadata = -1;
        timeAccelerationFieldMetadata = -1;
        stabilisationFieldMetadata = -1;

        GT_MetaTileEntity_MultiBlockBase mteMultiBase = (GT_MetaTileEntity_MultiBlockBase) ((Object) this);
        GT_MetaTileEntity_MultiblockBase_EM mteMultiBase_EM = (GT_MetaTileEntity_MultiblockBase_EM) ((Object) this);
        GT_MetaTileEntity_EM_EyeOfHarmony instance = (GT_MetaTileEntity_EM_EyeOfHarmony) ((Object) this);

        // Check structure of multi.
        if (!mteMultiBase_EM.structureCheck_EM(STRUCTURE_PIECE_MAIN, 16, 16, 0)) {
            return false;
        }

        // Make sure there are no Crafting Input Buffers/Buses/Slaves.
        if (!mteMultiBase.mDualInputHatches.isEmpty()) {
            return false;
        }

        // Check if there is 1 output bus, and it is a ME output bus.
        {
            if (mteMultiBase.mOutputBusses.size() != 1) {
                return false;
            }

            if (!(mteMultiBase.mOutputBusses.get(0) instanceof GT_MetaTileEntity_Hatch_OutputBus_ME)) {
                return false;
            }
        }

        // Check if there is 1 output hatch, and they are ME output hatches.
        {
            if (mteMultiBase.mOutputHatches.size() != 1) {
                return false;
            }

            if (!(mteMultiBase.mOutputHatches.get(0) instanceof GT_MetaTileEntity_Hatch_Output_ME)) {
                return false;
            }
        }

        // Check there is 1 input bus, and it is not a stocking input bus.
        {
            if (mteMultiBase.mInputBusses.size() != 1) {
                return false;
            }

            if (mteMultiBase.mInputBusses.get(0) instanceof GT_MetaTileEntity_Hatch_InputBus_ME) {
                return false;
            }
        }

        // Make sure there are no energy hatches.
        {
            if (!mteMultiBase.mEnergyHatches.isEmpty()) {
                return false;
            }

            if (!mteMultiBase.getExoticEnergyHatches()
                .isEmpty()) {
                return false;
            }
        }
        if (!tHatchDetectLogic(instance)) {
            return false;
        }

        mteMultiBase.mHardHammer = true;
        mteMultiBase.mSoftHammer = true;
        mteMultiBase.mScrewdriver = true;
        mteMultiBase.mCrowbar = true;
        mteMultiBase.mSolderingTool = true;
        mteMultiBase.mWrench = true;

        return true;
    }

    private boolean tHatchDetectLogic(GT_MetaTileEntity_EM_EyeOfHarmony instance) {
        ArrayList<GT_MetaTileEntity_Hatch_Input> tHatch = instance.mInputHatches;
        if (tHatch.size() == 1 && (tHatch.get(0) instanceof EOH_Hatch)) {
            return true;
        } else if (tHatch.size() == 2 && !(tHatch.get(0) instanceof EOH_Hatch || tHatch.get(1) instanceof EOH_Hatch)) {
            return true;
        }
        return false;
    }
}
