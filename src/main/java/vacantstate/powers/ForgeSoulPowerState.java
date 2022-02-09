package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.ForgeSoulPower;

public class ForgeSoulPowerState extends PowerState {
    public ForgeSoulPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new ForgeSoulPower(targetAndSource, targetAndSource, amount);
    }
}
