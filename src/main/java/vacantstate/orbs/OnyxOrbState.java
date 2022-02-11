package vacantstate.orbs;

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
        OnyxOrb result = new OnyxOrb(basePassiveAmount);

        return result;
    }
}
