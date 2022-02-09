package vacantstate.orbs;

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
        return new AmethystOrb(passiveAmount);
    }
}
