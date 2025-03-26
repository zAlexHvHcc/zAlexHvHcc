/*
 * Decompiled with CFR 0.151.
 */
package espada.spacex.aurora.modules.automine;

public static final class AuroraMine.MineType
extends Enum<AuroraMine.MineType> {
    public static final /* enum */ AuroraMine.MineType Cev = new AuroraMine.MineType();
    public static final /* enum */ AuroraMine.MineType TrapCev = new AuroraMine.MineType();
    public static final /* enum */ AuroraMine.MineType SurroundCev = new AuroraMine.MineType();
    public static final /* enum */ AuroraMine.MineType SurroundMiner = new AuroraMine.MineType();
    public static final /* enum */ AuroraMine.MineType AutoCity = new AuroraMine.MineType();
    public static final /* enum */ AuroraMine.MineType AntiBurrow = new AuroraMine.MineType();
    public static final /* enum */ AuroraMine.MineType Manual = new AuroraMine.MineType();
    private static final /* synthetic */ AuroraMine.MineType[] $VALUES;

    public static AuroraMine.MineType[] values() {
        return (AuroraMine.MineType[])$VALUES.clone();
    }

    public static AuroraMine.MineType valueOf(String name) {
        return Enum.valueOf(AuroraMine.MineType.class, name);
    }

    private static /* synthetic */ AuroraMine.MineType[] $values() {
        return new AuroraMine.MineType[]{Cev, TrapCev, SurroundCev, SurroundMiner, AutoCity, AntiBurrow, Manual};
    }

    static {
        $VALUES = AuroraMine.MineType.$values();
    }
}
