package xir.gregtech.enums;

import static gregtech.api.enums.GT_Values.W;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import gregtech.api.interfaces.IItemContainer;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

/**
 * <li>One enum follows the TT method</li>
 * <li>The aim is to add a series of wireless hatch</li>
 */

public enum Energy_Hatch_List implements IItemContainer {

    /**
     * Add wireless energy hatch form 4A -> 1048576A HV -> UMV
     * The metaID with start to 25000
     */

    eM_energyMulti4_HV,
    eM_energyMulti16_HV,
    eM_energyMulti64_HV,
    eM_energyWirelessTunnel1_HV,
    eM_energyWirelessTunnel2_HV,
    eM_energyWirelessTunnel3_HV,
    eM_energyWirelessTunnel4_HV,
    eM_energyWirelessTunnel5_HV,
    eM_energyWirelessTunnel6_HV,
    eM_energyWirelessTunnel7_HV,
    eM_energyWirelessTunnel1_EV,
    eM_energyWirelessTunnel2_EV,
    eM_energyWirelessTunnel3_EV,
    eM_energyWirelessTunnel4_EV,
    eM_energyWirelessTunnel5_EV,
    eM_energyWirelessTunnel6_EV,
    eM_energyWirelessTunnel7_EV,
    eM_energyWirelessTunnel1_IV,
    eM_energyWirelessTunnel2_IV,
    eM_energyWirelessTunnel3_IV,
    eM_energyWirelessTunnel4_IV,
    eM_energyWirelessTunnel5_IV,
    eM_energyWirelessTunnel6_IV,
    eM_energyWirelessTunnel7_IV,
    eM_energyWirelessTunnel1_LuV,
    eM_energyWirelessTunnel2_LuV,
    eM_energyWirelessTunnel3_LuV,
    eM_energyWirelessTunnel4_LuV,
    eM_energyWirelessTunnel5_LuV,
    eM_energyWirelessTunnel6_LuV,
    eM_energyWirelessTunnel7_LuV,
    eM_energyWirelessTunnel1_ZPM,
    eM_energyWirelessTunnel2_ZPM,
    eM_energyWirelessTunnel3_ZPM,
    eM_energyWirelessTunnel4_ZPM,
    eM_energyWirelessTunnel5_ZPM,
    eM_energyWirelessTunnel6_ZPM,
    eM_energyWirelessTunnel7_ZPM,
    eM_energyWirelessTunnel1_UV,
    eM_energyWirelessTunnel2_UV,
    eM_energyWirelessTunnel3_UV,
    eM_energyWirelessTunnel4_UV,
    eM_energyWirelessTunnel5_UV,
    eM_energyWirelessTunnel6_UV,
    eM_energyWirelessTunnel7_UV,
    eM_energyWirelessTunnel1_UHV,
    eM_energyWirelessTunnel2_UHV,
    eM_energyWirelessTunnel3_UHV,
    eM_energyWirelessTunnel4_UHV,
    eM_energyWirelessTunnel5_UHV,
    eM_energyWirelessTunnel6_UHV,
    eM_energyWirelessTunnel7_UHV,
    eM_energyWirelessTunnel1_UEV,
    eM_energyWirelessTunnel2_UEV,
    eM_energyWirelessTunnel3_UEV,
    eM_energyWirelessTunnel4_UEV,
    eM_energyWirelessTunnel5_UEV,
    eM_energyWirelessTunnel6_UEV,
    eM_energyWirelessTunnel7_UEV,
    eM_energyWirelessTunnel1_UIV,
    eM_energyWirelessTunnel2_UIV,
    eM_energyWirelessTunnel3_UIV,
    eM_energyWirelessTunnel4_UIV,
    eM_energyWirelessTunnel5_UIV,
    eM_energyWirelessTunnel6_UIV,
    eM_energyWirelessTunnel7_UIV,
    eM_energyWirelessTunnel1_UMV,
    eM_energyWirelessTunnel2_UMV,
    eM_energyWirelessTunnel3_UMV,
    eM_energyWirelessTunnel4_UMV,
    eM_energyWirelessTunnel5_UMV,
    eM_energyWirelessTunnel6_UMV,
    eM_energyWirelessTunnel7_UMV,

