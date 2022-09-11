package vacantstate.actions;

import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import savestate.actions.ActionState;
import theVacant.actions.VacantMillAction;

public class VacantMillActionState implements ActionState {
    private final int amount;
    private final boolean gainBlockForMill;

    public VacantMillActionState(AbstractGameAction action) {
        this.amount = action.amount;
        this.gainBlockForMill = ReflectionHacks
                .getPrivate(action, VacantMillAction.class, "gainBlockForMill");
    }

    @Override
    public AbstractGameAction loadAction() {
        return new VacantMillAction(amount);
    }
}
