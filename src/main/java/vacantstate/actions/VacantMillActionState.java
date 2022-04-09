package vacantstate.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import savestate.actions.ActionState;
import theVacant.actions.VacantMillAction;

public class VacantMillActionState implements ActionState {
    private final int amount;

    public VacantMillActionState(AbstractGameAction action) {
        this.amount = action.amount;
    }

    @Override
    public AbstractGameAction loadAction() {
        return new VacantMillAction(amount);
    }
}
