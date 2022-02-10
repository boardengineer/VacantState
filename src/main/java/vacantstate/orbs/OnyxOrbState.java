package vacantstate.orbs;

import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.OnyxOrb;

public class OnyxOrbState extends OrbState {
    public OnyxOrbState(AbstractOrb orb) {
        super(orb);
    }

    public OnyxOrbState(String jsonString) {
        super(jsonString);
    }

    @Override
    public AbstractOrb loadOrb() {
        OnyxOrb result = new OnyxOrb(passiveAmount);

        result.evokeAmount = evokeAmount;

        ReflectionHacks.setPrivate(result, AbstractOrb.class, "baseEvokeAmount", baseEvokeAmount);
        ReflectionHacks
                .setPrivate(result, AbstractOrb.class, "basePassiveAmount", basePassiveAmount);

        result.applyFocus();

        return result;
    }
}
