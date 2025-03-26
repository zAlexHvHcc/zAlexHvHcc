/*
 * Decompiled with CFR 0.151.
 */
package espada.spacex.aurora.modules.automine;

public static final class AuroraMine.RenderMode
extends Enum<AuroraMine.RenderMode> {
    public static final /* enum */ AuroraMine.RenderMode Box = new AuroraMine.RenderMode();
    public static final /* enum */ AuroraMine.RenderMode Normal = new AuroraMine.RenderMode();
    public static final /* enum */ AuroraMine.RenderMode Future = new AuroraMine.RenderMode();
    public static final /* enum */ AuroraMine.RenderMode Shrink = new AuroraMine.RenderMode();
    public static final /* enum */ AuroraMine.RenderMode Grow = new AuroraMine.RenderMode();
    private static final /* synthetic */ AuroraMine.RenderMode[] $VALUES;

    public static AuroraMine.RenderMode[] values() {
        return (AuroraMine.RenderMode[])$VALUES.clone();
    }

    public static AuroraMine.RenderMode valueOf(String name) {
        return Enum.valueOf(AuroraMine.RenderMode.class, name);
    }

    private static /* synthetic */ AuroraMine.RenderMode[] $values() {
        return new AuroraMine.RenderMode[]{Box, Normal, Future, Shrink, Grow};
    }

    static {
        $VALUES = AuroraMine.RenderMode.$values();
    }
}
