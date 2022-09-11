package vacantstate.orbs;

import com.google.gson.JsonObject;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.SapphireOrb;
import vacantstate.VacantState;

public class SapphireOrbState extends OrbState {
    public SapphireOrbState(AbstractOrb orb) {
        super(orb);
    }

    public SapphireOrbState(String jsonString) {
        super(jsonString);
    }

    public SapphireOrbState(JsonObject orbJson) {
        super(orbJson);
    }

    @Override
    public AbstractOrb loadOrb() {
        SapphireOrb result = new SapphireOrb(basePassiveAmount - VacantState.getBonusSize());

        return result;
    }
}
