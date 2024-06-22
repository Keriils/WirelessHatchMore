package xir.gregtech.loader;

import static xir.gregtech.enums.Energy_Hatch_List.GT_Integration_ME_Hatch;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti16_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti16_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti16_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti16_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti16_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti4_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti4_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti4_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti4_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti4_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti64_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti64_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti64_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti64_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessMulti64_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel1_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel1_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel1_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel1_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel1_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel2_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel2_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel2_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel2_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel2_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel3_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel3_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel3_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel3_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel3_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel4_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel4_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel4_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel4_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel4_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel5_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel5_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel5_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel5_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel5_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel6_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel6_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel6_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel6_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel6_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel7_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel7_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel7_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel7_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_dynamoWirelessTunnel7_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyMulti16_HV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyMulti4_HV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyMulti64_HV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel1_EV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel1_HV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel1_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel1_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel1_UEV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel1_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel1_UIV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel1_UMV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel1_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel1_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel2_EV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel2_HV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel2_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel2_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel2_UEV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel2_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel2_UIV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel2_UMV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel2_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel2_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel3_EV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel3_HV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel3_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel3_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel3_UEV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel3_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel3_UIV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel3_UMV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel3_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel3_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel4_EV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel4_HV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel4_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel4_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel4_UEV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel4_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel4_UIV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel4_UMV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel4_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel4_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel5_EV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel5_HV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel5_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel5_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel5_UEV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel5_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel5_UIV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel5_UMV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel5_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel5_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel6_EV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel6_HV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel6_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel6_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel6_UEV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel6_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel6_UIV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel6_UMV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel6_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel6_ZPM;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel7_EV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel7_HV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel7_IV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel7_LuV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel7_UEV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel7_UHV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel7_UIV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel7_UMV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel7_UV;
import static xir.gregtech.enums.Energy_Hatch_List.eM_energyWirelessTunnel7_ZPM;
import static xir.wirelesshatchmore.utils.LangTrans.trans;

import xir.gregtech.machines.hatch_ae.GT_Hatch_Crafting_Integration_ME;
import xir.gregtech.machines.hatch_energy.GT_Hatch_Wireless_Dynamo_Multi;
import xir.gregtech.machines.hatch_energy.GT_Hatch_Wireless_Energy_Multi;

public class GT_Loader {

    public static void test() {
        //  test metaID from 25123 to 25150
        GT_Integration_ME_Hatch.set(
            new GT_Hatch_Crafting_Integration_ME(
                25123,
                "test_hatch",
                "Integration_hatch",
                true
            ).getStackForm(1L)
        );
    }

