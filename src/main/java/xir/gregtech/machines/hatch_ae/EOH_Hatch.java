package xir.gregtech.machines.hatch_ae;

import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_ME_INPUT_FLUID_HATCH;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_ME_INPUT_FLUID_HATCH_ACTIVE;
import static xir.gregtech.enums.Energy_Hatch_List.EOH_Hatch_ME;

import java.util.EnumSet;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

import com.gtnewhorizons.modularui.api.screen.ModularWindow;
import com.gtnewhorizons.modularui.api.screen.UIBuildContext;
import com.gtnewhorizons.modularui.common.widget.DrawableWidget;
import com.gtnewhorizons.modularui.common.widget.SlotWidget;
import com.gtnewhorizons.modularui.common.widget.TextWidget;

import appeng.api.config.Actionable;
import appeng.api.config.PowerMultiplier;
import appeng.api.implementations.IPowerChannelState;
import appeng.api.networking.GridFlags;
import appeng.api.networking.security.BaseActionSource;
import appeng.api.networking.security.IActionHost;
import appeng.api.networking.security.MachineSource;
import appeng.api.storage.IMEMonitor;
import appeng.api.storage.data.IAEFluidStack;
import appeng.api.util.AECableType;
import appeng.me.GridAccessException;
import appeng.me.helpers.AENetworkProxy;
import appeng.me.helpers.IGridProxyable;
import appeng.util.item.AEFluidStack;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.gui.modularui.GT_UITextures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.modularui.IAddGregtechLogo;
import gregtech.api.interfaces.modularui.IAddUIWidgets;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Input;
import gregtech.api.render.TextureFactory;

