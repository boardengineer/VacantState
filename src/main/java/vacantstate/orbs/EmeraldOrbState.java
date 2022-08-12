package vacantstate.orbs;

import com.google.gson.JsonObject;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.EmeraldOrb;

public class EmeraldOrbState extends OrbState {
    public EmeraldOrbState(AbstractOrb orb) {
        super(orb);
    }

    public EmeraldOrbState(String jsonString) {
        super(jsonString);
    }

    public EmeraldOrbState(JsonObject orbJson) {
        super(orbJson);
    }

    @Override
    public AbstractOrb loadOrb() {
        EmeraldOrb result = new EmeraldOrb(basePassiveAmount);

        return result;
    }
}
