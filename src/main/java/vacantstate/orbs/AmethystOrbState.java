package vacantstate.orbs;

import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.AmethystOrb;

public class AmethystOrbState extends OrbState {
    public AmethystOrbState(AbstractOrb orb) {
        super(orb);
    }

    public AmethystOrbState(String jsonString) {
        super(jsonString);
    }

    @Override
    public AbstractOrb loadOrb() {
        AmethystOrb result = new AmethystOrb(passiveAmount);

        result.evokeAmount = evokeAmount;

        ReflectionHacks.setPrivate(result, AbstractOrb.class, "baseEvokeAmount", baseEvokeAmount);
        ReflectionHacks
                .setPrivate(result, AbstractOrb.class, "basePassiveAmount", basePassiveAmount);

        result.applyFocus();

        return result;
    }
}
