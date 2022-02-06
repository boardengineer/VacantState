package vacantstate;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

@SpireInitializer
public class VacantState implements PostInitializeSubscriber, EditRelicsSubscriber, EditCharactersSubscriber {
    public static void initialize() {
        BaseMod.subscribe(new vacantstate.VacantState());
    }

    @Override
    public void receivePostInitialize() {
    }

    private void populateCurrentActionsFactory() {
    }

    private void populateCardFactories() {
    }

    private void populatePowerFactory() {
    }

    @Override
    public void receiveEditRelics() {
    }

    @Override
    public void receiveEditCharacters() {
    }
}