public class EOH_Hatch extends GT_MetaTileEntity_Hatch_Input
    implements IPowerChannelState, IAddGregtechLogo, IAddUIWidgets {

    public static final byte EOH_FLUID_TYPE_AMOUNT = 3;
    public static final FluidStack[] EOH_MATCH_FLUID = new FluidStack[] {
        new FluidStack(MaterialsUEVplus.RawStarMatter.mFluid, 1), new FluidStack(Materials.Hydrogen.mGas, 1),
        new FluidStack(Materials.Helium.mGas, 1) };
    public final long[] expectedFluidAmount = new long[EOH_FLUID_TYPE_AMOUNT];

    @Nullable
    protected AENetworkProxy gridProxy = null;
    protected BaseActionSource requestSource = null;
    private boolean astralArrayMode = false;
    private boolean additionalConnection = false;

    public EOH_Hatch(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional, 14, 0, new String[] { "EOH modular" });
    }

    public EOH_Hatch(String aName, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, 0, 14, aDescription, aTextures);
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new EOH_Hatch(mName, mDescriptionArray, mTextures);
    }

    @Override
    public ITexture[] getTexturesActive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, TextureFactory.of(OVERLAY_ME_INPUT_FLUID_HATCH_ACTIVE) };
    }

    @Override
    public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, TextureFactory.of(OVERLAY_ME_INPUT_FLUID_HATCH) };
    }

    public boolean processAeFluid() {
        AENetworkProxy proxy = getProxy();

        // Check the fluid so that it can be safely removed
        for (byte i = 0; i < EOH_FLUID_TYPE_AMOUNT; i++) {
            if (expectedFluidAmount[i] == 0) {
                continue;
            }

            try {
                IMEMonitor<IAEFluidStack> sg = proxy.getStorage()
                    .getFluidInventory();
                IAEFluidStack request = AEFluidStack.create(EOH_MATCH_FLUID[i]);
                long amount = expectedFluidAmount[i];
                request.setStackSize(amount);
                IAEFluidStack result = sg.extractItems(request, Actionable.SIMULATE, getRequestSource());
                if (result == null || result.getStackSize() != amount) {
                    return false;
                }
            } catch (GridAccessException e) {
                return false;
            }
        }

        // Returns true if fluid can be safely removed, false otherwise
        for (byte i = 0; i < EOH_FLUID_TYPE_AMOUNT; i++) {
            if (expectedFluidAmount[i] == 0) {
                continue;
            }

            try {
                IMEMonitor<IAEFluidStack> sg = proxy.getStorage()
                    .getFluidInventory();
                IAEFluidStack request = AEFluidStack.create(EOH_MATCH_FLUID[i]);
                long amount = expectedFluidAmount[i];
                request.setStackSize(amount);
                IAEFluidStack extractionResult = sg.extractItems(request, Actionable.MODULATE, getRequestSource());
                proxy.getEnergy()
                    .extractAEPower(amount, Actionable.MODULATE, PowerMultiplier.CONFIG);
                if (extractionResult == null || extractionResult.getStackSize() != amount) {
                    return false;
                }
            } catch (GridAccessException e) {
                return false;
            }
        }
        return true;
    }

    private BaseActionSource getRequestSource() {
        if (requestSource == null) requestSource = new MachineSource((IActionHost) getBaseMetaTileEntity());
        return requestSource;
    }

    @Override
    public void onFirstTick(IGregTechTileEntity aBaseMetaTileEntity) {
        super.onFirstTick(aBaseMetaTileEntity);
        getProxy().onReady();
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTimer) {
        if (getBaseMetaTileEntity().isServerSide()) {
            if (aTimer % 20 == 0) {
                getBaseMetaTileEntity().setActive(isActive());
            }
        }
        super.onPostTick(aBaseMetaTileEntity, aTimer);
    }

    @Override
    public void onFacingChange() {
        updateValidGridProxySides();
    }

    private void updateValidGridProxySides() {
        if (additionalConnection) {
            getProxy().setValidSides(EnumSet.complementOf(EnumSet.of(ForgeDirection.UNKNOWN)));
        } else {
            getProxy().setValidSides(EnumSet.of(getBaseMetaTileEntity().getFrontFacing()));
        }
    }

    @Override
    public AECableType getCableConnectionType(ForgeDirection forgeDirection) {
        return isOutputFacing(forgeDirection) ? AECableType.SMART : AECableType.NONE;
    }

    @Override
    public boolean onWireCutterRightClick(ForgeDirection side, ForgeDirection wrenchingSide, EntityPlayer aPlayer,
        float aX, float aY, float aZ) {
        additionalConnection = !additionalConnection;
        updateValidGridProxySides();
        aPlayer.addChatComponentMessage(
            new ChatComponentTranslation("GT5U.hatch.additionalConnection." + additionalConnection));
        return true;
    }

    @Override
    public AENetworkProxy getProxy() {
        if (gridProxy == null) {
            if (getBaseMetaTileEntity() instanceof IGridProxyable) {
                gridProxy = new AENetworkProxy(
                    (IGridProxyable) getBaseMetaTileEntity(),
                    "proxy",
                    EOH_Hatch_ME.get(1),
                    true);
                gridProxy.setFlags(GridFlags.REQUIRE_CHANNEL);
                updateValidGridProxySides();
                if (getBaseMetaTileEntity().getWorld() != null) gridProxy.setOwner(
                    getBaseMetaTileEntity().getWorld()
                        .getPlayerEntityByName(getBaseMetaTileEntity().getOwnerName()));
            }
        }
        return this.gridProxy;
    }

    @Override
    public void updateSlots() {}

    @Override
    public boolean isPowered() {
        return getProxy() != null && getProxy().isPowered();
    }

    @Override
    public boolean isActive() {
        return getProxy() != null && getProxy().isActive();
    }

    @Override
    public boolean canTankBeEmptied() {
        return false;
    }

    @Override
    public boolean canTankBeFilled() {
        return false;
    }

    @Override
    public boolean doesEmptyContainers() {
        return false;
    }

    @Override
    public boolean isValidSlot(int aIndex) {
        return false;
    }

    @Override
    public void addGregTechLogo(ModularWindow.Builder builder) {
        builder.widget(
            new DrawableWidget().setDrawable(getGUITextureSet().getGregTechLogo())
                .setSize(17, 17)
                .setPos(113, 56));
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);

        aNBT.setLong("presentRawStarMatterAmount", expectedFluidAmount[0]);
        aNBT.setLong("presentHydrogenHeliumAmount", expectedFluidAmount[1]);
        aNBT.setLong("presentHeliumAmount", expectedFluidAmount[2]);
        aNBT.setBoolean("AstralArrayMode", astralArrayMode);
        aNBT.setBoolean("additionalConnection", additionalConnection);
        getProxy().writeToNBT(aNBT);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);

        expectedFluidAmount[0] = aNBT.getLong("presentRawStarMatterAmount");
        expectedFluidAmount[1] = aNBT.getLong("presentHydrogenHeliumAmount");
        expectedFluidAmount[2] = aNBT.getLong("presentHeliumAmount");
        astralArrayMode = aNBT.getBoolean("AstralArrayMode");
        additionalConnection = aNBT.getBoolean("additionalConnection");
        getProxy().readFromNBT(aNBT);
    }

    @Override
    public void addUIWidgets(ModularWindow.Builder builder, UIBuildContext buildContext) {
        builder.widget(
            new DrawableWidget().setDrawable(GT_UITextures.PICTURE_SCREEN_BLACK)
                .setPos(7, 16)
                .setSize(71, 45))
            .widget(
                new SlotWidget(inventoryHandler, getInputSlot())
                    .setBackground(getGUITextureSet().getItemSlot(), GT_UITextures.OVERLAY_SLOT_IN)
                    .setPos(79, 16))
            .widget(
                new SlotWidget(inventoryHandler, getOutputSlot()).setAccess(true, false)
                    .setBackground(getGUITextureSet().getItemSlot(), GT_UITextures.OVERLAY_SLOT_OUT)
                    .setPos(79, 52))
            .widget(
                createFluidSlot().setBackground(GT_UITextures.TRANSPARENT)
                    .setPos(58, 41))
            .widget(
                new TextWidget("Liquid Amount").setDefaultColor(COLOR_TEXT_WHITE.get())
                    .setPos(10, 20))
            .widget(
                new TextWidget().setStringSupplier(() -> numberFormat.format(mFluid != null ? mFluid.amount : 0))
                    .setDefaultColor(COLOR_TEXT_WHITE.get())
                    .setPos(10, 30));
    }
}
