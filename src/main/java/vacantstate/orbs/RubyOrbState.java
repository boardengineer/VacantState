package vacantstate.orbs;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import ludicrousspeed.LudicrousSpeedMod;
import savestate.orbs.OrbState;
import theVacant.orbs.AbstractGemOrb;
import theVacant.orbs.RubyOrb;

public class RubyOrbState extends OrbState {
    public RubyOrbState(AbstractOrb orb) {
        super(orb);
    }

    public RubyOrbState(String jsonString) {
        super(jsonString);
    }

    @Override
    public AbstractOrb loadOrb() {
        RubyOrb result = new RubyOrb(passiveAmount);

        result.evokeAmount = evokeAmount;

        ReflectionHacks.setPrivate(result, AbstractOrb.class, "baseEvokeAmount", baseEvokeAmount);
        ReflectionHacks
                .setPrivate(result, AbstractOrb.class, "basePassiveAmount", basePassiveAmount);

        return result;
    }
}
