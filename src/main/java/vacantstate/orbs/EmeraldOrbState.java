package vacantstate.orbs;

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

    @Override
    public AbstractOrb loadOrb() {
        return new EmeraldOrb(passiveAmount);
    }

}
