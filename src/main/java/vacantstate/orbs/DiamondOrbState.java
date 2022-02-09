package vacantstate.orbs;

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
        return new DiamondOrb(passiveAmount);
    }
}
