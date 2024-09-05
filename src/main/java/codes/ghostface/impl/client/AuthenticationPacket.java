package codes.ghostface.impl.client;

import codes.ghostface.models.Email;
import codes.ghostface.providers.AbstractClientPacket;
import codes.ghostface.type.ClientPacketType;
import codes.ghostface.utils.PacketUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

public final class AuthenticationPacket extends AbstractClientPacket {

    private final @NotNull Email email;
    private final @NotNull String password;
    private final @NotNull OffsetDateTime time;

    public AuthenticationPacket(@NotNull Email email, @NotNull String password) {
        super(ClientPacketType.AUTHENTICATION, new JsonObject(), PacketUtils.getInstance());
        this.email = email;
        this.password = password;
        this.time = OffsetDateTime.now();
        values.addProperty("type", getType().getDescription());
        values.addProperty("email", email.toString());
        values.addProperty("password", password);
        values.addProperty("time", time.toString());
    }

    // Getters

    public @NotNull Email getEmail() {
        return email;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public @NotNull OffsetDateTime getTime() {
        return time;
    }

    @Override
    public @NotNull JsonElement getValues() {
        @NotNull JsonObject element = new JsonObject();
        element.add("value", values);
        return element;
    }
}
