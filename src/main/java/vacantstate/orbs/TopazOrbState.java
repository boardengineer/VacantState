package vacantstate.orbs;

import com.google.gson.JsonObject;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.TopazOrb;
import vacantstate.VacantState;

public class TopazOrbState extends OrbState {

    public TopazOrbState(AbstractOrb orb) {
        super(orb);
    }

    public TopazOrbState(String jsonString) {
        super(jsonString);
    }

    public TopazOrbState(JsonObject orbJson) {
        super(orbJson);
    }

    @Override
    public AbstractOrb loadOrb() {
        TopazOrb result = new TopazOrb(basePassiveAmount - VacantState.getBonusSize());

        return result;
    }
}