    /**
     * Add wireless dynamo hatch form 4A -> 1048576A IV -> UHV
     * The metaID with start to 25000
     */

    eM_dynamoWirelessMulti4_IV,
    eM_dynamoWirelessMulti16_IV,
    eM_dynamoWirelessMulti64_IV,
    eM_dynamoWirelessTunnel1_IV,
    eM_dynamoWirelessTunnel2_IV,
    eM_dynamoWirelessTunnel3_IV,
    eM_dynamoWirelessTunnel4_IV,
    eM_dynamoWirelessTunnel5_IV,
    eM_dynamoWirelessTunnel6_IV,
    eM_dynamoWirelessTunnel7_IV,
    eM_dynamoWirelessMulti4_LuV,
    eM_dynamoWirelessMulti16_LuV,
    eM_dynamoWirelessMulti64_LuV,
    eM_dynamoWirelessTunnel1_LuV,
    eM_dynamoWirelessTunnel2_LuV,
    eM_dynamoWirelessTunnel3_LuV,
    eM_dynamoWirelessTunnel4_LuV,
    eM_dynamoWirelessTunnel5_LuV,
    eM_dynamoWirelessTunnel6_LuV,
    eM_dynamoWirelessTunnel7_LuV,
    eM_dynamoWirelessMulti4_ZPM,
    eM_dynamoWirelessMulti16_ZPM,
    eM_dynamoWirelessMulti64_ZPM,
    eM_dynamoWirelessTunnel1_ZPM,
    eM_dynamoWirelessTunnel2_ZPM,
    eM_dynamoWirelessTunnel3_ZPM,
    eM_dynamoWirelessTunnel4_ZPM,
    eM_dynamoWirelessTunnel5_ZPM,
    eM_dynamoWirelessTunnel6_ZPM,
    eM_dynamoWirelessTunnel7_ZPM,
    eM_dynamoWirelessMulti4_UV,
    eM_dynamoWirelessMulti16_UV,
    eM_dynamoWirelessMulti64_UV,
    eM_dynamoWirelessTunnel1_UV,
    eM_dynamoWirelessTunnel2_UV,
    eM_dynamoWirelessTunnel3_UV,
    eM_dynamoWirelessTunnel4_UV,
    eM_dynamoWirelessTunnel5_UV,
    eM_dynamoWirelessTunnel6_UV,
    eM_dynamoWirelessTunnel7_UV,
    eM_dynamoWirelessMulti4_UHV,
    eM_dynamoWirelessMulti16_UHV,
    eM_dynamoWirelessMulti64_UHV,
    eM_dynamoWirelessTunnel1_UHV,
    eM_dynamoWirelessTunnel2_UHV,
    eM_dynamoWirelessTunnel3_UHV,
    eM_dynamoWirelessTunnel4_UHV,
    eM_dynamoWirelessTunnel5_UHV,
    eM_dynamoWirelessTunnel6_UHV,
    eM_dynamoWirelessTunnel7_UHV,

    ;

    private ItemStack mStack;
    private boolean mHasNotBeenSet = true;

    @Override
    public IItemContainer set(Item aItem) {
        mHasNotBeenSet = false;
        if (aItem == null) {
            return this;
        }
        ItemStack aStack = new ItemStack(aItem, 1, 0);
        mStack = GT_Utility.copyAmount(1, aStack);
        return this;
    }

    @Override
    public IItemContainer set(ItemStack aStack) {
        mHasNotBeenSet = false;
        mStack = GT_Utility.copyAmount(1, aStack);
        return this;
    }

    @Override
    public Item getItem() {
        if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
        if (GT_Utility.isStackInvalid(mStack)) {
            return null;
        }
        return mStack.getItem();
    }

