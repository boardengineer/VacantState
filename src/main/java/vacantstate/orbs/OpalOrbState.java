package vacantstate.orbs;

import com.google.gson.JsonObject;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.OpalOrb;
import vacantstate.VacantState;

public class OpalOrbState extends OrbState {
    public OpalOrbState(AbstractOrb orb) {
        super(orb);
    }

    public OpalOrbState(String jsonString) {
        super(jsonString);
    }

    public OpalOrbState(JsonObject orbJson) {
        super(orbJson);
    }

    @Override
    public AbstractOrb loadOrb() {
        OpalOrb result = new OpalOrb(basePassiveAmount - VacantState.getBonusSize());
        return result;
    }
}
