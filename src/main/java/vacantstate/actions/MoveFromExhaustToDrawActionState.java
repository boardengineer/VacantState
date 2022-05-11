package vacantstate.actions;

import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import savestate.CardState;
import savestate.actions.ActionState;
import theVacant.actions.MoveFromExhaustToDrawAction;

public class MoveFromExhaustToDrawActionState implements ActionState {
    private final int cardIndex;

    public MoveFromExhaustToDrawActionState(AbstractGameAction action) {
        AbstractCard card = ReflectionHacks
                .getPrivate(action, MoveFromExhaustToDrawAction.class, "card");

        cardIndex = CardState.indexForCard(card);
    }

    @Override
    public AbstractGameAction loadAction() {
        return new MoveFromExhaustToDrawAction(CardState.cardForIndex(cardIndex));
    }
}
