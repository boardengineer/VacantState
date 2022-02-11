package vacantstate.orbs;

import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.OpalOrb;

public class OpalOrbState extends OrbState {
    public OpalOrbState(AbstractOrb orb) {
        super(orb);
    }

    public OpalOrbState(String jsonString) {
        super(jsonString);
    }

    @Override
    public AbstractOrb loadOrb() {
        OpalOrb result = new OpalOrb(basePassiveAmount);
        return result;
    }
}
