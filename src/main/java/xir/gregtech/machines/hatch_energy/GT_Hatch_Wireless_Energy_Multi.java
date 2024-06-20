package xir.gregtech.machines.hatch_energy;

import static com.github.technus.tectech.util.CommonValues.V;
import static com.gtnewhorizon.gtnhlib.util.AnimatedTooltipHandler.BLUE;
import static com.gtnewhorizon.gtnhlib.util.AnimatedTooltipHandler.BOLD;
import static com.gtnewhorizon.gtnhlib.util.AnimatedTooltipHandler.GRAY;
import static gregtech.api.enums.GT_Values.AuthorColen;
import static net.minecraft.util.StatCollector.translateToLocal;

import net.minecraft.util.EnumChatFormatting;

import com.github.technus.tectech.thing.metaTileEntity.hatch.GT_MetaTileEntity_Hatch_WirelessMulti;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.util.GT_Utility;
import xir.gregtech.enums.AutoValueText;
import xir.wirelesshatchmore.utils.LangTrans;

public class GT_Hatch_Wireless_Energy_Multi extends GT_MetaTileEntity_Hatch_WirelessMulti {

    public final int aAmp;
    public final int aTier;

    public GT_Hatch_Wireless_Energy_Multi(int aID, String aName, String aNameRegional, int aTier, int aAmp) {
        super(aID, aName, aNameRegional, aTier, aAmp);
        this.aAmp = aAmp;
        this.aTier = aTier;
    }

    public GT_Hatch_Wireless_Energy_Multi(String aName, int aTier, int aAmp, String[] aDescription,
        ITexture[][][] aTextures) {
        super(aName, aTier, aAmp, aDescription, aTextures);
        this.aAmp = aAmp;
        this.aTier = aTier;
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_Hatch_Wireless_Energy_Multi(mName, mTier, Amperes, new String[] { "" }, mTextures);
    }

    @Override
    public String[] getDescription() {
        return new String[] { GRAY + LangTrans.trans("wireless_hatch_tooltips_1"),
            GRAY + LangTrans.trans("wireless_hatch_tooltips_2"),
            AuthorColen + GRAY + BOLD + " & " + BLUE + BOLD + "Cloud" + GRAY + BOLD + " & " + AutoValueText.Keriils,
            translateToLocal("wireless_hatch_tooltips_3") + EnumChatFormatting.YELLOW
                + GT_Utility.formatNumbers(aAmp * V[aTier])
                + EnumChatFormatting.RESET
                + " EU/t" };
    }
}
