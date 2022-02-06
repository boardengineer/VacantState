package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.RunicThoughtsPower;

public class RunicThoughtsPowerState extends PowerState {
    public RunicThoughtsPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new RunicThoughtsPower(targetAndSource, targetAndSource, amount);
    }
}
