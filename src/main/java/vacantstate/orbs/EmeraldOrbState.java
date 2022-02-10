package vacantstate.orbs;

import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.EmeraldOrb;

public class EmeraldOrbState extends OrbState {
    public EmeraldOrbState(AbstractOrb orb) {
        super(orb);
    }

    public EmeraldOrbState(String jsonString) {
        super(jsonString);
    }

    @Override
    public AbstractOrb loadOrb() {
        EmeraldOrb result = new EmeraldOrb(passiveAmount);

        result.evokeAmount = evokeAmount;

        ReflectionHacks.setPrivate(result, AbstractOrb.class, "baseEvokeAmount", baseEvokeAmount);
        ReflectionHacks
                .setPrivate(result, AbstractOrb.class, "basePassiveAmount", basePassiveAmount);

        result.applyFocus();

        return result;
    }

}
