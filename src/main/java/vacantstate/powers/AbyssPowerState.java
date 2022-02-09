package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.AbyssPower;

public class AbyssPowerState extends PowerState {
    public AbyssPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new AbyssPower(targetAndSource, targetAndSource, amount);
    }
}
