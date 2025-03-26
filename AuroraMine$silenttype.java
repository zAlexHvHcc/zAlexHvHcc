/*
 * Decompiled with CFR 0.151.
 */
package espada.spacex.aurora.modules.automine;

public static final class AuroraMine.silenttype
extends Enum<AuroraMine.silenttype> {
    public static final /* enum */ AuroraMine.silenttype UpdateSelectedSlotC2SPacket = new AuroraMine.silenttype();
    public static final /* enum */ AuroraMine.silenttype selectedSlot = new AuroraMine.silenttype();
    public static final /* enum */ AuroraMine.silenttype ClientselectedSwap = new AuroraMine.silenttype();
    private static final /* synthetic */ AuroraMine.silenttype[] $VALUES;

    public static AuroraMine.silenttype[] values() {
        return (AuroraMine.silenttype[])$VALUES.clone();
    }

    public static AuroraMine.silenttype valueOf(String name) {
        return Enum.valueOf(AuroraMine.silenttype.class, name);
    }

    private static /* synthetic */ AuroraMine.silenttype[] $values() {
        return new AuroraMine.silenttype[]{UpdateSelectedSlotC2SPacket, selectedSlot, ClientselectedSwap};
    }

    static {
        $VALUES = AuroraMine.silenttype.$values();
    }
}
