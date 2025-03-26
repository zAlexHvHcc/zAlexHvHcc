/*
 * Decompiled with CFR 0.151.
 */
package espada.spacex.aurora.modules.automine;

import espada.spacex.aurora.modules.automine.AuroraMine;

static class AuroraMine.1 {
    static final /* synthetic */ int[] $SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$RenderMode;
    static final /* synthetic */ int[] $SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$SwitchMode;
    static final /* synthetic */ int[] $SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$MineType;

    static {
        $SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$MineType = new int[AuroraMine.MineType.values().length];
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$MineType[AuroraMine.MineType.Cev.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$MineType[AuroraMine.MineType.TrapCev.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$MineType[AuroraMine.MineType.SurroundCev.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$MineType[AuroraMine.MineType.AutoCity.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$MineType[AuroraMine.MineType.SurroundMiner.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$MineType[AuroraMine.MineType.AntiBurrow.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$MineType[AuroraMine.MineType.Manual.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        $SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$SwitchMode = new int[AuroraMine.SwitchMode.values().length];
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$SwitchMode[AuroraMine.SwitchMode.Silent.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$SwitchMode[AuroraMine.SwitchMode.PickSilent.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$SwitchMode[AuroraMine.SwitchMode.InvSwitch.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        $SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$RenderMode = new int[AuroraMine.RenderMode.values().length];
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$RenderMode[AuroraMine.RenderMode.Box.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$RenderMode[AuroraMine.RenderMode.Normal.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$RenderMode[AuroraMine.RenderMode.Future.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$RenderMode[AuroraMine.RenderMode.Shrink.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            AuroraMine.1.$SwitchMap$espada$spacex$aurora$modules$automine$AuroraMine$RenderMode[AuroraMine.RenderMode.Grow.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
