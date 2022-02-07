package vacantstate;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import savestate.CardState;
import savestate.StateFactories;
import savestate.powers.PowerState;
import theVacant.cards.AbstractVacantCard;
import theVacant.powers.*;
import vacantstate.cards.AbstractVacantCardState;
import vacantstate.powers.*;

import java.util.Optional;

@SpireInitializer
public class VacantState implements PostInitializeSubscriber, EditRelicsSubscriber, EditCharactersSubscriber {
    public static void initialize() {
        BaseMod.subscribe(new vacantstate.VacantState());
    }

    @Override
    public void receivePostInitialize() {
        populateCardFactories();
        populatePowerFactory();
    }

    private void populateCurrentActionsFactory() {
    }

    private void populateCardFactories() {
        CardState.CardFactories cardFactories = new CardState.CardFactories(card -> {
            if (card instanceof AbstractVacantCard) {
                return Optional.of(new AbstractVacantCardState(card));
            }
            return Optional.empty();
        }, json -> {
            JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();
            String type = "";
            if (parsed.has("type")) {
                type = parsed.get("type").getAsString();
            }
            if (type.equals(AbstractVacantCardState.TYPE_KEY)) {
                return Optional.of(new AbstractVacantCardState(json));
            }
            return Optional.empty();
        });

        StateFactories.cardFactories.add(cardFactories);
    }

    private void populatePowerFactory() {
        StateFactories.powerByIdMap
                .put(AquamarinePower.POWER_ID, new PowerState.PowerFactories(power -> new AquamarinePowerState(power)));
        StateFactories.powerByIdMap
                .put(BurdenBreakPower.POWER_ID, new PowerState.PowerFactories(power -> new BurdenBreakPowerState(power)));
        StateFactories.powerByIdMap
                .put(CleanseSoulPower.POWER_ID, new PowerState.PowerFactories(power -> new CleanseSoulPowerState(power)));
        StateFactories.powerByIdMap
                .put(DoomPower.POWER_ID, new PowerState.PowerFactories(power -> new DoomPowerState(power)));
        StateFactories.powerByIdMap
                .put(GloomPower.POWER_ID, new PowerState.PowerFactories(power -> new GloomPowerState(power)));
        StateFactories.powerByIdMap
                .put(MemoriaPower.POWER_ID, new PowerState.PowerFactories(power -> new MemoriaPowerState(power)));
        StateFactories.powerByIdMap
                .put(ReapPower.POWER_ID, new PowerState.PowerFactories(power -> new ReapPowerState(power)));
        StateFactories.powerByIdMap
                .put(RecoverPower.POWER_ID, new PowerState.PowerFactories(power -> new RecoverPowerState(power)));
        StateFactories.powerByIdMap
                .put(RunicThoughtsPower.POWER_ID, new PowerState.PowerFactories(power -> new RunicThoughtsPowerState(power)));
        StateFactories.powerByIdMap
                .put(StandoPower.POWER_ID, new PowerState.PowerFactories(power -> new StandoPowerState(power)));
        StateFactories.powerByIdMap
                .put(TemperancePower.POWER_ID, new PowerState.PowerFactories(power -> new TemperancePowerState(power)));
        StateFactories.powerByIdMap
                .put(VoidEmbracePower.POWER_ID, new PowerState.PowerFactories(power -> new VoidEmbracePowerState(power)));
        StateFactories.powerByIdMap
                .put(VoidPower.POWER_ID, new PowerState.PowerFactories(power -> new VoidPowerState(power)));
    }

    @Override
    public void receiveEditRelics() {
    }

    @Override
    public void receiveEditCharacters() {
    }
}