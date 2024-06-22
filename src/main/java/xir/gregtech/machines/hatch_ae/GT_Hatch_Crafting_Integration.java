package xir.gregtech.machines.hatch_ae;

import gregtech.api.interfaces.ITexture;
import gregtech.common.tileentities.machines.GT_MetaTileEntity_Hatch_CraftingInput_ME;

public class GT_Hatch_Crafting_Integration extends GT_MetaTileEntity_Hatch_CraftingInput_ME {
    public GT_Hatch_Crafting_Integration(int aID, String aName, String aNameRegional, boolean supportFluids) {
        super(aID, aName, aNameRegional, supportFluids);
    }

    public GT_Hatch_Crafting_Integration(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures, boolean supportFluids) {
        super(aName, aTier, aDescription, aTextures, supportFluids);
    }
}
