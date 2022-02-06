package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.VoidPower;

public class VoidPowerState extends PowerState {
    public VoidPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new VoidPower(targetAndSource, targetAndSource, amount);
    }
}
