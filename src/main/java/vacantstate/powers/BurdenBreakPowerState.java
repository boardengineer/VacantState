package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.BurdenBreakPower;

public class BurdenBreakPowerState extends PowerState {
    public BurdenBreakPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new BurdenBreakPower(targetAndSource, targetAndSource, amount);
    }
}
