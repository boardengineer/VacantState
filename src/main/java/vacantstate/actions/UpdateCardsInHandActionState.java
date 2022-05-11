package vacantstate.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import savestate.actions.ActionState;
import theVacant.actions.UpdateCardsInHandAction;

public class UpdateCardsInHandActionState implements ActionState {
    @Override
    public AbstractGameAction loadAction() {
        return new UpdateCardsInHandAction();
    }
}
