package vacantstate.orbs;

import com.google.gson.JsonObject;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.DiamondOrb;

public class DiamondOrbState extends OrbState {
    public DiamondOrbState(AbstractOrb orb) {
        super(orb);
    }

    public DiamondOrbState(String jsonString) {
        super(jsonString);
    }

    public DiamondOrbState(JsonObject orbJson) {
        super(orbJson);
    }

    @Override
    public AbstractOrb loadOrb() {
        DiamondOrb result = new DiamondOrb(basePassiveAmount);

        return result;
    }
}
