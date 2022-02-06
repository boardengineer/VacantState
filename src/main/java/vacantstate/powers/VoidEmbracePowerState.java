package vacantstate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import savestate.powers.PowerState;
import theVacant.powers.VoidEmbracePower;

public class VoidEmbracePowerState extends PowerState {
    public VoidEmbracePowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new VoidEmbracePower(targetAndSource, targetAndSource, amount);
    }
}
