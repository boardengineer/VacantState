package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.InvisibleGemOrbPower;

public class InvisibleGemOrbPowerState extends PowerState {
    public InvisibleGemOrbPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new InvisibleGemOrbPower(targetAndSource, targetAndSource, amount);
    }
}