    @Override
    public Block getBlock() {
        if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
        return GT_Utility.getBlockFromStack(new ItemStack(getItem()));
    }

    @Override
    public final boolean hasBeenSet() {
        return !mHasNotBeenSet;
    }

    @Override
    public boolean isStackEqual(Object aStack) {
        return isStackEqual(aStack, false, false);
    }

    @Override
    public boolean isStackEqual(Object aStack, boolean aWildcard, boolean aIgnoreNBT) {
        if (GT_Utility.isStackInvalid(aStack)) {
            return false;
        }
        return GT_Utility.areUnificationsEqual((ItemStack) aStack, aWildcard ? getWildcard(1) : get(1), aIgnoreNBT);
    }

    @Override
    public ItemStack get(long aAmount, Object... aReplacements) {
        if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
        if (GT_Utility.isStackInvalid(mStack)) {
            return GT_Utility.copyAmount(aAmount, aReplacements);
        }
        return GT_Utility.copyAmount(aAmount, GT_OreDictUnificator.get(mStack));
    }

    @Override
    public ItemStack getWildcard(long aAmount, Object... aReplacements) {
        if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
        if (GT_Utility.isStackInvalid(mStack)) {
            return GT_Utility.copyAmount(aAmount, aReplacements);
        }
        return GT_Utility.copyAmountAndMetaData(aAmount, W, GT_OreDictUnificator.get(mStack));
    }

    @Override
    public ItemStack getUndamaged(long aAmount, Object... aReplacements) {
        if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
        if (GT_Utility.isStackInvalid(mStack)) {
            return GT_Utility.copyAmount(aAmount, aReplacements);
        }
        return GT_Utility.copyAmountAndMetaData(aAmount, 0, GT_OreDictUnificator.get(mStack));
    }

    @Override
    public ItemStack getAlmostBroken(long aAmount, Object... aReplacements) {
        if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
        if (GT_Utility.isStackInvalid(mStack)) {
            return GT_Utility.copyAmount(aAmount, aReplacements);
        }
        return GT_Utility.copyAmountAndMetaData(aAmount, mStack.getMaxDamage() - 1, GT_OreDictUnificator.get(mStack));
    }

    @Override
    public ItemStack getWithName(long aAmount, String aDisplayName, Object... aReplacements) {
        ItemStack rStack = get(1, aReplacements);
        if (GT_Utility.isStackInvalid(rStack)) {
            return null;
        }
        rStack.setStackDisplayName(aDisplayName);
        return GT_Utility.copyAmount(aAmount, rStack);
    }

    @Override
    public ItemStack getWithCharge(long aAmount, int aEnergy, Object... aReplacements) {
        ItemStack rStack = get(1, aReplacements);
        if (GT_Utility.isStackInvalid(rStack)) {
            return null;
        }
        GT_ModHandler.chargeElectricItem(rStack, aEnergy, Integer.MAX_VALUE, true, false);
        return GT_Utility.copyAmount(aAmount, rStack);
    }

    @Override
    public ItemStack getWithDamage(long aAmount, long aMetaValue, Object... aReplacements) {
        if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
        if (GT_Utility.isStackInvalid(mStack)) {
            return GT_Utility.copyAmount(aAmount, aReplacements);
        }
        return GT_Utility.copyAmountAndMetaData(aAmount, aMetaValue, GT_OreDictUnificator.get(mStack));
    }

    @Override
    public IItemContainer registerOre(Object... aOreNames) {
        if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
        for (Object tOreName : aOreNames) {
            GT_OreDictUnificator.registerOre(tOreName, get(1));
        }
        return this;
    }

    @Override
    public IItemContainer registerWildcardAsOre(Object... aOreNames) {
        if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
        for (Object tOreName : aOreNames) {
            GT_OreDictUnificator.registerOre(tOreName, getWildcard(1));
        }
        return this;
    }
}
