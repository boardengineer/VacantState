package vacantstate.orbs;

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
        SapphireOrb result = new SapphireOrb(basePassiveAmount);

        return result;
    }
}
