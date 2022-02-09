package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.ShroudPower;

public class ShroudPowerState extends PowerState {
    public ShroudPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new ShroudPower(targetAndSource, targetAndSource, amount);
    }
}
