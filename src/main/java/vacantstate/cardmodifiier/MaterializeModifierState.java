package vacantstate.cardmodifiier;

import basemod.ReflectionHacks;
import basemod.abstracts.AbstractCardModifier;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import savestate.AbstractCardModifierState;
import theVacant.cards.Modifiers.MaterializeModifier;

public class MaterializeModifierState extends AbstractCardModifierState {
    int amount;

    public MaterializeModifierState(AbstractCardModifier modifier) {
        super(modifier);

        this.amount = ReflectionHacks.getPrivate(modifier, MaterializeModifier.class, "amount");
    }

    public MaterializeModifierState(String jsonString) {
        super(jsonString);

        JsonObject parsed = new JsonParser().parse(jsonString).getAsJsonObject();

        this.amount = parsed.get("amount").getAsInt();
    }

    public MaterializeModifierState(JsonObject modifierJson) {
        super(modifierJson);

        this.amount = modifierJson.get("amount").getAsInt();
    }

    @Override
    public AbstractCardModifier loadModifier() {
        return new MaterializeModifier(amount);
    }

    @Override
    public String encode() {
        JsonObject parsed = new JsonParser().parse(super.encode()).getAsJsonObject();

        parsed.addProperty("amount", amount);

        return parsed.toString();
    }

    @Override
    public JsonObject jsonEncode() {
        JsonObject result = super.jsonEncode();

        result.addProperty("amount", amount);

        return result;
    }
}
