package vacantstate.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import savestate.SaveStateMod;
import theVacant.relics.OverflowingGobletRelic;

public class RelicDescriptionPatches {
    @SpirePatch(clz = OverflowingGobletRelic.class, method = "updateDescription")
    public static class GobletNoDescUpdatePatch {
        @SpirePrefixPatch
        public static SpireReturn doNothing(OverflowingGobletRelic relic) {
            if (SaveStateMod.shouldGoFast) {
                return SpireReturn.Return(null);
            }
            return SpireReturn.Continue();
        }
    }
}
