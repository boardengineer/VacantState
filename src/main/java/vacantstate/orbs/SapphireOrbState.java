package vacantstate.orbs;

import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.SapphireOrb;

public class SapphireOrbState extends OrbState {
    public SapphireOrbState(AbstractOrb orb) {
        super(orb);
    }

    public SapphireOrbState(String jsonString) {
        super(jsonString);
    }

    @Override
    public AbstractOrb loadOrb() {
        SapphireOrb result = new SapphireOrb(passiveAmount);

        result.evokeAmount = evokeAmount;

        ReflectionHacks.setPrivate(result, AbstractOrb.class, "baseEvokeAmount", baseEvokeAmount);
        ReflectionHacks
                .setPrivate(result, AbstractOrb.class, "basePassiveAmount", basePassiveAmount);

        result.applyFocus();

        return result;
    }
}
