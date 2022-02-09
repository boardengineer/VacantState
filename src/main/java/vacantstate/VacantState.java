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
import savestate.orbs.OrbState;
import savestate.powers.PowerState;
import theVacant.cards.AbstractVacantCard;
import theVacant.cards.Powers.Immaterialize;
import theVacant.cards.Skills.Enchant;
import theVacant.orbs.*;
import theVacant.powers.*;
import vacantstate.cards.AbstractVacantCardState;
import vacantstate.orbs.*;
import vacantstate.powers.*;

import java.util.Optional;

import static theVacant.characters.TheVacant.Enums.COLOR_GOLD;

@SpireInitializer
public class VacantState implements PostInitializeSubscriber, EditRelicsSubscriber, EditCardsSubscriber {
    public static void initialize() {
        BaseMod.subscribe(new vacantstate.VacantState());
    }

    @Override
    public void receivePostInitialize() {
        populateCardFactories();
        populatePowerFactory();

        populateOrbFactories();
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

    private void populateOrbFactories() {
        StateFactories.orbByClassMap
                .put(AmethystOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new AmethystOrbState(orb), json -> new AmethystOrbState(json)));
        StateFactories.orbByClassMap
                .put(DiamondOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new DiamondOrbState(orb), json -> new DiamondOrbState(json)));
        StateFactories.orbByClassMap
                .put(RubyOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new RubyOrbState(orb), json -> new RubyOrbState(json)));
        StateFactories.orbByClassMap
                .put(EmeraldOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new EmeraldOrbState(orb), json -> new EmeraldOrbState(json)));
        StateFactories.orbByClassMap
                .put(OpalOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new OpalOrbState(orb), json -> new OpalOrbState(json)));
        StateFactories.orbByClassMap
                .put(SapphireOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new SapphireOrbState(orb), json -> new SapphireOrbState(json)));
    }

    private void populatePowerFactory() {
        StateFactories.powerByIdMap
                .put(AbyssPower.POWER_ID, new PowerState.PowerFactories(power -> new AbyssPowerState(power)));
        StateFactories.powerByIdMap
                .put(AquamarinePower.POWER_ID, new PowerState.PowerFactories(power -> new AquamarinePowerState(power)));
        StateFactories.powerByIdMap
                .put(BurdenBreakPower.POWER_ID, new PowerState.PowerFactories(power -> new BurdenBreakPowerState(power)));
        StateFactories.powerByIdMap
                .put(CleanseSoulPower.POWER_ID, new PowerState.PowerFactories(power -> new CleanseSoulPowerState(power)));
        StateFactories.powerByIdMap
                .put(DoomPower.POWER_ID, new PowerState.PowerFactories(power -> new DoomPowerState(power)));
        StateFactories.powerByIdMap
                .put(ForgeSoulPower.POWER_ID, new PowerState.PowerFactories(power -> new ForgeSoulPowerState(power)));
        StateFactories.powerByIdMap
                .put(GloomPower.POWER_ID, new PowerState.PowerFactories(power -> new GloomPowerState(power)));
        StateFactories.powerByIdMap
                .put(InvisibleGemOrbPower.POWER_ID, new PowerState.PowerFactories(power -> new InvisibleGemOrbPowerState(power)));
        StateFactories.powerByIdMap
                .put(MemoriaPower.POWER_ID, new PowerState.PowerFactories(power -> new MemoriaPowerState(power)));
        StateFactories.powerByIdMap
                .put(PickaxePower.POWER_ID, new PowerState.PowerFactories(power -> new PickaxePowerState(power)));
        StateFactories.powerByIdMap
                .put(ReapPower.POWER_ID, new PowerState.PowerFactories(power -> new ReapPowerState(power)));
        StateFactories.powerByIdMap
                .put(RecoverPower.POWER_ID, new PowerState.PowerFactories(power -> new RecoverPowerState(power)));
        StateFactories.powerByIdMap
                .put(RunicThoughtsPower.POWER_ID, new PowerState.PowerFactories(power -> new RunicThoughtsPowerState(power)));
        StateFactories.powerByIdMap
                .put(ShroudPower.POWER_ID, new PowerState.PowerFactories(power -> new ShroudPowerState(power)));
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

        // Need support for card modifier
        BaseMod.removeCard(Immaterialize.ID, COLOR_GOLD);
        BaseMod.removeCard(Enchant.ID, COLOR_GOLD);
    }
}