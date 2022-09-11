package vacantstate.orbs;

import com.google.gson.JsonObject;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.AmethystOrb;
import vacantstate.VacantState;

public class AmethystOrbState extends OrbState {
    public AmethystOrbState(AbstractOrb orb) {
        super(orb);
    }

    public AmethystOrbState(String jsonString) {
        super(jsonString);
    }

    public AmethystOrbState(JsonObject orbJson) {
        super(orbJson);
    }

    @Override
    public AbstractOrb loadOrb() {
        AmethystOrb result = new AmethystOrb(basePassiveAmount - VacantState.getBonusSize());
        return result;
    }
}
