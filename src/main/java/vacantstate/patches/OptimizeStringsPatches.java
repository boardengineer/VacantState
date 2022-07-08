package vacantstate.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import savestate.SaveStateMod;
import theVacant.relics.BrassGoblet;

public class OptimizeStringsPatches {
    @SpirePatch(clz = BrassGoblet.class, method = "setDescriptionWithCard")
    public static class BrassGobleDescriptionPatch {
        @SpirePrefixPatch
        public static SpireReturn doNothing(BrassGoblet brassGoblet) {
            if (SaveStateMod.shouldGoFast) {
                return SpireReturn.Return(null);
            }

            return SpireReturn.Continue();
        }
    }
}