    public static void energyHatchMore() {
        eM_energyMulti4_HV.set(
            new GT_Hatch_Wireless_Energy_Multi(25000, "eM_energyMulti4_HV", trans("eM_energyMulti4_HV"), 3, 4)
                .getStackForm(1L));
        eM_energyMulti16_HV.set(
            new GT_Hatch_Wireless_Energy_Multi(25001, "eM_energyMulti16_HV", trans("eM_energyMulti16_HV"), 3, 16)
                .getStackForm(1L));
        eM_energyMulti64_HV.set(
            new GT_Hatch_Wireless_Energy_Multi(25002, "eM_energyMulti64_HV", trans("eM_energyMulti64_HV"), 3, 64)
                .getStackForm(1L));
        eM_energyWirelessTunnel1_HV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25003,
                "eM_energyWirelessTunnel1_HV",
                trans("eM_energyWirelessTunnel1_HV"),
                3,
                256).getStackForm(1L));
        eM_energyWirelessTunnel2_HV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25004,
                "eM_energyWirelessTunnel2_HV",
                trans("eM_energyWirelessTunnel2_HV"),
                3,
                1024).getStackForm(1L));
        eM_energyWirelessTunnel3_HV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25005,
                "eM_energyWirelessTunnel3_HV",
                trans("eM_energyWirelessTunnel3_HV"),
                3,
                4096).getStackForm(1L));
        eM_energyWirelessTunnel4_HV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25006,
                "eM_energyWirelessTunnel4_HV",
                trans("eM_energyWirelessTunnel4_HV"),
                3,
                16384).getStackForm(1L));
        eM_energyWirelessTunnel5_HV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25007,
                "eM_energyWirelessTunnel5_HV",
                trans("eM_energyWirelessTunnel5_HV"),
                3,
                65536).getStackForm(1L));
        eM_energyWirelessTunnel6_HV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25008,
                "eM_energyWirelessTunnel6_HV",
                trans("eM_energyWirelessTunnel6_HV"),
                3,
                262144).getStackForm(1L));
        eM_energyWirelessTunnel7_HV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25009,
                "eM_energyWirelessTunnel7_HV",
                trans("eM_energyWirelessTunnel7_HV"),
                3,
                1048576).getStackForm(1L));
        eM_energyWirelessTunnel1_EV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25010,
                "eM_energyWirelessTunnel1_EV",
                trans("eM_energyWirelessTunnel1_EV"),
                4,
                256).getStackForm(1L));
        eM_energyWirelessTunnel2_EV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25011,
                "eM_energyWirelessTunnel2_EV",
                trans("eM_energyWirelessTunnel2_EV"),
                4,
                1024).getStackForm(1L));
        eM_energyWirelessTunnel3_EV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25012,
                "eM_energyWirelessTunnel3_EV",
                trans("eM_energyWirelessTunnel3_EV"),
                4,
                4096).getStackForm(1L));
        eM_energyWirelessTunnel4_EV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25013,
                "eM_energyWirelessTunnel4_EV",
                trans("eM_energyWirelessTunnel4_EV"),
                4,
                16384).getStackForm(1L));
        eM_energyWirelessTunnel5_EV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25014,
                "eM_energyWirelessTunnel5_EV",
                trans("eM_energyWirelessTunnel5_EV"),
                4,
                65536).getStackForm(1L));
        eM_energyWirelessTunnel6_EV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25015,
                "eM_energyWirelessTunnel6_EV",
                trans("eM_energyWirelessTunnel6_EV"),
                4,
                262144).getStackForm(1L));
        eM_energyWirelessTunnel7_EV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25016,
                "eM_energyWirelessTunnel7_EV",
                trans("eM_energyWirelessTunnel7_EV"),
                4,
                1048576).getStackForm(1L));
        eM_energyWirelessTunnel1_IV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25017,
                "eM_energyWirelessTunnel1_IV",
                trans("eM_energyWirelessTunnel1_IV"),
                5,
                256).getStackForm(1L));
        eM_energyWirelessTunnel2_IV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25018,
                "eM_energyWirelessTunnel2_IV",
                trans("eM_energyWirelessTunnel2_IV"),
                5,
                1024).getStackForm(1L));
        eM_energyWirelessTunnel3_IV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25019,
                "eM_energyWirelessTunnel3_IV",
                trans("eM_energyWirelessTunnel3_IV"),
                5,
                4096).getStackForm(1L));
        eM_energyWirelessTunnel4_IV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25020,
                "eM_energyWirelessTunnel4_IV",
                trans("eM_energyWirelessTunnel4_IV"),
                5,
                16384).getStackForm(1L));
        eM_energyWirelessTunnel5_IV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25021,
                "eM_energyWirelessTunnel5_IV",
                trans("eM_energyWirelessTunnel5_IV"),
                5,
                65536).getStackForm(1L));
        eM_energyWirelessTunnel6_IV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25022,
                "eM_energyWirelessTunnel6_IV",
                trans("eM_energyWirelessTunnel6_IV"),
                5,
                262144).getStackForm(1L));
        eM_energyWirelessTunnel7_IV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25023,
                "eM_energyWirelessTunnel7_IV",
                trans("eM_energyWirelessTunnel7_IV"),
                5,
                1048576).getStackForm(1L));
        eM_energyWirelessTunnel1_LuV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25024,
                "eM_energyWirelessTunnel1_LuV",
                trans("eM_energyWirelessTunnel1_LuV"),
                6,
                256).getStackForm(1L));
        eM_energyWirelessTunnel2_LuV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25025,
                "eM_energyWirelessTunnel2_LuV",
                trans("eM_energyWirelessTunnel2_LuV"),
                6,
                1024).getStackForm(1L));
        eM_energyWirelessTunnel3_LuV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25026,
                "eM_energyWirelessTunnel3_LuV",
                trans("eM_energyWirelessTunnel3_LuV"),
                6,
                4096).getStackForm(1L));
        eM_energyWirelessTunnel4_LuV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25027,
                "eM_energyWirelessTunnel4_LuV",
                trans("eM_energyWirelessTunnel4_LuV"),
                6,
                16384).getStackForm(1L));
        eM_energyWirelessTunnel5_LuV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25028,
                "eM_energyWirelessTunnel5_LuV",
                trans("eM_energyWirelessTunnel5_LuV"),
                6,
                65536).getStackForm(1L));
        eM_energyWirelessTunnel6_LuV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25029,
                "eM_energyWirelessTunnel6_LuV",
                trans("eM_energyWirelessTunnel6_LuV"),
                6,
                262144).getStackForm(1L));
        eM_energyWirelessTunnel7_LuV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25030,
                "eM_energyWirelessTunnel7_LuV",
                trans("eM_energyWirelessTunnel7_LuV"),
                6,
                1048576).getStackForm(1L));
        eM_energyWirelessTunnel1_ZPM.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25031,
                "eM_energyWirelessTunnel1_ZPM",
                trans("eM_energyWirelessTunnel1_ZPM"),
                7,
                256).getStackForm(1L));
        eM_energyWirelessTunnel2_ZPM.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25032,
                "eM_energyWirelessTunnel2_ZPM",
                trans("eM_energyWirelessTunnel2_ZPM"),
                7,
                1024).getStackForm(1L));
        eM_energyWirelessTunnel3_ZPM.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25033,
                "eM_energyWirelessTunnel3_ZPM",
                trans("eM_energyWirelessTunnel3_ZPM"),
                7,
                4096).getStackForm(1L));
        eM_energyWirelessTunnel4_ZPM.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25034,
                "eM_energyWirelessTunnel4_ZPM",
                trans("eM_energyWirelessTunnel4_ZPM"),
                7,
                16384).getStackForm(1L));
        eM_energyWirelessTunnel5_ZPM.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25035,
                "eM_energyWirelessTunnel5_ZPM",
                trans("eM_energyWirelessTunnel5_ZPM"),
                7,
                65536).getStackForm(1L));
        eM_energyWirelessTunnel6_ZPM.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25036,
                "eM_energyWirelessTunnel6_ZPM",
                trans("eM_energyWirelessTunnel6_ZPM"),
                7,
                262144).getStackForm(1L));
        eM_energyWirelessTunnel7_ZPM.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25037,
                "eM_energyWirelessTunnel7_ZPM",
                trans("eM_energyWirelessTunnel7_ZPM"),
                7,
                1048576).getStackForm(1L));
        eM_energyWirelessTunnel1_UV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25038,
                "eM_energyWirelessTunnel1_UV",
                trans("eM_energyWirelessTunnel1_UV"),
                8,
                256).getStackForm(1L));
        eM_energyWirelessTunnel2_UV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25039,
                "eM_energyWirelessTunnel2_UV",
                trans("eM_energyWirelessTunnel2_UV"),
                8,
                1024).getStackForm(1L));
        eM_energyWirelessTunnel3_UV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25040,
                "eM_energyWirelessTunnel3_UV",
                trans("eM_energyWirelessTunnel3_UV"),
                8,
                4096).getStackForm(1L));
        eM_energyWirelessTunnel4_UV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25041,
                "eM_energyWirelessTunnel4_UV",
                trans("eM_energyWirelessTunnel4_UV"),
                8,
                16384).getStackForm(1L));
        eM_energyWirelessTunnel5_UV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25042,
                "eM_energyWirelessTunnel5_UV",
                trans("eM_energyWirelessTunnel5_UV"),
                8,
                65536).getStackForm(1L));
        eM_energyWirelessTunnel6_UV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25043,
                "eM_energyWirelessTunnel6_UV",
                trans("eM_energyWirelessTunnel6_UV"),
                8,
                262144).getStackForm(1L));
        eM_energyWirelessTunnel7_UV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25044,
                "eM_energyWirelessTunnel7_UV",
                trans("eM_energyWirelessTunnel7_UV"),
                8,
                1048576).getStackForm(1L));
        eM_energyWirelessTunnel1_UHV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25045,
                "eM_energyWirelessTunnel1_UHV",
                trans("eM_energyWirelessTunnel1_UHV"),
                9,
                256).getStackForm(1L));
        eM_energyWirelessTunnel2_UHV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25046,
                "eM_energyWirelessTunnel2_UHV",
                trans("eM_energyWirelessTunnel2_UHV"),
                9,
                1024).getStackForm(1L));
        eM_energyWirelessTunnel3_UHV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25047,
                "eM_energyWirelessTunnel3_UHV",
                trans("eM_energyWirelessTunnel3_UHV"),
                9,
                4096).getStackForm(1L));
        eM_energyWirelessTunnel4_UHV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25048,
                "eM_energyWirelessTunnel4_UHV",
                trans("eM_energyWirelessTunnel4_UHV"),
                9,
                16384).getStackForm(1L));
        eM_energyWirelessTunnel5_UHV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25049,
                "eM_energyWirelessTunnel5_UHV",
                trans("eM_energyWirelessTunnel5_UHV"),
                9,
                65536).getStackForm(1L));
        eM_energyWirelessTunnel6_UHV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25050,
                "eM_energyWirelessTunnel6_UHV",
                trans("eM_energyWirelessTunnel6_UHV"),
                9,
                262144).getStackForm(1L));
        eM_energyWirelessTunnel7_UHV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25051,
                "eM_energyWirelessTunnel7_UHV",
                trans("eM_energyWirelessTunnel7_UHV"),
                9,
                1048576).getStackForm(1L));
        eM_energyWirelessTunnel1_UEV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25052,
                "eM_energyWirelessTunnel1_UEV",
                trans("eM_energyWirelessTunnel1_UEV"),
                10,
                256).getStackForm(1L));
        eM_energyWirelessTunnel2_UEV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25053,
                "eM_energyWirelessTunnel2_UEV",
                trans("eM_energyWirelessTunnel2_UEV"),
                10,
                1024).getStackForm(1L));
        eM_energyWirelessTunnel3_UEV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25054,
                "eM_energyWirelessTunnel3_UEV",
                trans("eM_energyWirelessTunnel3_UEV"),
                10,
                4096).getStackForm(1L));
        eM_energyWirelessTunnel4_UEV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25055,
                "eM_energyWirelessTunnel4_UEV",
                trans("eM_energyWirelessTunnel4_UEV"),
                10,
                16384).getStackForm(1L));
        eM_energyWirelessTunnel5_UEV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25056,
                "eM_energyWirelessTunnel5_UEV",
                trans("eM_energyWirelessTunnel5_UEV"),
                10,
                65536).getStackForm(1L));
        eM_energyWirelessTunnel6_UEV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25057,
                "eM_energyWirelessTunnel6_UEV",
                trans("eM_energyWirelessTunnel6_UEV"),
                10,
                262144).getStackForm(1L));
        eM_energyWirelessTunnel7_UEV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25058,
                "eM_energyWirelessTunnel7_UEV",
                trans("eM_energyWirelessTunnel7_UEV"),
                10,
                1048576).getStackForm(1L));
        eM_energyWirelessTunnel1_UIV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25059,
                "eM_energyWirelessTunnel1_UIV",
                trans("eM_energyWirelessTunnel1_UIV"),
                11,
                256).getStackForm(1L));
        eM_energyWirelessTunnel2_UIV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25060,
                "eM_energyWirelessTunnel2_UIV",
                trans("eM_energyWirelessTunnel2_UIV"),
                11,
                1024).getStackForm(1L));
        eM_energyWirelessTunnel3_UIV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25061,
                "eM_energyWirelessTunnel3_UIV",
                trans("eM_energyWirelessTunnel3_UIV"),
                11,
                4096).getStackForm(1L));
        eM_energyWirelessTunnel4_UIV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25062,
                "eM_energyWirelessTunnel4_UIV",
                trans("eM_energyWirelessTunnel4_UIV"),
                11,
                16384).getStackForm(1L));
        eM_energyWirelessTunnel5_UIV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25063,
                "eM_energyWirelessTunnel5_UIV",
                trans("eM_energyWirelessTunnel5_UIV"),
                11,
                65536).getStackForm(1L));
        eM_energyWirelessTunnel6_UIV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25064,
                "eM_energyWirelessTunnel6_UIV",
                trans("eM_energyWirelessTunnel6_UIV"),
                11,
                262144).getStackForm(1L));
        eM_energyWirelessTunnel7_UIV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25065,
                "eM_energyWirelessTunnel7_UIV",
                trans("eM_energyWirelessTunnel7_UIV"),
                11,
                1048576).getStackForm(1L));
        eM_energyWirelessTunnel1_UMV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25066,
                "eM_energyWirelessTunnel1_UMV",
                trans("eM_energyWirelessTunnel1_UMV"),
                12,
                256).getStackForm(1L));
        eM_energyWirelessTunnel2_UMV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25067,
                "eM_energyWirelessTunnel2_UMV",
                trans("eM_energyWirelessTunnel2_UMV"),
                12,
                1024).getStackForm(1L));
        eM_energyWirelessTunnel3_UMV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25068,
                "eM_energyWirelessTunnel3_UMV",
                trans("eM_energyWirelessTunnel3_UMV"),
                12,
                4096).getStackForm(1L));
        eM_energyWirelessTunnel4_UMV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25069,
                "eM_energyWirelessTunnel4_UMV",
                trans("eM_energyWirelessTunnel4_UMV"),
                12,
                16384).getStackForm(1L));
        eM_energyWirelessTunnel5_UMV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25070,
                "eM_energyWirelessTunnel5_UMV",
                trans("eM_energyWirelessTunnel5_UMV"),
                12,
                65536).getStackForm(1L));
        eM_energyWirelessTunnel6_UMV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25071,
                "eM_energyWirelessTunnel6_UMV",
                trans("eM_energyWirelessTunnel6_UMV"),
                12,
                262144).getStackForm(1L));
        eM_energyWirelessTunnel7_UMV.set(
            new GT_Hatch_Wireless_Energy_Multi(
                25072,
                "eM_energyWirelessTunnel7_UMV",
                trans("eM_energyWirelessTunnel7_UMV"),
                12,
                1048576).getStackForm(1L));
    }

    public static void dynamoHatchMore() {
        eM_dynamoWirelessMulti4_IV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25073,
                "eM_dynamoWirelessMulti4_IV",
                trans("eM_dynamoWirelessMulti4_IV"),
                5,
                4).getStackForm(1L));
        eM_dynamoWirelessMulti16_IV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25074,
                "eM_dynamoWirelessMulti16_IV",
                trans("eM_dynamoWirelessMulti16_IV"),
                5,
                16).getStackForm(1L));
        eM_dynamoWirelessMulti64_IV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25075,
                "eM_dynamoWirelessMulti64_IV",
                trans("eM_dynamoWirelessMulti64_IV"),
                5,
                64).getStackForm(1L));
        eM_dynamoWirelessTunnel1_IV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25076,
                "eM_dynamoWirelessTunnel1_IV",
                trans("eM_dynamoWirelessTunnel1_IV"),
                5,
                256).getStackForm(1L));
        eM_dynamoWirelessTunnel2_IV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25077,
                "eM_dynamoWirelessTunnel2_IV",
                trans("eM_dynamoWirelessTunnel2_IV"),
                5,
                1024).getStackForm(1L));
        eM_dynamoWirelessTunnel3_IV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25078,
                "eM_dynamoWirelessTunnel3_IV",
                trans("eM_dynamoWirelessTunnel3_IV"),
                5,
                4096).getStackForm(1L));
        eM_dynamoWirelessTunnel4_IV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25079,
                "eM_dynamoWirelessTunnel4_IV",
                trans("eM_dynamoWirelessTunnel4_IV"),
                5,
                16384).getStackForm(1L));
        eM_dynamoWirelessTunnel5_IV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25080,
                "eM_dynamoWirelessTunnel5_IV",
                trans("eM_dynamoWirelessTunnel5_IV"),
                5,
                65536).getStackForm(1L));
        eM_dynamoWirelessTunnel6_IV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25081,
                "eM_dynamoWirelessTunnel6_IV",
                trans("eM_dynamoWirelessTunnel6_IV"),
                5,
                262144).getStackForm(1L));
        eM_dynamoWirelessTunnel7_IV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25082,
                "eM_dynamoWirelessTunnel7_IV",
                trans("eM_dynamoWirelessTunnel7_IV"),
                5,
                1048576).getStackForm(1L));
        eM_dynamoWirelessMulti4_LuV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25083,
                "eM_dynamoWirelessMulti4_LuV",
                trans("eM_dynamoWirelessMulti4_LuV"),
                6,
                4).getStackForm(1L));
        eM_dynamoWirelessMulti16_LuV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25084,
                "eM_dynamoWirelessMulti16_LuV",
                trans("eM_dynamoWirelessMulti16_LuV"),
                6,
                16).getStackForm(1L));
        eM_dynamoWirelessMulti64_LuV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25085,
                "eM_dynamoWirelessMulti64_LuV",
                trans("eM_dynamoWirelessMulti64_LuV"),
                6,
                64).getStackForm(1L));
        eM_dynamoWirelessTunnel1_LuV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25086,
                "eM_dynamoWirelessTunnel1_LuV",
                trans("eM_dynamoWirelessTunnel1_LuV"),
                6,
                256).getStackForm(1L));
        eM_dynamoWirelessTunnel2_LuV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25087,
                "eM_dynamoWirelessTunnel2_LuV",
                trans("eM_dynamoWirelessTunnel2_LuV"),
                6,
                1024).getStackForm(1L));
        eM_dynamoWirelessTunnel3_LuV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25088,
                "eM_dynamoWirelessTunnel3_LuV",
                trans("eM_dynamoWirelessTunnel3_LuV"),
                6,
                4096).getStackForm(1L));
        eM_dynamoWirelessTunnel4_LuV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25089,
                "eM_dynamoWirelessTunnel4_LuV",
                trans("eM_dynamoWirelessTunnel4_LuV"),
                6,
                16384).getStackForm(1L));
        eM_dynamoWirelessTunnel5_LuV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25090,
                "eM_dynamoWirelessTunnel5_LuV",
                trans("eM_dynamoWirelessTunnel5_LuV"),
                6,
                65536).getStackForm(1L));
        eM_dynamoWirelessTunnel6_LuV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25091,
                "eM_dynamoWirelessTunnel6_LuV",
                trans("eM_dynamoWirelessTunnel6_LuV"),
                6,
                262144).getStackForm(1L));
        eM_dynamoWirelessTunnel7_LuV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25092,
                "eM_dynamoWirelessTunnel7_LuV",
                trans("eM_dynamoWirelessTunnel7_LuV"),
                6,
                1048576).getStackForm(1L));
        eM_dynamoWirelessMulti4_ZPM.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25093,
                "eM_dynamoWirelessMulti4_ZPM",
                trans("eM_dynamoWirelessMulti4_ZPM"),
                7,
                4).getStackForm(1L));
        eM_dynamoWirelessMulti16_ZPM.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25094,
                "eM_dynamoWirelessMulti16_ZPM",
                trans("eM_dynamoWirelessMulti16_ZPM"),
                7,
                16).getStackForm(1L));
        eM_dynamoWirelessMulti64_ZPM.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25095,
                "eM_dynamoWirelessMulti64_ZPM",
                trans("eM_dynamoWirelessMulti64_ZPM"),
                7,
                64).getStackForm(1L));
        eM_dynamoWirelessTunnel1_ZPM.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25096,
                "eM_dynamoWirelessTunnel1_ZPM",
                trans("eM_dynamoWirelessTunnel1_ZPM"),
                7,
                256).getStackForm(1L));
        eM_dynamoWirelessTunnel2_ZPM.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25097,
                "eM_dynamoWirelessTunnel2_ZPM",
                trans("eM_dynamoWirelessTunnel2_ZPM"),
                7,
                1024).getStackForm(1L));
        eM_dynamoWirelessTunnel3_ZPM.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25098,
                "eM_dynamoWirelessTunnel3_ZPM",
                trans("eM_dynamoWirelessTunnel3_ZPM"),
                7,
                4096).getStackForm(1L));
        eM_dynamoWirelessTunnel4_ZPM.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25099,
                "eM_dynamoWirelessTunnel4_ZPM",
                trans("eM_dynamoWirelessTunnel4_ZPM"),
                7,
                16384).getStackForm(1L));
        eM_dynamoWirelessTunnel5_ZPM.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25100,
                "eM_dynamoWirelessTunnel5_ZPM",
                trans("eM_dynamoWirelessTunnel5_ZPM"),
                7,
                65536).getStackForm(1L));
        eM_dynamoWirelessTunnel6_ZPM.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25101,
                "eM_dynamoWirelessTunnel6_ZPM",
                trans("eM_dynamoWirelessTunnel6_ZPM"),
                7,
                262144).getStackForm(1L));
        eM_dynamoWirelessTunnel7_ZPM.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25102,
                "eM_dynamoWirelessTunnel7_ZPM",
                trans("eM_dynamoWirelessTunnel7_ZPM"),
                7,
                1048576).getStackForm(1L));
        eM_dynamoWirelessMulti4_UV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25103,
                "eM_dynamoWirelessMulti4_UV",
                trans("eM_dynamoWirelessMulti4_UV"),
                8,
                4).getStackForm(1L));
        eM_dynamoWirelessMulti16_UV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25104,
                "eM_dynamoWirelessMulti16_UV",
                trans("eM_dynamoWirelessMulti16_UV"),
                8,
                16).getStackForm(1L));
        eM_dynamoWirelessMulti64_UV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25105,
                "eM_dynamoWirelessMulti64_UV",
                trans("eM_dynamoWirelessMulti64_UV"),
                8,
                64).getStackForm(1L));
        eM_dynamoWirelessTunnel1_UV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25106,
                "eM_dynamoWirelessTunnel1_UV",
                trans("eM_dynamoWirelessTunnel1_UV"),
                8,
                256).getStackForm(1L));
        eM_dynamoWirelessTunnel2_UV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25107,
                "eM_dynamoWirelessTunnel2_UV",
                trans("eM_dynamoWirelessTunnel2_UV"),
                8,
                1024).getStackForm(1L));
        eM_dynamoWirelessTunnel3_UV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25108,
                "eM_dynamoWirelessTunnel3_UV",
                trans("eM_dynamoWirelessTunnel3_UV"),
                8,
                4096).getStackForm(1L));
        eM_dynamoWirelessTunnel4_UV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25109,
                "eM_dynamoWirelessTunnel4_UV",
                trans("eM_dynamoWirelessTunnel4_UV"),
                8,
                16384).getStackForm(1L));
        eM_dynamoWirelessTunnel5_UV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25110,
                "eM_dynamoWirelessTunnel5_UV",
                trans("eM_dynamoWirelessTunnel5_UV"),
                8,
                65536).getStackForm(1L));
        eM_dynamoWirelessTunnel6_UV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25111,
                "eM_dynamoWirelessTunnel6_UV",
                trans("eM_dynamoWirelessTunnel6_UV"),
                8,
                262144).getStackForm(1L));
        eM_dynamoWirelessTunnel7_UV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25112,
                "eM_dynamoWirelessTunnel7_UV",
                trans("eM_dynamoWirelessTunnel7_UV"),
                8,
                1048576).getStackForm(1L));
        eM_dynamoWirelessMulti4_UHV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25113,
                "eM_dynamoWirelessMulti4_UHV",
                trans("eM_dynamoWirelessMulti4_UHV"),
                9,
                4).getStackForm(1L));
        eM_dynamoWirelessMulti16_UHV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25114,
                "eM_dynamoWirelessMulti16_UHV",
                trans("eM_dynamoWirelessMulti16_UHV"),
                9,
                16).getStackForm(1L));
        eM_dynamoWirelessMulti64_UHV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25115,
                "eM_dynamoWirelessMulti64_UHV",
                trans("eM_dynamoWirelessMulti64_UHV"),
                9,
                64).getStackForm(1L));
        eM_dynamoWirelessTunnel1_UHV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25116,
                "eM_dynamoWirelessTunnel1_UHV",
                trans("eM_dynamoWirelessTunnel1_UHV"),
                9,
                256).getStackForm(1L));
        eM_dynamoWirelessTunnel2_UHV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25117,
                "eM_dynamoWirelessTunnel2_UHV",
                trans("eM_dynamoWirelessTunnel2_UHV"),
                9,
                1024).getStackForm(1L));
        eM_dynamoWirelessTunnel3_UHV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25118,
                "eM_dynamoWirelessTunnel3_UHV",
                trans("eM_dynamoWirelessTunnel3_UHV"),
                9,
                4096).getStackForm(1L));
        eM_dynamoWirelessTunnel4_UHV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25119,
                "eM_dynamoWirelessTunnel4_UHV",
                trans("eM_dynamoWirelessTunnel4_UHV"),
                9,
                16384).getStackForm(1L));
        eM_dynamoWirelessTunnel5_UHV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25120,
                "eM_dynamoWirelessTunnel5_UHV",
                trans("eM_dynamoWirelessTunnel5_UHV"),
                9,
                65536).getStackForm(1L));
        eM_dynamoWirelessTunnel6_UHV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25121,
                "eM_dynamoWirelessTunnel6_UHV",
                trans("eM_dynamoWirelessTunnel6_UHV"),
                9,
                262144).getStackForm(1L));
        eM_dynamoWirelessTunnel7_UHV.set(
            new GT_Hatch_Wireless_Dynamo_Multi(
                25122,
                "eM_dynamoWirelessTunnel7_UHV",
                trans("eM_dynamoWirelessTunnel7_UHV"),
                9,
                1048576).getStackForm(1L));
    }
}
