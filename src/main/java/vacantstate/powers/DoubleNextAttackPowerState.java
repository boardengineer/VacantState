package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.DoubleNextAttackPower;

public class DoubleNextAttackPowerState extends PowerState {
    public DoubleNextAttackPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new DoubleNextAttackPower(targetAndSource, targetAndSource, amount);
    }
}
