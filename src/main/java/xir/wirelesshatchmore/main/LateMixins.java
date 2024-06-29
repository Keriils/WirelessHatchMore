package xir.wirelesshatchmore.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class LateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.wirelesshatchmore.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        ArrayList<String> mixins = new ArrayList<>();
        if (loadedMods.contains("gregtech")) {
            mixins.add("EOH_getStoredFluid_Mixin");
            mixins.add("EOH_drainFluid_Mixin");
        }
        return mixins;
    }
}
