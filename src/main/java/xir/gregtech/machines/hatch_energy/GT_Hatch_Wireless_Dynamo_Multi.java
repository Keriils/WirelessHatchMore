package xir.gregtech.machines.hatch_energy;

import static com.github.technus.tectech.thing.metaTileEntity.Textures.OVERLAYS_ENERGY_IN_WIRELESS_LASER;
import static com.github.technus.tectech.thing.metaTileEntity.Textures.OVERLAYS_ENERGY_IN_WIRELESS_MULTI_16A;
import static com.github.technus.tectech.thing.metaTileEntity.Textures.OVERLAYS_ENERGY_IN_WIRELESS_MULTI_4A;
import static com.github.technus.tectech.thing.metaTileEntity.Textures.OVERLAYS_ENERGY_IN_WIRELESS_MULTI_64A;
import static com.gtnewhorizon.gtnhlib.util.AnimatedTooltipHandler.BLUE;
import static com.gtnewhorizon.gtnhlib.util.AnimatedTooltipHandler.BOLD;
import static com.gtnewhorizon.gtnhlib.util.AnimatedTooltipHandler.GRAY;
import static gregtech.api.enums.GT_Values.AuthorColen;
import static gregtech.api.enums.GT_Values.V;
import static gregtech.common.misc.WirelessNetworkManager.addEUToGlobalEnergyMap;
import static gregtech.common.misc.WirelessNetworkManager.strongCheckOrAddUser;

import java.util.UUID;

import net.minecraft.util.EnumChatFormatting;

import com.github.technus.tectech.thing.metaTileEntity.hatch.GT_MetaTileEntity_Hatch_DynamoMulti;
import com.github.technus.tectech.util.CommonValues;
import com.github.technus.tectech.util.TT_Utility;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.interfaces.tileentity.IWirelessEnergyHatchInformation;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.util.GT_Utility;
import xir.gregtech.enums.AutoValueText;
import xir.wirelesshatchmore.utils.LangTrans;

public class GT_Hatch_Wireless_Dynamo_Multi extends GT_MetaTileEntity_Hatch_DynamoMulti
    implements IWirelessEnergyHatchInformation {

    private UUID owner_uuid;
    private ITexture[] TEXTURE_OVERLAY;

    public GT_Hatch_Wireless_Dynamo_Multi(int aID, String aName, String aNameRegional, int aTier, int aAmp) {
        super(
            aID,
            aName,
            aNameRegional,
            aTier,
            0,
            new String[] { GRAY + LangTrans.trans("wireless_hatch_tooltips_1"),
                GRAY + LangTrans.trans("wireless_hatch_tooltips_2"),
                AuthorColen + GRAY + BOLD + " & " + BLUE + BOLD + "Cloud" + GRAY + BOLD + " & " + AutoValueText.Keriils,
                LangTrans.trans("wireless_hatch_tooltips_3") + EnumChatFormatting.YELLOW
                    + GT_Utility.formatNumbers(aAmp * CommonValues.V[aTier])
                    + EnumChatFormatting.RESET
                    + " EU/t",
                LangTrans.trans("wireless_hatch_tooltips_4") + EnumChatFormatting.GREEN
                    + GT_Utility.formatNumbers(CommonValues.V[aTier])
                    + " ("
                    + GT_Utility.getColoredTierNameFromTier((byte) aTier)
                    + EnumChatFormatting.GREEN
                    + ")"
                    + EnumChatFormatting.GRAY },
            aAmp);
        TT_Utility.setTier(aTier, this);
    }

    public GT_Hatch_Wireless_Dynamo_Multi(String aName, int aTier, int aAmp, String[] aDescription,
        ITexture[][][] aTextures) {
        super(aName, aTier, aAmp, aDescription, aTextures);
    }

    @Override
    public ITexture[] getTexturesActive(ITexture aBaseTexture) {
        switch (Amperes) {
            case 4:
                TEXTURE_OVERLAY = OVERLAYS_ENERGY_IN_WIRELESS_MULTI_4A;
                break;
            case 16:
                TEXTURE_OVERLAY = OVERLAYS_ENERGY_IN_WIRELESS_MULTI_16A;
                break;
            case 64:
                TEXTURE_OVERLAY = OVERLAYS_ENERGY_IN_WIRELESS_MULTI_64A;
                break;
            default:
                TEXTURE_OVERLAY = OVERLAYS_ENERGY_IN_WIRELESS_LASER;
                break;
        }
        return new ITexture[] { aBaseTexture, TEXTURE_OVERLAY[mTier] };
    }

    @Override
    public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
        switch (Amperes) {
            case 4:
                TEXTURE_OVERLAY = OVERLAYS_ENERGY_IN_WIRELESS_MULTI_4A;
                break;
            case 16:
                TEXTURE_OVERLAY = OVERLAYS_ENERGY_IN_WIRELESS_MULTI_16A;
                break;
            case 64:
                TEXTURE_OVERLAY = OVERLAYS_ENERGY_IN_WIRELESS_MULTI_64A;
                break;
            default:
                TEXTURE_OVERLAY = OVERLAYS_ENERGY_IN_WIRELESS_LASER;
                break;
        }
        return new ITexture[] { aBaseTexture, TEXTURE_OVERLAY[mTier] };
    }

    @Override
    public boolean isEnetOutput() {
        return false;
    }

    @Override
    public long getMinimumStoredEU() {
        return 512;
    }

    @Override
    public long maxEUOutput() {
        return V[mTier];
    }

    @Override
    public long maxEUStore() {
        return totalStorage(V[mTier]) * Amperes / 2;
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_Hatch_Wireless_Dynamo_Multi(mName, mTier, Amperes, mDescriptionArray, mTextures);
    }

    @Override
    public ConnectionType getConnectionType() {
        return ConnectionType.WIRELESS;
    }

    @Override
    public void onPreTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPreTick(aBaseMetaTileEntity, aTick);

        if (aBaseMetaTileEntity.isServerSide()) {

            // On first tick find the player name and attempt to add them to the map.
            if (aTick == 1) {

                // UUID and username of the owner.
                owner_uuid = aBaseMetaTileEntity.getOwnerUuid();

                strongCheckOrAddUser(owner_uuid);
            }

            // Every ticks_between_energy_addition ticks change the energy content of the machine.
            if (aTick % ticks_between_energy_addition == 0L) {
                addEUToGlobalEnergyMap(owner_uuid, getEUVar());
                setEUVar(0L);
            }
        }
    }
}
