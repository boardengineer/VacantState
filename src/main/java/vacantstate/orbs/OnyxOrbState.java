package vacantstate.orbs;

import com.google.gson.JsonObject;
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

    public OnyxOrbState(JsonObject orbJson) {
        super(orbJson);
    }

    @Override
    public AbstractOrb loadOrb() {
        OnyxOrb result = new OnyxOrb(basePassiveAmount);

        return result;
    }
}
