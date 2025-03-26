/*
 * Decompiled with CFR 0.151.
 */
package espada.spacex.aurora.modules.automine;

public static final class AuroraMine.ListMode
extends Enum<AuroraMine.ListMode> {
    public static final /* enum */ AuroraMine.ListMode Whitelist = new AuroraMine.ListMode();
    public static final /* enum */ AuroraMine.ListMode Blacklist = new AuroraMine.ListMode();
    private static final /* synthetic */ AuroraMine.ListMode[] $VALUES;

    public static AuroraMine.ListMode[] values() {
        return (AuroraMine.ListMode[])$VALUES.clone();
    }

    public static AuroraMine.ListMode valueOf(String name) {
        return Enum.valueOf(AuroraMine.ListMode.class, name);
    }

    private static /* synthetic */ AuroraMine.ListMode[] $values() {
        return new AuroraMine.ListMode[]{Whitelist, Blacklist};
    }

    static {
        $VALUES = AuroraMine.ListMode.$values();
    }
}
