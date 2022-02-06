package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.StandoPower;

public class StandoPowerState extends PowerState {
    public StandoPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new StandoPower(targetAndSource, targetAndSource, amount);
    }
}
