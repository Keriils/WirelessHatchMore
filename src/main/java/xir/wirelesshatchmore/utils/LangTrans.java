package xir.wirelesshatchmore.utils;

import static net.minecraft.util.StatCollector.translateToLocal;

public class LangTrans {

    private LangTrans() {}

    public static String trans(String langkey) {
        return translateToLocal(langkey);
    }
}
