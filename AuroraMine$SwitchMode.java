/*
 * Decompiled with CFR 0.151.
 */
package espada.spacex.aurora.modules.automine;

public static final class AuroraMine.SwitchMode
extends Enum<AuroraMine.SwitchMode> {
    public static final /* enum */ AuroraMine.SwitchMode Silent = new AuroraMine.SwitchMode();
    public static final /* enum */ AuroraMine.SwitchMode PickSilent = new AuroraMine.SwitchMode();
    public static final /* enum */ AuroraMine.SwitchMode InvSwitch = new AuroraMine.SwitchMode();
    private static final /* synthetic */ AuroraMine.SwitchMode[] $VALUES;

    public static AuroraMine.SwitchMode[] values() {
        return (AuroraMine.SwitchMode[])$VALUES.clone();
    }

    public static AuroraMine.SwitchMode valueOf(String name) {
        return Enum.valueOf(AuroraMine.SwitchMode.class, name);
    }

    private static /* synthetic */ AuroraMine.SwitchMode[] $values() {
        return new AuroraMine.SwitchMode[]{Silent, PickSilent, InvSwitch};
    }

    static {
        $VALUES = AuroraMine.SwitchMode.$values();
    }
}
