package vacantstate.orbs;

import com.google.gson.JsonObject;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.orbs.OrbState;
import theVacant.orbs.RubyOrb;

public class RubyOrbState extends OrbState {
    public RubyOrbState(AbstractOrb orb) {
        super(orb);
    }

    public RubyOrbState(String jsonString) {
        super(jsonString);
    }

    public RubyOrbState(JsonObject orbJson) {
        super(orbJson);
    }

    @Override
    public AbstractOrb loadOrb() {
        RubyOrb result = new RubyOrb(basePassiveAmount);

        return result;
    }
}
