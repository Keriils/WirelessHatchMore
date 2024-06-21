package xir.wirelesshatchmore.utils;

import static net.minecraft.util.StatCollector.translateToLocal;
import static net.minecraft.util.StatCollector.translateToLocalFormatted;

public class LangTrans {

    private LangTrans() {}

    public static String trans(String langkey) {
        return translateToLocal(langkey);
    }
    public static String transFormat(String langkey) {
        return translateToLocalFormatted(langkey);
    }
}
