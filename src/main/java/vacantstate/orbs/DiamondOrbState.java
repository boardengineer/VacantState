package vacantstate.orbs;

import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.DiamondOrb;

public class DiamondOrbState extends OrbState {
    public DiamondOrbState(AbstractOrb orb) {
        super(orb);
    }

    public DiamondOrbState(String jsonString) {
        super(jsonString);
    }

    @Override
    public AbstractOrb loadOrb() {
        DiamondOrb result = new DiamondOrb(passiveAmount);

        result.evokeAmount = evokeAmount;

        ReflectionHacks.setPrivate(result, AbstractOrb.class, "baseEvokeAmount", baseEvokeAmount);
        ReflectionHacks
                .setPrivate(result, AbstractOrb.class, "basePassiveAmount", basePassiveAmount);

        result.applyFocus();

        return result;
    }
}
