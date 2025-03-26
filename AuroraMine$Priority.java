/*
 * Decompiled with CFR 0.151.
 */
package espada.spacex.aurora.modules.automine;

public static final class AuroraMine.Priority
extends Enum<AuroraMine.Priority> {
    public static final /* enum */ AuroraMine.Priority Highest = new AuroraMine.Priority(6);
    public static final /* enum */ AuroraMine.Priority Higher = new AuroraMine.Priority(5);
    public static final /* enum */ AuroraMine.Priority High = new AuroraMine.Priority(4);
    public static final /* enum */ AuroraMine.Priority Normal = new AuroraMine.Priority(3);
    public static final /* enum */ AuroraMine.Priority Low = new AuroraMine.Priority(2);
    public static final /* enum */ AuroraMine.Priority Lower = new AuroraMine.Priority(1);
    public static final /* enum */ AuroraMine.Priority Lowest = new AuroraMine.Priority(0);
    public static final /* enum */ AuroraMine.Priority Disabled = new AuroraMine.Priority(-1);
    public final int priority;
    private static final /* synthetic */ AuroraMine.Priority[] $VALUES;

    public static AuroraMine.Priority[] values() {
        return (AuroraMine.Priority[])$VALUES.clone();
    }

    public static AuroraMine.Priority valueOf(String name) {
        return Enum.valueOf(AuroraMine.Priority.class, name);
    }

    private AuroraMine.Priority(int priority) {
        this.priority = priority;
    }

    private static /* synthetic */ AuroraMine.Priority[] $values() {
        return new AuroraMine.Priority[]{Highest, Higher, High, Normal, Low, Lower, Lowest, Disabled};
    }

    static {
        $VALUES = AuroraMine.Priority.$values();
    }
}
