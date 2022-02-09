package vacantstate.orbs;

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

    @Override
    public AbstractOrb loadOrb() {
        return new RubyOrb(passiveAmount);
    }
}
