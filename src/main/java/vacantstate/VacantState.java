package vacantstate;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import savestate.StateFactories;
import savestate.powers.PowerState;
import theVacant.powers.*;
import vacantstate.powers.*;

@SpireInitializer
public class VacantState implements PostInitializeSubscriber, EditRelicsSubscriber, EditCharactersSubscriber {
    public static void initialize() {
        BaseMod.subscribe(new vacantstate.VacantState());
    }

    @Override
    public void receivePostInitialize() {
        populatePowerFactory();
    }

    private void populateCurrentActionsFactory() {
    }

    private void populateCardFactories() {
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