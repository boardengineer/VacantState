package vacantstate;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import savestate.CardState;
import savestate.StateFactories;
import savestate.powers.PowerState;
import theVacant.cards.AbstractVacantCard;
import theVacant.cards.Attacks.*;
import theVacant.cards.Skills.AwMan;
import theVacant.cards.Skills.DiamondIsUnbreakable;
import theVacant.cards.Skills.ShatterAmethyst;
import theVacant.cards.Skills.Spelunk;
import theVacant.cards.archive.Attacks.GildedPickaxe;
import theVacant.cards.archive.Attacks.OnyxBlaster;
import theVacant.cards.archive.Powers.GotOurPickaxe;
import theVacant.cards.archive.Powers.Immaterialize;
import theVacant.cards.archive.Skills.OpalShine;
import theVacant.cards.archive.Skills.RubyRage;
import theVacant.characters.TheVacant;
import theVacant.powers.*;
import vacantstate.cards.AbstractVacantCardState;
import vacantstate.powers.*;

import java.util.Optional;

@SpireInitializer
public class VacantState implements PostInitializeSubscriber, EditRelicsSubscriber, EditCardsSubscriber {
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
    public void receiveEditCards() {
        BaseMod.removeCard(BackInTheMine.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(RubyRage.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(Spelunk.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(AwMan.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(EmeraldSplash.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(Immaterialize.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(OnyxBlaster.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(OpalFracture.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(OpalShine.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(SapphireStrike.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(ShatterAmethyst.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(TopazFrenzy.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(DiamondIsUnbreakable.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(GildedPickaxe.ID, TheVacant.Enums.COLOR_GOLD);
        BaseMod.removeCard(GotOurPickaxe.ID, TheVacant.Enums.COLOR_GOLD);
    }
}