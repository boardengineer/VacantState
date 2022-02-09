package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.ImmaterializePower;

public class ImmaterializePowerState extends PowerState {
    public ImmaterializePowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new ImmaterializePower(targetAndSource, targetAndSource, amount);
    }
}
