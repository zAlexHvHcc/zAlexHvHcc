/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  meteordevelopment.meteorclient.events.packets.PacketEvent$Send
 *  meteordevelopment.meteorclient.events.render.Render2DEvent
 *  meteordevelopment.meteorclient.events.render.Render3DEvent
 *  meteordevelopment.meteorclient.mixininterface.IClientPlayerInteractionManager
 *  meteordevelopment.meteorclient.renderer.ShapeMode
 *  meteordevelopment.meteorclient.renderer.text.TextRenderer
 *  meteordevelopment.meteorclient.settings.BlockListSetting$Builder
 *  meteordevelopment.meteorclient.settings.BoolSetting$Builder
 *  meteordevelopment.meteorclient.settings.ColorSetting$Builder
 *  meteordevelopment.meteorclient.settings.DoubleSetting$Builder
 *  meteordevelopment.meteorclient.settings.EnumSetting$Builder
 *  meteordevelopment.meteorclient.settings.Setting
 *  meteordevelopment.meteorclient.settings.SettingGroup
 *  meteordevelopment.meteorclient.systems.friends.Friends
 *  meteordevelopment.meteorclient.systems.modules.Modules
 *  meteordevelopment.meteorclient.utils.entity.EntityUtils
 *  meteordevelopment.meteorclient.utils.player.InvUtils
 *  meteordevelopment.meteorclient.utils.render.NametagUtils
 *  meteordevelopment.meteorclient.utils.render.color.Color
 *  meteordevelopment.meteorclient.utils.render.color.SettingColor
 *  meteordevelopment.orbit.EventHandler
 *  net.minecraft.class_1268
 *  net.minecraft.class_1292
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1511
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1829
 *  net.minecraft.class_1887
 *  net.minecraft.class_1890
 *  net.minecraft.class_1893
 *  net.minecraft.class_1922
 *  net.minecraft.class_2189
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2353
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2824
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_2868
 *  net.minecraft.class_3341
 *  net.minecraft.class_3532
 *  net.minecraft.class_742
 *  org.joml.Vector3d
 */
package espada.spacex.aurora.modules.automine;

import espada.spacex.aurora.Aurora;
import espada.spacex.aurora.Modules;
import espada.spacex.aurora.enums.RotationType;
import espada.spacex.aurora.enums.SwingHand;
import espada.spacex.aurora.enums.SwingState;
import espada.spacex.aurora.enums.SwingType;
import espada.spacex.aurora.globalsettings.SwingSettings;
import espada.spacex.aurora.managers.Managers;
import espada.spacex.aurora.utils.BOBlockUtil;
import espada.spacex.aurora.utils.BOInvUtils;
import espada.spacex.aurora.utils.RSCombatInfo;
import espada.spacex.aurora.utils.SettingUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.events.render.Render2DEvent;
import meteordevelopment.meteorclient.events.render.Render3DEvent;
import meteordevelopment.meteorclient.mixininterface.IClientPlayerInteractionManager;
import meteordevelopment.meteorclient.renderer.ShapeMode;
import meteordevelopment.meteorclient.renderer.text.TextRenderer;
import meteordevelopment.meteorclient.settings.BlockListSetting;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.ColorSetting;
import meteordevelopment.meteorclient.settings.DoubleSetting;
import meteordevelopment.meteorclient.settings.EnumSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.friends.Friends;
import meteordevelopment.meteorclient.utils.entity.EntityUtils;
import meteordevelopment.meteorclient.utils.player.InvUtils;
import meteordevelopment.meteorclient.utils.render.NametagUtils;
import meteordevelopment.meteorclient.utils.render.color.Color;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1292;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1829;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_1922;
import net.minecraft.class_2189;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2824;
import net.minecraft.class_2846;
import net.minecraft.class_2868;
import net.minecraft.class_3341;
import net.minecraft.class_3532;
import net.minecraft.class_742;
import org.joml.Vector3d;

public class AuroraMine
extends Modules {
    private static AuroraMine INSTANCE = new AuroraMine();
    private final SettingGroup sgGeneral;
    private final SettingGroup sgSpeed;
    private final SettingGroup sgExplode;
    private final SettingGroup sgCev;
    private final SettingGroup sgAntiSurround;
    private final SettingGroup sgAntiBurrow;
    private final SettingGroup sgRender;
    private final SettingGroup sgText;
    private final Setting<Boolean> pauseEat;
    private final Setting<Boolean> pauseanchor;
    private final Setting<Boolean> pauseweb;
    private final Setting<Boolean> pauseSword;
    private final Setting<SwitchMode> pickAxeSwitchMode;
    private final Setting<SwitchMode> crystalSwitchMode;
    private final Setting<Boolean> autoMine;
    private final Setting<ListMode> listMode;
    private final Setting<List<class_2248>> blacklist;
    private final Setting<List<class_2248>> whitelist;
    private final Setting<Boolean> manualMine;
    private final Setting<Boolean> manualInsta;
    private final Setting<Boolean> doubleBreak;
    private final Setting<Boolean> silentDouble;
    private final Setting<silenttype> doublesilenttype;
    private final Setting<Boolean> manualRemine;
    private final Setting<Boolean> fastRemine;
    private final Setting<Boolean> manualRangeReset;
    private final Setting<Boolean> resetOnSwitch;
    private final Setting<Boolean> debug;
    private final Setting<Double> speed;
    private final Setting<Double> instaDelay;
    private final Setting<Boolean> onGroundCheck;
    private final Setting<Boolean> effectCheck;
    private final Setting<Boolean> waterCheck;
    private final Setting<Double> explodeSpeed;
    private final Setting<Double> explodeTime;
    private final Setting<Priority> cevPriority;
    private final Setting<Boolean> instaCev;
    private final Setting<Priority> trapCevPriority;
    private final Setting<Boolean> instaTrapCev;
    private final Setting<Priority> surroundCevPriority;
    private final Setting<Boolean> instaSurroundCev;
    private final Setting<Priority> surroundMinerPriority;
    private final Setting<Boolean> instaSurroundMiner;
    private final Setting<Priority> autoCityPriority;
    private final Setting<Boolean> instaAutoCity;
    private final Setting<Boolean> explodeCrystal;
    private final Setting<Priority> antiBurrowPriority;
    private final Setting<Boolean> mineStartSwing;
    private final Setting<Boolean> mineEndSwing;
    private final Setting<SwingHand> mineHand;
    private final Setting<Boolean> placeSwing;
    private final Setting<SwingHand> placeHand;
    private final Setting<Boolean> attackSwing;
    private final Setting<SwingHand> attackHand;
    private final Setting<Double> animationExp;
    private final Setting<RenderMode> renderMode;
    private final Setting<ShapeMode> shapeMode;
    private final Setting<SettingColor> lineStartColor;
    private final Setting<SettingColor> lineEndColor;
    private final Setting<SettingColor> startColor;
    private final Setting<SettingColor> endColor;
    private final Setting<ShapeMode> shapeModeDouble;
    private final Setting<SettingColor> lineStartColorDouble;
    private final Setting<SettingColor> lineEndColorDouble;
    private final Setting<SettingColor> startColorDouble;
    private final Setting<SettingColor> endColorDouble;
    private final Setting<Boolean> text;
    private final Setting<Boolean> shadow;
    private final Setting<Double> textScale;
    private final Setting<SettingColor> startTextColor;
    private final Setting<SettingColor> endTextColor;
    private final Setting<SettingColor> waitColor;
    private final Setting<SettingColor> startTextColorDouble;
    private final Setting<SettingColor> endTextColorDouble;
    private final Setting<SettingColor> waitColorDouble;
    private double minedFor;
    public Target target;
    private boolean started;
    private class_2338 civPos;
    private List<class_742> enemies;
    private long lastTime;
    private long lastPlace;
    private long lastExplode;
    private long lastCiv;
    private boolean canUpdate;
    private double render;
    private double delta;
    private final Map<class_2338, Long> explodeAt;
    private boolean reset;
    private boolean mined;
    private int OldSlot;
    private class_2680 lastState;
    private class_2338 lastPos;
    public class_2338 breakPos;

    public AuroraMine() {
        super(Aurora.Extendcombat, "AuroraMine", "Automatically mines blocks to destroy your enemies.");
        this.sgGeneral = this.settings.getDefaultGroup();
        this.sgSpeed = this.settings.createGroup("Speed");
        this.sgExplode = this.settings.createGroup("Explode");
        this.sgCev = this.settings.createGroup("Cev");
        this.sgAntiSurround = this.settings.createGroup("Anti Surround");
        this.sgAntiBurrow = this.settings.createGroup("Anti Burrow");
        this.sgRender = this.settings.createGroup("Render");
        this.sgText = this.settings.createGroup("Text");
        this.pauseEat = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Pause On Eat")).description("Pause while eating.")).defaultValue((Object)false)).build());
        this.pauseanchor = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Pause On Anchor")).description("Pause while Achor.")).defaultValue((Object)false)).build());
        this.pauseweb = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Pause On Web")).description("Pause while web.")).defaultValue((Object)false)).build());
        this.pauseSword = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Pause On Sword")).description("Doesn't mine while holding sword.")).defaultValue((Object)false)).build());
        this.pickAxeSwitchMode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Pickaxe Switch Mode")).description("Method of switching. InvSwitch is used in most clients.")).defaultValue((Object)SwitchMode.Silent)).build());
        this.crystalSwitchMode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Crystal Switch Mode")).description("Method of switching. InvSwitch is used in most clients.")).defaultValue((Object)SwitchMode.Silent)).build());
        this.autoMine = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Auto Mine")).description("Sets target block to the block you clicked.")).defaultValue((Object)true)).build());
        this.listMode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("List Mode")).description("Selection mode.")).defaultValue((Object)ListMode.Blacklist)).visible(() -> this.autoMine.get())).build());
        this.blacklist = this.sgGeneral.add((Setting)((BlockListSetting.Builder)((BlockListSetting.Builder)((BlockListSetting.Builder)new BlockListSetting.Builder().name("Blacklist")).description("The blocks you don't want to mine.")).defaultValue(new class_2248[]{class_2246.field_23152, class_2246.field_10527, class_2246.field_10343}).visible(() -> (Boolean)this.autoMine.get() != false && this.listMode.get() == ListMode.Blacklist)).build());
        this.whitelist = this.sgGeneral.add((Setting)((BlockListSetting.Builder)((BlockListSetting.Builder)((BlockListSetting.Builder)new BlockListSetting.Builder().name("Whitelist")).description("The blocks you want to mine.")).visible(() -> (Boolean)this.autoMine.get() != false && this.listMode.get() == ListMode.Whitelist)).build());
        this.manualMine = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Manual Mine")).description("Sets target block to the block you clicked.")).defaultValue((Object)true)).build());
        this.manualInsta = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Manual Instant")).description("Uses civ mine when mining manually.")).defaultValue((Object)false)).build());
        this.doubleBreak = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Double Break")).description("Double break.")).defaultValue((Object)true)).build());
        this.silentDouble = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Silent Double")).description("Silent break.")).defaultValue((Object)false)).visible(() -> this.doubleBreak.get())).build());
        this.doublesilenttype = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("SilentDoubleMode")).description("Silent break.")).defaultValue((Object)silenttype.UpdateSelectedSlotC2SPacket)).visible(() -> this.doubleBreak.get())).build());
        this.manualRemine = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Manual Remine")).description("Mines the manually mined block again.")).defaultValue((Object)false)).build());
        this.fastRemine = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Fast Remine")).description("Calculates mining progress from last block broken.")).defaultValue((Object)false)).build());
        this.manualRangeReset = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Manual Range Reset")).description("Resets manual mining if out of range.")).defaultValue((Object)true)).build());
        this.resetOnSwitch = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Reset On Switch")).description("Resets mining when switched held item.")).defaultValue((Object)false)).build());
        this.debug = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("de Bug")).description("an.")).defaultValue((Object)false)).build());
        this.speed = this.sgSpeed.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)new DoubleSetting.Builder().name("Speed")).description("Vanilla speed multiplier.")).defaultValue(1.0).min(0.0).sliderRange(0.0, 2.0).build());
        this.instaDelay = this.sgSpeed.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)new DoubleSetting.Builder().name("Instant Delay")).description("Delay between civ mines.")).defaultValue(0.5).min(0.0).sliderRange(0.0, 1.0).build());
        this.onGroundCheck = this.sgSpeed.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("On Ground Check")).description("Mines 5x slower when not on ground.")).defaultValue((Object)true)).build());
        this.effectCheck = this.sgSpeed.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Effect Check")).description("Modifies mining speed depending on haste and mining fatigue.")).defaultValue((Object)true)).build());
        this.waterCheck = this.sgSpeed.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Water Check")).description("Mines 5x slower while submerged in water.")).defaultValue((Object)true)).build());
        this.explodeSpeed = this.sgExplode.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)new DoubleSetting.Builder().name("Explode Speed")).description("How many times to attack a crystal every second.")).defaultValue(2.0).min(0.0).sliderRange(0.0, 2.0).build());
        this.explodeTime = this.sgExplode.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)new DoubleSetting.Builder().name("Explode Time")).description("Tries to attack a crystal for this many seconds.")).defaultValue(2.0).min(0.0).sliderRange(0.0, 10.0).build());
        this.cevPriority = this.sgCev.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Cev Priority")).description("Priority of cev.")).defaultValue((Object)Priority.Normal)).build());
        this.instaCev = this.sgCev.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Instant Cev")).description("Only sends 1 mine start packet for each block.")).defaultValue((Object)false)).build());
        this.trapCevPriority = this.sgCev.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Trap Cev Priority")).description("Priority of trap cev.")).defaultValue((Object)Priority.Normal)).build());
        this.instaTrapCev = this.sgCev.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Instant Trap Cev")).description("Only sends 1 mine start packet for each block.")).defaultValue((Object)false)).build());
        this.surroundCevPriority = this.sgCev.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Surround Cev Priority")).description("Priority of trap cev.")).defaultValue((Object)Priority.Normal)).build());
        this.instaSurroundCev = this.sgCev.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Instant Surround Cev")).description("Only sends 1 mine start packet for each block.")).defaultValue((Object)false)).build());
        this.surroundMinerPriority = this.sgAntiSurround.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Surround Miner Priority")).description("Priority of surround miner.")).defaultValue((Object)Priority.Normal)).build());
        this.instaSurroundMiner = this.sgAntiSurround.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Instant Surround Miner")).description("Only sends 1 mine start packet for each block.")).defaultValue((Object)false)).build());
        this.autoCityPriority = this.sgAntiSurround.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Auto City Priority")).description("Priority of anti surround. Places crystal next to enemy's surround block.")).defaultValue((Object)Priority.Normal)).build());
        this.instaAutoCity = this.sgAntiSurround.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Instant Auto City")).description("Only sends 1 mine start packet for each block.")).defaultValue((Object)false)).build());
        this.explodeCrystal = this.sgAntiSurround.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Explode Crystal")).description("Attacks the crystal we placed.")).defaultValue((Object)false)).build());
        this.antiBurrowPriority = this.sgAntiBurrow.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Anti Burrow Priority")).description("Priority of anti burrow.")).defaultValue((Object)Priority.Normal)).build());
        this.mineStartSwing = this.sgRender.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Mine Start Swing")).description("Renders swing animation when starting mining.")).defaultValue((Object)true)).build());
        this.mineEndSwing = this.sgRender.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Mine End Swing")).description("Renders swing animation when ending mining.")).defaultValue((Object)true)).build());
        this.mineHand = this.sgRender.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Mine Hand")).description("Which hand should be swung.")).defaultValue((Object)SwingHand.RealHand)).visible(() -> (Boolean)this.mineStartSwing.get() != false || (Boolean)this.mineEndSwing.get() != false)).build());
        this.placeSwing = this.sgRender.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Place Swing")).description("Renders swing animation when placing a crystal.")).defaultValue((Object)true)).build());
        this.placeHand = this.sgRender.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Place Hand")).description("Which hand should be swung.")).defaultValue((Object)SwingHand.RealHand)).visible(() -> this.placeSwing.get())).build());
        this.attackSwing = this.sgRender.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Attack Swing")).description("Renders swing animation when attacking a crystal.")).defaultValue((Object)true)).build());
        this.attackHand = this.sgRender.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Attack Hand")).description("Which hand should be swung.")).defaultValue((Object)SwingHand.RealHand)).visible(() -> this.attackSwing.get())).build());
        this.animationExp = this.sgRender.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)new DoubleSetting.Builder().name("Animation Exponent")).description("3 - 4 look cool.")).defaultValue(3.0).range(0.0, 10.0).sliderRange(0.0, 10.0).build());
        this.renderMode = this.sgRender.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Render Mode")).description(".")).defaultValue((Object)RenderMode.Normal)).build());
        this.shapeMode = this.sgRender.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Shape Mode")).description("Which parts of render should be rendered.")).defaultValue((Object)ShapeMode.Both)).build());
        this.lineStartColor = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Line Start Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 0)).build());
        this.lineEndColor = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Line End Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 255)).build());
        this.startColor = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Side Start Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 0)).build());
        this.endColor = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Side End Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 50)).build());
        this.shapeModeDouble = this.sgRender.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)new EnumSetting.Builder().name("Double Shape Mode")).description("Which parts of render should be rendered.")).defaultValue((Object)ShapeMode.Both)).build());
        this.lineStartColorDouble = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Double Line Start Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 0)).build());
        this.lineEndColorDouble = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Double Line End Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 255)).build());
        this.startColorDouble = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Double Side Start Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 0)).build());
        this.endColorDouble = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Double Side End Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 50)).build());
        this.text = this.sgText.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Text")).description("Renders mine progress text in the block overlay.")).defaultValue((Object)false)).build());
        this.shadow = this.sgText.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)new BoolSetting.Builder().name("Shadow")).description("Do text shadow render.")).defaultValue((Object)true)).visible(() -> this.text.get())).build());
        this.textScale = this.sgText.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)new DoubleSetting.Builder().name("Text Scale")).description("How big the progress text should be.")).defaultValue(1.0).min(0.0).sliderMax(4.0).visible(() -> this.text.get())).build());
        this.startTextColor = this.sgText.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Start Text Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 255)).visible(() -> this.text.get())).build());
        this.endTextColor = this.sgText.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("End Text Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 255)).visible(() -> this.text.get())).build());
        this.waitColor = this.sgText.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Waiting Text Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 255)).visible(() -> (Boolean)this.text.get() != false && (Boolean)this.manualInsta.get() != false)).build());
        this.startTextColorDouble = this.sgText.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Double Start Text Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 255)).visible(() -> (Boolean)this.text.get() != false && (Boolean)this.doubleBreak.get() != false)).build());
        this.endTextColorDouble = this.sgText.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Double End Text Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 255)).visible(() -> (Boolean)this.text.get() != false && (Boolean)this.doubleBreak.get() != false)).build());
        this.waitColorDouble = this.sgText.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)new ColorSetting.Builder().name("Double Waiting Text Color")).description("COLOR")).defaultValue(new SettingColor(255, 255, 255, 255)).visible(() -> (Boolean)this.text.get() != false && (Boolean)this.doubleBreak.get() != false && (Boolean)this.manualInsta.get() != false)).build());
        this.minedFor = 0.0;
        this.target = null;
        this.started = false;
        this.civPos = null;
        this.enemies = new ArrayList<class_742>();
        this.lastTime = 0L;
        this.lastPlace = 0L;
        this.lastExplode = 0L;
        this.lastCiv = 0L;
        this.render = 1.0;
        this.delta = 0.0;
        this.explodeAt = new HashMap<class_2338, Long>();
        this.reset = false;
        this.mined = false;
        this.OldSlot = -1;
        this.lastState = null;
        this.lastPos = null;
        this.breakPos = null;
    }

    public static AuroraMine getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuroraMine();
        }
        return INSTANCE;
    }

    public void onActivate() {
        this.target = null;
        this.breakPos = null;
        this.minedFor = 0.0;
        this.started = false;
        this.lastTime = System.currentTimeMillis();
        this.civPos = null;
        this.reset = false;
    }

    @EventHandler(priority=200)
    private void onSend(PacketEvent.Send event) {
        if (event.packet instanceof class_2868 && ((Boolean)this.resetOnSwitch.get()).booleanValue()) {
            this.reset = true;
        }
    }

    public String getInfoString() {
        return "Main " + (this.getMineProgress() * 100.0 < 0.0 ? 0.0 : Math.floor(this.getMineProgress() * 100.0)) + " Double " + (this.getMineProgressDouble() * 100.0 < 0.0 ? 0.0 : Math.floor(this.getMineProgressDouble() * 100.0));
    }

    @EventHandler(priority=200)
    private void onRender(Render3DEvent event) {
        if (this.mc.field_1724 == null || this.mc.field_1687 == null) {
            return;
        }
        if (this.target != null && this.target.manual && ((Boolean)this.manualRangeReset.get()).booleanValue() && !SettingUtils.inMineRange(this.target.pos)) {
            this.minedFor = 0.0;
            this.breakPos = null;
            this.started = false;
            this.lastTime = System.currentTimeMillis();
            this.civPos = null;
            this.reset = false;
            return;
        }
        if (this.target != null) {
            if (this.lastState != null && this.target.pos.equals((Object)this.lastPos) && this.target.manual && ((Boolean)this.manualRemine.get()).booleanValue() && !((Boolean)this.fastRemine.get()).booleanValue() && !this.lastState.method_51367() && BOBlockUtil.solid2(this.target.pos)) {
                this.started = false;
            }
            this.lastPos = this.target.pos;
            this.lastState = this.mc.field_1687.method_8320(this.target.pos);
        } else {
            this.lastPos = null;
            this.lastState = null;
        }
        this.delta = (double)(System.currentTimeMillis() - this.lastTime) / 1000.0;
        this.lastTime = System.currentTimeMillis();
        this.update();
        this.explodeUpdate();
        if (this.target == null) {
            return;
        }
        switch ((RenderMode)((Object)this.renderMode.get())) {
            case Box: {
                double progress = class_3532.method_15350((double)this.getMineProgress(), (double)0.0, (double)1.0);
                Color color1 = progress >= 0.95 ? (Color)this.endColor.get() : (Color)this.startColor.get();
                Color color2 = progress >= 0.95 ? (Color)this.lineEndColor.get() : (Color)this.lineStartColor.get();
                event.renderer.box(this.target.pos, color1, color2, (ShapeMode)this.shapeMode.get(), 0);
                if (!((Boolean)this.doubleBreak.get()).booleanValue() || this.breakPos == null) break;
                double progressD = class_3532.method_15350((double)this.getMineProgressDouble(), (double)0.0, (double)1.0);
                Color colorD1 = progressD >= 0.95 ? (Color)this.endColorDouble.get() : (Color)this.startColorDouble.get();
                Color colorD2 = progressD >= 0.95 ? (Color)this.lineEndColorDouble.get() : (Color)this.lineStartColorDouble.get();
                event.renderer.box(this.breakPos, colorD1, colorD2, (ShapeMode)this.shapeModeDouble.get(), 0);
                break;
            }
            case Normal: {
                int slot = this.getFastestSlot(this.target.pos);
                this.render = class_3532.method_15350((double)(this.getMineTicks(slot, true) == this.getMineTicks(slot, false) ? this.render + this.delta * 2.0 : this.render - this.delta * 2.0), (double)-2.0, (double)2.0);
                double p = 1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicks(slot, false)), (double)0.0, (double)1.0);
                p = Math.pow(p, (Double)this.animationExp.get());
                p = 1.0 - p;
                event.renderer.box(this.getRenderBox(p / 2.0), this.getColor((Color)this.startColor.get(), (Color)this.endColor.get(), p, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColor.get(), (Color)this.lineEndColor.get(), p, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                p = 1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicks(slot, true)), (double)0.0, (double)1.0);
                p = Math.pow(p, (Double)this.animationExp.get());
                p = 1.0 - p;
                event.renderer.box(this.getRenderBox(p / 2.0), this.getColor((Color)this.startColor.get(), (Color)this.endColor.get(), p, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColor.get(), (Color)this.lineEndColor.get(), p, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                if (!((Boolean)this.doubleBreak.get()).booleanValue() || this.breakPos == null) break;
                int slot2 = this.getFastestSlot(this.breakPos);
                this.render = class_3532.method_15350((double)(this.getMineTicksDouble(slot2, true) == this.getMineTicksDouble(slot2, false) ? this.render + this.delta * 2.0 : this.render - this.delta * 2.0), (double)-2.0, (double)2.0);
                double p22 = 1.0 - Math.pow(1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicksDouble(slot2, false)), (double)0.0, (double)1.0), (Double)this.animationExp.get());
                event.renderer.box(this.getRenderBoxDouble(p22 / 2.0), this.getColor((Color)this.startColorDouble.get(), (Color)this.endColorDouble.get(), p22, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColorDouble.get(), (Color)this.lineEndColorDouble.get(), p22, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                double p23 = 1.0 - Math.pow(1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicksDouble(slot2, true)), (double)0.0, (double)1.0), (Double)this.animationExp.get());
                event.renderer.box(this.getRenderBoxDouble(p23 / 2.0), this.getColor((Color)this.startColorDouble.get(), (Color)this.endColor.get(), p23, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColorDouble.get(), (Color)this.lineEndColorDouble.get(), p23, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                break;
            }
            case Future: {
                double progress = class_3532.method_15350((double)this.getMineProgress(), (double)0.0, (double)1.0);
                Color color1 = progress >= 0.95 ? (Color)this.endColor.get() : (Color)this.startColor.get();
                Color color2 = progress >= 0.95 ? (Color)this.lineEndColor.get() : (Color)this.lineStartColor.get();
                double min = progress / 2.0;
                class_243 vec3d = this.target.pos.method_46558();
                class_238 box = new class_238(vec3d.field_1352 - min, vec3d.field_1351 - min, vec3d.field_1350 - min, vec3d.field_1352 + min, vec3d.field_1351 + min, vec3d.field_1350 + min);
                event.renderer.box(box, color1, color2, (ShapeMode)this.shapeMode.get(), 0);
                if (!((Boolean)this.doubleBreak.get()).booleanValue() || this.breakPos == null) break;
                double progressD = class_3532.method_15350((double)this.getMineProgressDouble(), (double)0.0, (double)1.0);
                Color colorD1 = progressD >= 0.95 ? (Color)this.endColorDouble.get() : (Color)this.startColorDouble.get();
                Color colorD2 = progressD >= 0.95 ? (Color)this.lineEndColorDouble.get() : (Color)this.lineStartColorDouble.get();
                double minD = progress / 2.0;
                class_243 vec3dD = this.breakPos.method_46558();
                class_238 boxD = new class_238(vec3dD.field_1352 - minD, vec3dD.field_1351 - minD, vec3dD.field_1350 - minD, vec3dD.field_1352 + minD, vec3dD.field_1351 + minD, vec3dD.field_1350 + minD);
                event.renderer.box(boxD, colorD1, colorD2, (ShapeMode)this.shapeModeDouble.get(), 0);
                break;
            }
            case Shrink: {
                int slot = this.getFastestSlot(this.target.pos);
                this.render = class_3532.method_15350((double)(this.getMineTicks(slot, true) == this.getMineTicks(slot, false) ? this.render + this.delta * 2.0 : this.render - this.delta * 2.0), (double)-2.0, (double)2.0);
                double mineProgress = class_3532.method_15350((double)this.getMineProgress(), (double)0.0, (double)1.0);
                double progress = 1.0 - mineProgress;
                double max = (double)Math.round(progress * 100.0) / 100.0;
                double min = 1.0 - max;
                class_243 vec3d = new class_243((double)this.target.pos.method_10263(), (double)this.target.pos.method_10264(), (double)this.target.pos.method_10260());
                class_238 renderBox = new class_238(vec3d.field_1352 + min, vec3d.field_1351 + min, vec3d.field_1350 + min, vec3d.field_1352 + max, vec3d.field_1351 + max, vec3d.field_1350 + max);
                double p = 1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicks(slot, false)), (double)0.0, (double)1.0);
                p = Math.pow(p, (Double)this.animationExp.get());
                p = 1.0 - p;
                event.renderer.box(renderBox, this.getColor((Color)this.startColor.get(), (Color)this.endColor.get(), p, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColor.get(), (Color)this.lineEndColor.get(), p, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                p = 1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicks(slot, true)), (double)0.0, (double)1.0);
                p = Math.pow(p, (Double)this.animationExp.get());
                p = 1.0 - p;
                event.renderer.box(renderBox, this.getColor((Color)this.startColor.get(), (Color)this.endColor.get(), p, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColor.get(), (Color)this.lineEndColor.get(), p, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                if (!((Boolean)this.doubleBreak.get()).booleanValue() || this.breakPos == null) break;
                int slot2 = this.getFastestSlot(this.breakPos);
                this.render = class_3532.method_15350((double)(this.getMineTicksDouble(slot2, true) == this.getMineTicksDouble(slot2, false) ? this.render + this.delta * 2.0 : this.render - this.delta * 2.0), (double)-2.0, (double)2.0);
                double mineProgressD = class_3532.method_15350((double)this.getMineProgressDouble(), (double)0.0, (double)1.0);
                double progressD = 1.0 - mineProgressD;
                double maxD = (double)Math.round(progressD * 100.0) / 100.0;
                double minD = 1.0 - maxD;
                class_243 vec3dD = new class_243((double)this.breakPos.method_10263(), (double)this.breakPos.method_10264(), (double)this.breakPos.method_10260());
                class_238 renderBoxD = new class_238(vec3dD.field_1352 + minD, vec3dD.field_1351 + minD, vec3dD.field_1350 + minD, vec3dD.field_1352 + maxD, vec3dD.field_1351 + maxD, vec3dD.field_1350 + maxD);
                double p22 = 1.0 - Math.pow(1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicksDouble(slot2, false)), (double)0.0, (double)1.0), (Double)this.animationExp.get());
                event.renderer.box(renderBoxD, this.getColor((Color)this.startColorDouble.get(), (Color)this.endColorDouble.get(), p22, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColorDouble.get(), (Color)this.lineEndColorDouble.get(), p22, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                double p23 = 1.0 - Math.pow(1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicksDouble(slot2, true)), (double)0.0, (double)1.0), (Double)this.animationExp.get());
                event.renderer.box(renderBoxD, this.getColor((Color)this.startColorDouble.get(), (Color)this.endColor.get(), p23, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColorDouble.get(), (Color)this.lineEndColorDouble.get(), p23, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                break;
            }
            case Grow: {
                int slot = this.getFastestSlot(this.target.pos);
                this.render = class_3532.method_15350((double)(this.getMineTicks(slot, true) == this.getMineTicks(slot, false) ? this.render + this.delta * 2.0 : this.render - this.delta * 2.0), (double)-2.0, (double)2.0);
                class_238 renderBox = new class_238((double)this.target.pos.method_10263(), (double)this.target.pos.method_10264(), (double)this.target.pos.method_10260(), (double)(this.target.pos.method_10263() + 1), (double)this.target.pos.method_10264() + class_3532.method_15350((double)this.getMineProgress(), (double)0.0, (double)1.0), (double)(this.target.pos.method_10260() + 1));
                double p = 1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicks(slot, false)), (double)0.0, (double)1.0);
                p = Math.pow(p, (Double)this.animationExp.get());
                p = 1.0 - p;
                event.renderer.box(renderBox, this.getColor((Color)this.startColor.get(), (Color)this.endColor.get(), p, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColor.get(), (Color)this.lineEndColor.get(), p, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                p = 1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicks(slot, true)), (double)0.0, (double)1.0);
                p = Math.pow(p, (Double)this.animationExp.get());
                p = 1.0 - p;
                event.renderer.box(renderBox, this.getColor((Color)this.startColor.get(), (Color)this.endColor.get(), p, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColor.get(), (Color)this.lineEndColor.get(), p, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                if (!((Boolean)this.doubleBreak.get()).booleanValue() || this.breakPos == null) break;
                int slot2 = this.getFastestSlot(this.breakPos);
                this.render = class_3532.method_15350((double)(this.getMineTicksDouble(slot2, true) == this.getMineTicksDouble(slot2, false) ? this.render + this.delta * 2.0 : this.render - this.delta * 2.0), (double)-2.0, (double)2.0);
                class_238 renderBoxDouble = new class_238((double)this.breakPos.method_10263(), (double)this.breakPos.method_10264(), (double)this.breakPos.method_10260(), (double)(this.breakPos.method_10263() + 1), (double)this.breakPos.method_10264() + class_3532.method_15350((double)this.getMineProgressDouble(), (double)0.0, (double)1.0), (double)(this.breakPos.method_10260() + 1));
                double p22 = 1.0 - Math.pow(1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicksDouble(slot2, false)), (double)0.0, (double)1.0), (Double)this.animationExp.get());
                event.renderer.box(renderBoxDouble, this.getColor((Color)this.startColorDouble.get(), (Color)this.endColorDouble.get(), p22, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColorDouble.get(), (Color)this.lineEndColorDouble.get(), p22, class_3532.method_15350((double)this.render, (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
                double p23 = 1.0 - Math.pow(1.0 - class_3532.method_15350((double)(this.minedFor / (double)this.getMineTicksDouble(slot2, true)), (double)0.0, (double)1.0), (Double)this.animationExp.get());
                event.renderer.box(renderBoxDouble, this.getColor((Color)this.startColorDouble.get(), (Color)this.endColor.get(), p23, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), this.getColor((Color)this.lineStartColorDouble.get(), (Color)this.lineEndColorDouble.get(), p23, class_3532.method_15350((double)(-this.render), (double)0.0, (double)1.0)), (ShapeMode)this.shapeMode.get(), 0);
            }
        }
        if (((Boolean)this.debug.get()).booleanValue()) {
            class_2338 pos = this.target.pos.method_10093(SettingUtils.getPlaceOnDirection(this.target.pos) == null ? class_2350.field_11036 : SettingUtils.getPlaceOnDirection(this.target.pos));
            class_238 renderBox = new class_238((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), (double)(pos.method_10263() + 1), (double)(pos.method_10264() + 1), (double)(pos.method_10260() + 1));
            event.renderer.box(renderBox, new Color(255, 255, 255, 70), new Color(255, 255, 255, 0), (ShapeMode)this.shapeMode.get(), 0);
        }
    }

    @EventHandler
    private void onRender2D(Render2DEvent event) {
        Vector3d vec3Double;
        if (!((Boolean)this.text.get()).booleanValue() || this.target != null && this.target.manual && ((Boolean)this.manualRangeReset.get()).booleanValue() && !SettingUtils.inMineRange(this.target.pos) || this.target == null) {
            return;
        }
        Vector3d vec3 = new Vector3d((double)this.target.pos.method_10263() + 0.5, (double)this.target.pos.method_10264() + 0.5, (double)this.target.pos.method_10260() + 0.5);
        if (NametagUtils.to2D((Vector3d)vec3, (double)((Double)this.textScale.get()))) {
            TextRenderer textRenderer = TextRenderer.get();
            NametagUtils.begin((Vector3d)vec3);
            textRenderer.begin(1.0, false, true);
            String text = String.valueOf((int)Math.floor(this.getMineProgress() * 100.0));
            textRenderer.render((String)(this.isAir(this.target.pos) ? "Waiting" : text + "%"), -textRenderer.getWidth(text) / 2.0, 0.0, this.get2DTextColor(), ((Boolean)this.shadow.get()).booleanValue());
            textRenderer.end();
            NametagUtils.end();
        }
        if (((Boolean)this.doubleBreak.get()).booleanValue() && this.breakPos != null && NametagUtils.to2D((Vector3d)(vec3Double = new Vector3d((double)this.breakPos.method_10263() + 0.5, (double)this.breakPos.method_10264() + 0.5, (double)this.breakPos.method_10260() + 0.5)), (double)((Double)this.textScale.get()))) {
            TextRenderer textRenderer = TextRenderer.get();
            NametagUtils.begin((Vector3d)vec3Double);
            textRenderer.begin(1.0, false, true);
            String text = String.valueOf((int)Math.floor(this.getMineProgressDouble() * 100.0));
            textRenderer.render((String)(this.isAir(this.breakPos) ? "Waiting" : text + "%"), -textRenderer.getWidth(text) / 2.0, 0.0, this.get2DTextColorDouble(), ((Boolean)this.shadow.get()).booleanValue());
            textRenderer.end();
            NametagUtils.end();
        }
    }

    private Color get2DTextColor() {
        double progress = this.getMineProgress();
        String text = String.format("%.2f", progress);
        if (((Boolean)this.manualInsta.get()).booleanValue() && text.equals("Infinity")) {
            return (Color)this.waitColor.get();
        }
        return progress >= 0.95 ? (Color)this.endTextColor.get() : (Color)this.startTextColor.get();
    }

    private Color get2DTextColorDouble() {
        double progress = this.getMineProgressDouble();
        String text = String.format("%.2f", progress);
        if (((Boolean)this.manualInsta.get()).booleanValue() && text.equals("Infinity")) {
            return (Color)this.waitColorDouble.get();
        }
        return progress >= 0.95 ? (Color)this.endTextColorDouble.get() : (Color)this.startTextColorDouble.get();
    }

    private void explodeUpdate() {
        class_1511 targetCrystal = null;
        ArrayList<class_2338> toRemove = new ArrayList<class_2338>();
        for (Map.Entry<class_2338, Long> entry : this.explodeAt.entrySet()) {
            class_1511 crystal;
            if ((double)(System.currentTimeMillis() - entry.getValue()) > (Double)this.explodeTime.get() * 1000.0) {
                toRemove.add(entry.getKey());
            }
            if ((crystal = this.crystalAt(entry.getKey())) == null) continue;
            targetCrystal = crystal;
            break;
        }
        toRemove.forEach(this.explodeAt::remove);
        if (targetCrystal != null && !this.isPaused() && this.mined && (double)(System.currentTimeMillis() - this.lastExplode) > 1000.0 / (Double)this.explodeSpeed.get() && (!SettingUtils.shouldRotate(RotationType.Attacking) || Managers.ROTATION.start(targetCrystal.method_5829(), (double)this.priority, RotationType.Attacking, (long)Objects.hash(this.name + "attacking")))) {
            SettingUtils.swing(SwingState.Pre, SwingType.Attacking, class_1268.field_5808);
            this.sendPacket((class_2596<?>)class_2824.method_34206((class_1297)targetCrystal, (boolean)this.mc.field_1724.method_5715()));
            SettingUtils.swing(SwingState.Post, SwingType.Attacking, class_1268.field_5808);
            if (((Boolean)this.attackSwing.get()).booleanValue()) {
                this.clientSwing((SwingHand)((Object)this.attackHand.get()), class_1268.field_5808);
            }
            this.lastExplode = System.currentTimeMillis();
            if (SettingUtils.shouldRotate(RotationType.Attacking)) {
                Managers.ROTATION.end(Objects.hash(this.name + "attacking"));
            }
        }
    }

    public double getMineProgress() {
        if (this.target == null) {
            return -1.0;
        }
        return this.minedFor / (double)this.getMineTicks(this.fastestSlot(), true);
    }

    public double getMineProgressDouble() {
        if (this.breakPos == null) {
            return -1.0;
        }
        return this.minedFor / (double)this.getMineTicksDouble(this.fastestSlotDouble(), true);
    }

    private void update() {
        class_2338 lastPos;
        if (this.mc.field_1687 == null) {
            return;
        }
        this.Back();
        if (this.reset) {
            if (this.target != null && !this.target.manual) {
                this.target = null;
            }
            this.started = false;
            this.reset = false;
        }
        this.enemies = this.mc.field_1687.method_18456().stream().filter(player -> player != this.mc.field_1724 && !Friends.get().isFriend((class_1657)player) && player.method_5739((class_1297)this.mc.field_1724) < 10.0f).toList();
        class_2338 class_23382 = lastPos = this.target == null || this.target.pos == null ? null : this.target.pos;
        if (this.target != null && this.target.manual && ((Boolean)this.manualRangeReset.get()).booleanValue() && !SettingUtils.inMineRange(this.target.pos)) {
            this.minedFor = 0.0;
            this.breakPos = null;
            this.started = false;
            this.lastTime = System.currentTimeMillis();
            this.civPos = null;
            this.reset = false;
        } else if (this.breakPos != null && this.target != null && (this.mc.field_1687.method_22347(this.breakPos) || this.breakPos.equals((Object)this.target.pos) || ((Boolean)this.manualRangeReset.get()).booleanValue() && !SettingUtils.inMineRange(this.breakPos))) {
            this.breakPos = null;
        }
        if (this.target == null || !this.target.manual) {
            this.target = this.getTarget();
        }
        if (this.target == null) {
            return;
        }
        if (this.target.pos != null && !this.target.pos.equals((Object)lastPos)) {
            if (this.started) {
                this.sendPacket((class_2596<?>)new class_2846(class_2846.class_2847.field_12971, this.target.pos, class_2350.field_11033, 0));
            }
            this.started = false;
        }
        if (!this.started) {
            boolean rotated;
            boolean bl = rotated = !SettingUtils.startMineRot() || Managers.ROTATION.start(this.target.pos, (double)this.priority, RotationType.Mining, (long)Objects.hash(this.name + "mining"));
            if (BOBlockUtil.getBlock(((AuroraMine)meteordevelopment.meteorclient.systems.modules.Modules.get().get(AuroraMine.class)).targetPos()) == class_2246.field_23152 && ((Boolean)this.pauseanchor.get()).booleanValue()) {
                return;
            }
            if (BOBlockUtil.getBlock(((AuroraMine)meteordevelopment.meteorclient.systems.modules.Modules.get().get(AuroraMine.class)).targetPos()) == class_2246.field_10343 && ((Boolean)this.pauseweb.get()).booleanValue()) {
                return;
            }
            if (rotated) {
                this.started = true;
                this.minedFor = 0.0;
                this.civPos = null;
                this.render = this.getMineTicks(this.fastestSlot(), true) == this.getMineTicks(this.fastestSlot(), false) ? 2.0 : -2.0;
                this.sendSequenced(s -> new class_2846(class_2846.class_2847.field_12968, this.target.pos, SettingUtils.getPlaceOnDirection(this.target.pos) == null ? class_2350.field_11036 : SettingUtils.getPlaceOnDirection(this.target.pos), s));
                if (((Boolean)this.doubleBreak.get()).booleanValue()) {
                    this.sendSequenced(s -> new class_2846(class_2846.class_2847.field_12973, this.target.pos, SettingUtils.getPlaceOnDirection(this.target.pos) == null ? class_2350.field_11036 : SettingUtils.getPlaceOnDirection(this.target.pos), s));
                    this.sendSequenced(s -> new class_2846(class_2846.class_2847.field_12968, this.target.pos, SettingUtils.getPlaceOnDirection(this.target.pos) == null ? class_2350.field_11036 : SettingUtils.getPlaceOnDirection(this.target.pos), s));
                }
                if (((Boolean)this.debug.get()).booleanValue()) {
                    this.error(String.valueOf(SettingUtils.getPlaceOnDirection(this.target.pos) == null ? class_2350.field_11036 : SettingUtils.getPlaceOnDirection(this.target.pos)) + String.valueOf(this.target.pos) + "AutoMine 1", new Object[0]);
                    this.error(String.valueOf(SettingUtils.getPlaceOnDirection(this.breakPos) == null ? class_2350.field_11036 : SettingUtils.getPlaceOnDirection(this.breakPos)) + String.valueOf(this.breakPos) + "AutoMine 2", new Object[0]);
                }
                SettingUtils.mineSwing(SwingSettings.MiningSwingState.Start);
                this.mined = false;
                if (((Boolean)this.mineStartSwing.get()).booleanValue()) {
                    this.clientSwing((SwingHand)((Object)this.mineHand.get()), class_1268.field_5808);
                }
                if (SettingUtils.startMineRot()) {
                    Managers.ROTATION.end(Objects.hash(this.name + "mining"));
                }
            }
        }
        if (!this.started) {
            return;
        }
        this.minedFor += this.delta * 20.0;
        if (this.isPaused()) {
            return;
        }
        if (!this.miningCheck(this.fastestSlot())) {
            return;
        }
        if (!this.civCheck()) {
            return;
        }
        if (!this.crystalCheck()) {
            return;
        }
        if (!BOBlockUtil.solid2(this.target.pos)) {
            return;
        }
        this.endMine();
        if (!this.miningCheckDouble(this.fastestSlotDouble())) {
            return;
        }
        if (!BOBlockUtil.solid2(this.breakPos)) {
            return;
        }
        this.Double();
    }

    private void Double() {
        int slot2 = this.fastestSlotDouble();
        if (((Boolean)this.doubleBreak.get()).booleanValue() && ((Boolean)this.silentDouble.get()).booleanValue()) {
            boolean rotated2;
            if (this.breakPos == null || !BOBlockUtil.solid2(this.breakPos) || this.mc.field_1724.method_6115() && ((Boolean)this.pauseEat.get()).booleanValue()) {
                return;
            }
            boolean bl = rotated2 = !SettingUtils.startMineRot() || Managers.ROTATION.start(this.breakPos, (double)this.priority, RotationType.Mining, (long)Objects.hash(this.name + "mining"));
            if (!(this.getBlock(this.breakPos) instanceof class_2189) && this.getMineProgressDouble() * 100.0 > 70.0) {
                if (((Boolean)this.debug.get()).booleanValue()) {
                    this.error("Silent", new Object[0]);
                }
                SettingUtils.mineSwing(SwingSettings.MiningSwingState.Double);
                if (this.doublesilenttype.get() == silenttype.UpdateSelectedSlotC2SPacket) {
                    this.sendPacket((class_2596<?>)new class_2868(slot2));
                } else if (this.doublesilenttype.get() == silenttype.selectedSlot) {
                    if (this.OldSlot == -1) {
                        this.OldSlot = this.mc.field_1724.method_31548().field_7545;
                    }
                    this.mc.field_1724.method_31548().field_7545 = slot2;
                    ((IClientPlayerInteractionManager)this.mc.field_1761).syncSelected();
                }
                if (this.doublesilenttype.get() == silenttype.ClientselectedSwap) {
                    int doubleSlot = this.getFastestSlot(this.breakPos);
                    if (!(this.getBlock(this.breakPos) instanceof class_2189)) {
                        this.OldSlot = this.mc.field_1724.method_31548().field_7545;
                        this.sendPacket((class_2596<?>)new class_2868(doubleSlot));
                        this.canUpdate = true;
                    }
                }
                if (SettingUtils.startMineRot()) {
                    Managers.ROTATION.end(Objects.hash(this.name + "mining"));
                }
                this.canUpdate = true;
            }
        }
    }

    private void Back() {
        if (this.canUpdate && this.breakPos != null && this.getBlock(this.breakPos) instanceof class_2189) {
            if (((Boolean)this.debug.get()).booleanValue()) {
                this.error("Back", new Object[0]);
            }
            SettingUtils.mineSwing(SwingSettings.MiningSwingState.End);
            if (this.doublesilenttype.get() == silenttype.UpdateSelectedSlotC2SPacket) {
                this.sendPacket((class_2596<?>)new class_2868(this.mc.field_1724.method_31548().field_7545));
            } else if (this.doublesilenttype.get() == silenttype.selectedSlot && this.OldSlot != -1) {
                this.mc.field_1724.method_31548().field_7545 = this.OldSlot;
                ((IClientPlayerInteractionManager)this.mc.field_1761).syncSelected();
                this.OldSlot = -1;
            }
            this.canUpdate = false;
        }
        if (Math.floor(this.getMineProgressDouble() * 100.0) > 115.0) {
            if (((Boolean)this.debug.get()).booleanValue()) {
                this.error("Back", new Object[0]);
            }
            SettingUtils.mineSwing(SwingSettings.MiningSwingState.End);
            if (this.doublesilenttype.get() == silenttype.UpdateSelectedSlotC2SPacket) {
                this.sendPacket((class_2596<?>)new class_2868(this.mc.field_1724.method_31548().field_7545));
            } else if (this.doublesilenttype.get() == silenttype.selectedSlot && this.OldSlot != -1) {
                this.mc.field_1724.method_31548().field_7545 = this.OldSlot;
                ((IClientPlayerInteractionManager)this.mc.field_1761).syncSelected();
                this.OldSlot = -1;
            }
            if (this.breakPos != null) {
                this.breakPos = null;
            }
            this.canUpdate = false;
        }
    }

    private boolean isPaused() {
        if (((Boolean)this.pauseEat.get()).booleanValue() && this.mc.field_1724.method_6115()) {
            return true;
        }
        return (Boolean)this.pauseSword.get() != false && this.mc.field_1724.method_6047().method_7909() instanceof class_1829;
    }

    private boolean civCheck() {
        if (this.civPos == null) {
            return true;
        }
        return !((double)(System.currentTimeMillis() - this.lastCiv) < (Double)this.instaDelay.get() * 1000.0);
    }

    private void endMine() {
        int slot = this.fastestSlot();
        boolean switched = this.miningCheck(Managers.HOLDING.slot);
        boolean swapBack = false;
        if (SettingUtils.shouldRotate(RotationType.Mining) && !Managers.ROTATION.start(this.target.pos, (double)this.priority, RotationType.Mining, (long)Objects.hash(this.name + "mining"))) {
            return;
        }
        if (!switched) {
            switch ((SwitchMode)((Object)this.pickAxeSwitchMode.get())) {
                case Silent: {
                    switched = true;
                    InvUtils.swap((int)slot, (boolean)true);
                    break;
                }
                case PickSilent: {
                    switched = true;
                    BOInvUtils.pickSwitch(slot);
                    break;
                }
                case InvSwitch: {
                    switched = BOInvUtils.invSwitch(slot);
                }
            }
            swapBack = switched;
        }
        if (!switched) {
            return;
        }
        this.sendSequenced(s -> new class_2846(class_2846.class_2847.field_12973, this.target.pos, SettingUtils.getPlaceOnDirection(this.target.pos) == null ? class_2350.field_11036 : SettingUtils.getPlaceOnDirection(this.target.pos), s));
        this.mined = true;
        SettingUtils.mineSwing(SwingSettings.MiningSwingState.End);
        if (((Boolean)this.mineEndSwing.get()).booleanValue()) {
            this.clientSwing((SwingHand)((Object)this.mineHand.get()), class_1268.field_5808);
        }
        if (this.target.civ) {
            this.civPos = this.target.pos;
        }
        if (SettingUtils.endMineRot()) {
            Managers.ROTATION.end(Objects.hash(this.name + "mining"));
        }
        if (swapBack) {
            switch ((SwitchMode)((Object)this.pickAxeSwitchMode.get())) {
                case Silent: {
                    InvUtils.swapBack();
                    break;
                }
                case PickSilent: {
                    BOInvUtils.pickSwapBack();
                    break;
                }
                case InvSwitch: {
                    BOInvUtils.invSwapBack();
                }
            }
        }
        if (this.target.civ) {
            this.civPos = this.target.pos;
            this.lastCiv = System.currentTimeMillis();
        } else if (this.target.manual && ((Boolean)this.manualRemine.get()).booleanValue()) {
            this.minedFor = 0.0;
        } else {
            this.target = null;
            this.minedFor = 0.0;
        }
    }

    private boolean crystalCheck() {
        switch (this.target.type) {
            case Cev: 
            case TrapCev: 
            case SurroundCev: {
                if (this.crystalAt(this.target.crystalPos) != null) {
                    return true;
                }
                if (EntityUtils.intersectsWithEntity((class_238)class_238.method_19316((class_3341)new class_3341(this.target.crystalPos)).method_35578((double)(this.target.crystalPos.method_10264() + (SettingUtils.cc() ? 1 : 2))), entity -> !entity.method_7325())) break;
                this.placeCrystal();
                return false;
            }
            case AutoCity: {
                if (this.crystalAt(this.target.crystalPos) != null) {
                    return true;
                }
                if (EntityUtils.intersectsWithEntity((class_238)class_238.method_19316((class_3341)new class_3341(this.target.crystalPos)).method_35578((double)(this.target.crystalPos.method_10264() + (SettingUtils.cc() ? 1 : 2))), entity -> !entity.method_7325())) break;
                return this.placeCrystal();
            }
            default: {
                return true;
            }
        }
        return false;
    }

    private int getFastestSlot(class_2338 blockPos) {
        int slot = -1;
        if (this.mc.field_1724 == null || this.mc.field_1687 == null) {
            return -1;
        }
        for (int i = 0; i < (this.pickAxeSwitchMode.get() == SwitchMode.Silent ? 9 : 35); ++i) {
            if (slot != -1 && !(this.mc.field_1724.method_31548().method_5438(i).method_7924(this.mc.field_1687.method_8320(blockPos)) > this.mc.field_1724.method_31548().method_5438(slot).method_7924(this.mc.field_1687.method_8320(blockPos)))) continue;
            slot = i;
        }
        return slot;
    }

    private class_1511 crystalAt(class_2338 pos) {
        for (class_1297 entity : this.mc.field_1687.method_18112()) {
            if (!(entity instanceof class_1511)) continue;
            class_1511 crystal = (class_1511)entity;
            if (!entity.method_24515().equals((Object)pos)) continue;
            return crystal;
        }
        return null;
    }

    private boolean placeCrystal() {
        boolean switched;
        boolean rotated;
        if (System.currentTimeMillis() - this.lastPlace < 250L) {
            return false;
        }
        class_1268 hand = this.getHand();
        int crystalSlot = InvUtils.find((class_1792[])new class_1792[]{class_1802.field_8301}).slot();
        if (hand == null && crystalSlot < 0) {
            return false;
        }
        class_2350 dir = SettingUtils.getPlaceOnDirection(this.target.crystalPos.method_10074());
        if (dir == null) {
            return false;
        }
        boolean bl = rotated = !SettingUtils.shouldRotate(RotationType.Interact) || Managers.ROTATION.start(this.target.crystalPos.method_10074(), (double)this.priority, RotationType.Interact, (long)Objects.hash(this.name + "placing"));
        if (!rotated) {
            return false;
        }
        boolean bl2 = switched = hand != null;
        if (!switched) {
            switch ((SwitchMode)((Object)this.crystalSwitchMode.get())) {
                case Silent: {
                    switched = true;
                    InvUtils.swap((int)crystalSlot, (boolean)true);
                    break;
                }
                case PickSilent: {
                    switched = BOInvUtils.pickSwitch(crystalSlot);
                    break;
                }
                case InvSwitch: {
                    switched = BOInvUtils.invSwitch(crystalSlot);
                }
            }
        }
        if (!switched) {
            return false;
        }
        this.interactBlock(hand == null ? class_1268.field_5808 : hand, this.target.crystalPos.method_10074().method_46558(), dir, this.target.crystalPos.method_10074());
        if (((Boolean)this.placeSwing.get()).booleanValue()) {
            this.clientSwing((SwingHand)((Object)this.placeHand.get()), hand == null ? class_1268.field_5808 : hand);
        }
        this.lastPlace = System.currentTimeMillis();
        if (this.shouldExplode()) {
            this.addExplode();
        }
        if (SettingUtils.shouldRotate(RotationType.Interact)) {
            Managers.ROTATION.end(Objects.hash(this.name + "placing"));
        }
        if (hand == null) {
            switch ((SwitchMode)((Object)this.crystalSwitchMode.get())) {
                case Silent: {
                    InvUtils.swapBack();
                    break;
                }
                case PickSilent: {
                    BOInvUtils.pickSwapBack();
                    break;
                }
                case InvSwitch: {
                    BOInvUtils.invSwapBack();
                }
            }
        }
        return true;
    }

    private void addExplode() {
        this.explodeAt.remove(this.target.crystalPos);
        this.explodeAt.put(this.target.crystalPos, System.currentTimeMillis());
    }

    private boolean shouldExplode() {
        return switch (this.target.type) {
            default -> throw new IncompatibleClassChangeError();
            case MineType.Cev, MineType.TrapCev, MineType.SurroundCev -> true;
            case MineType.SurroundMiner, MineType.AntiBurrow, MineType.Manual -> false;
            case MineType.AutoCity -> (Boolean)this.explodeCrystal.get();
        };
    }

    private Target getTarget() {
        Target t;
        Target target = null;
        if (!((Boolean)this.autoMine.get()).booleanValue()) {
            return target;
        }
        if (this.priorityCheck(target, (Priority)((Object)this.cevPriority.get())) && (t = this.getCev()) != null) {
            if (this.listMode.get() == ListMode.Whitelist && !((List)this.whitelist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            if (this.listMode.get() == ListMode.Blacklist && ((List)this.blacklist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            target = t;
        }
        if (this.priorityCheck(target, (Priority)((Object)this.trapCevPriority.get())) && (t = this.getTrapCev()) != null) {
            if (this.listMode.get() == ListMode.Whitelist && !((List)this.whitelist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            if (this.listMode.get() == ListMode.Blacklist && ((List)this.blacklist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            target = t;
        }
        if (this.priorityCheck(target, (Priority)((Object)this.surroundCevPriority.get())) && (t = this.getSurroundCev()) != null) {
            if (this.listMode.get() == ListMode.Whitelist && !((List)this.whitelist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            if (this.listMode.get() == ListMode.Blacklist && ((List)this.blacklist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            target = t;
        }
        if (this.priorityCheck(target, (Priority)((Object)this.surroundMinerPriority.get())) && (t = this.getSurroundMiner()) != null) {
            if (this.listMode.get() == ListMode.Whitelist && !((List)this.whitelist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            if (this.listMode.get() == ListMode.Blacklist && ((List)this.blacklist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            target = t;
        }
        if (this.priorityCheck(target, (Priority)((Object)this.autoCityPriority.get())) && (t = this.getAutoCity()) != null) {
            if (this.listMode.get() == ListMode.Whitelist && !((List)this.whitelist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            if (this.listMode.get() == ListMode.Blacklist && ((List)this.blacklist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            target = t;
        }
        if (this.priorityCheck(target, (Priority)((Object)this.antiBurrowPriority.get())) && (t = this.getAntiBurrow()) != null) {
            if (this.listMode.get() == ListMode.Whitelist && !((List)this.whitelist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            if (this.listMode.get() == ListMode.Blacklist && ((List)this.blacklist.get()).contains(this.getBlock(t.pos))) {
                return null;
            }
            target = t;
        }
        return target;
    }

    private Target getCev() {
        boolean civ = (Boolean)this.instaCev.get();
        Target best = null;
        double distance = 1000.0;
        for (class_742 player : this.enemies) {
            double d;
            class_2338 pos = new class_2338(player.method_31477(), (int)Math.floor(player.method_5829().field_1325) + 1, player.method_31479());
            if ((!civ || !pos.equals((Object)this.civPos)) && this.getBlock(pos) != class_2246.field_10540 || civ && pos.equals((Object)this.civPos) && !(this.getBlock(pos) instanceof class_2189) && this.getBlock(pos) != class_2246.field_10540 || this.getBlock(pos.method_10084()) != class_2246.field_10124 || SettingUtils.oldCrystals() && this.getBlock(pos.method_10086(2)) != class_2246.field_10124 || !SettingUtils.inMineRange(pos) || !SettingUtils.inPlaceRange(pos) || !SettingUtils.inAttackRange(RSCombatInfo.getCrystalBox(pos.method_10084())) || this.blocked(pos.method_10084()) || !this.distanceCheck(civ, pos, distance, d = this.mc.field_1724.method_33571().method_1022(class_243.method_24953((class_2382)pos)))) continue;
            best = new Target(pos, pos.method_10084(), MineType.Cev, (double)((Priority)this.cevPriority.get()).priority + (civ && pos.equals((Object)this.civPos) ? 0.1 : 0.0), civ, false);
            distance = d;
        }
        return best;
    }

    private Target getTrapCev() {
        boolean civ = (Boolean)this.instaTrapCev.get();
        Target best = null;
        double distance = 1000.0;
        for (class_742 player : this.enemies) {
            for (class_2350 dir : class_2350.class_2353.field_11062) {
                double d;
                class_2338 pos = new class_2338(player.method_31477(), (int)Math.floor(player.method_5829().field_1325), player.method_31479()).method_10093(dir);
                if ((!civ || !pos.equals((Object)this.civPos)) && this.getBlock(pos) != class_2246.field_10540 || civ && pos.equals((Object)this.civPos) && !(this.getBlock(pos) instanceof class_2189) && this.getBlock(pos) != class_2246.field_10540 || this.getBlock(pos.method_10084()) != class_2246.field_10124 || SettingUtils.oldCrystals() && this.getBlock(pos.method_10086(2)) != class_2246.field_10124 || !SettingUtils.inMineRange(pos) || !SettingUtils.inPlaceRange(pos) || !SettingUtils.inAttackRange(RSCombatInfo.getCrystalBox(pos.method_10084())) || this.blocked(pos.method_10084()) || !this.distanceCheck(civ, pos, distance, d = this.mc.field_1724.method_33571().method_1022(class_243.method_24953((class_2382)pos)))) continue;
                best = new Target(pos, pos.method_10084(), MineType.TrapCev, (double)((Priority)this.trapCevPriority.get()).priority + (civ && pos.equals((Object)this.civPos) ? 0.1 : 0.0), civ, false);
                distance = d;
            }
        }
        return best;
    }

    private Target getSurroundCev() {
        boolean civ = (Boolean)this.instaSurroundCev.get();
        Target best = null;
        double distance = 1000.0;
        for (class_742 player : this.enemies) {
            for (class_2350 dir : class_2350.class_2353.field_11062) {
                double d;
                class_2338 pos = this.getPos(player.method_19538()).method_10093(dir);
                if ((!civ || !pos.equals((Object)this.civPos)) && this.getBlock(pos) != class_2246.field_10540 || civ && pos.equals((Object)this.civPos) && !(this.getBlock(pos) instanceof class_2189) && this.getBlock(pos) != class_2246.field_10540 || this.getBlock(pos.method_10084()) != class_2246.field_10124 || SettingUtils.oldCrystals() && this.getBlock(pos.method_10086(2)) != class_2246.field_10124 || !SettingUtils.inMineRange(pos) || !SettingUtils.inPlaceRange(pos) || !SettingUtils.inAttackRange(RSCombatInfo.getCrystalBox(pos.method_10084())) || this.blocked(pos.method_10084()) || !this.distanceCheck(civ, pos, distance, d = this.mc.field_1724.method_33571().method_1022(class_243.method_24953((class_2382)pos)))) continue;
                best = new Target(pos, pos.method_10084(), MineType.SurroundCev, (double)((Priority)this.surroundCevPriority.get()).priority + (civ && pos.equals((Object)this.civPos) ? 0.1 : 0.0), civ, false);
                distance = d;
            }
        }
        return best;
    }

    private Target getSurroundMiner() {
        boolean civ = (Boolean)this.instaSurroundMiner.get();
        Target best = null;
        double distance = 1000.0;
        for (class_742 player : this.enemies) {
            for (class_2350 dir : class_2350.class_2353.field_11062) {
                double d;
                class_2338 pos = this.getPos(player.method_19538()).method_10093(dir);
                if ((!civ || !pos.equals((Object)this.civPos)) && !BOBlockUtil.solid2(pos) || this.getBlock(pos) == class_2246.field_9987 || !SettingUtils.inMineRange(pos) || !this.distanceCheck(civ, pos, distance, d = this.mc.field_1724.method_33571().method_1022(class_243.method_24953((class_2382)pos)))) continue;
                best = new Target(pos, null, MineType.SurroundMiner, (double)((Priority)this.surroundMinerPriority.get()).priority + (civ && pos.equals((Object)this.civPos) ? 0.1 : 0.0), civ, false);
                distance = d;
            }
        }
        return best;
    }

    private Target getAutoCity() {
        boolean civ = (Boolean)this.instaAutoCity.get();
        Target best = null;
        double distance = 1000.0;
        for (class_742 player : this.enemies) {
            for (class_2350 dir : class_2350.class_2353.field_11062) {
                double d;
                class_2338 pos = this.getPos(player.method_19538()).method_10093(dir);
                if ((!civ || !pos.equals((Object)this.civPos)) && !BOBlockUtil.solid2(pos) || this.getBlock(pos) == class_2246.field_9987 || this.getBlock(pos.method_10093(dir)) != class_2246.field_10124 || SettingUtils.oldCrystals() && this.getBlock(pos.method_10093(dir).method_10084()) != class_2246.field_10124 || !this.crystalBlock(pos.method_10093(dir).method_10074()) || !SettingUtils.inMineRange(pos) || !SettingUtils.inPlaceRange(pos.method_10093(dir).method_10074()) || this.blocked(pos.method_10093(dir)) || !this.distanceCheck(civ, pos, distance, d = this.mc.field_1724.method_33571().method_1022(class_243.method_24953((class_2382)pos)))) continue;
                best = new Target(pos, pos.method_10093(dir), MineType.AutoCity, (double)((Priority)this.autoCityPriority.get()).priority + (civ && pos.equals((Object)this.civPos) ? 0.1 : 0.0), civ, false);
                distance = d;
            }
        }
        return best;
    }

    private Target getAntiBurrow() {
        Target best = null;
        double distance = 1000.0;
        for (class_742 player : this.enemies) {
            double d;
            class_2338 pos = this.getPos(player.method_19538());
            if (!BOBlockUtil.solid2(pos) || this.getBlock(pos) == class_2246.field_9987 || this.getBlock(pos) == class_2246.field_10343 || !SettingUtils.inMineRange(pos) || !((d = this.mc.field_1724.method_33571().method_1022(class_243.method_24953((class_2382)pos))) < distance)) continue;
            best = new Target(pos, null, MineType.AntiBurrow, ((Priority)this.antiBurrowPriority.get()).priority, false, false);
            distance = d;
        }
        return best;
    }

    private boolean distanceCheck(boolean civ, class_2338 pos, double closest, double distance) {
        if (civ && pos.equals((Object)this.civPos)) {
            return true;
        }
        if (this.target != null && pos.equals((Object)this.target.pos)) {
            return true;
        }
        return distance < closest;
    }

    private boolean priorityCheck(Target current, Priority priority) {
        if (priority.priority < 0) {
            return false;
        }
        if (current == null) {
            return true;
        }
        return (double)priority.priority >= current.priority;
    }

    private void abort(class_2338 pos) {
        this.sendPacket((class_2596<?>)new class_2846(class_2846.class_2847.field_12971, pos, class_2350.field_11036));
        this.started = false;
    }

    private class_2248 getBlock(class_2338 pos) {
        return this.mc.field_1687.method_8320(pos).method_26204();
    }

    private class_1268 getHand() {
        if (this.mc.field_1724.method_6079().method_7909() == class_1802.field_8301) {
            return class_1268.field_5810;
        }
        if (Managers.HOLDING.isHolding(class_1802.field_8301)) {
            return class_1268.field_5808;
        }
        return null;
    }

    private boolean miningCheck(int slot) {
        if (this.target == null || this.target.pos == null) {
            return false;
        }
        return this.minedFor * (Double)this.speed.get() >= (double)this.getMineTicks(slot, true);
    }

    private boolean miningCheckDouble(int slot) {
        if (this.breakPos == null) {
            return false;
        }
        return this.minedFor * (Double)this.speed.get() >= (double)this.getMineTicksDouble(slot, true);
    }

    private float getTime(class_2338 pos, int slot, boolean speedMod) {
        class_2680 state = this.mc.field_1687.method_8320(pos);
        float f = state.method_26214((class_1922)this.mc.field_1687, pos);
        if (f == -1.0f) {
            return 0.0f;
        }
        float i = !state.method_29291() || this.mc.field_1724.method_31548().method_5438(slot).method_7951(state) ? 30.0f : 100.0f;
        return this.getSpeed(state, slot, speedMod) / f / i;
    }

    private float getMineTicks(int slot, boolean speedMod) {
        return slot == -1 ? (float)slot : (float)(1.0 / ((double)this.getTime(this.target.pos, slot, speedMod) * (Double)this.speed.get()));
    }

    private float getMineTicksDouble(int slot, boolean speedMod) {
        return slot == -1 ? (float)slot : (float)(1.0 / ((double)this.getTime(this.breakPos, slot, speedMod) * (Double)this.speed.get()));
    }

    private float getSpeed(class_2680 state, int slot, boolean speedMod) {
        int i;
        class_1799 stack = this.mc.field_1724.method_31548().method_5438(slot);
        float f = this.mc.field_1724.method_31548().method_5438(slot).method_7924(state);
        if ((double)f > 1.0 && (i = class_1890.method_8225((class_1887)class_1893.field_9131, (class_1799)stack)) > 0 && !stack.method_7960()) {
            f += (float)(i * i + 1);
        }
        if (!speedMod) {
            return f;
        }
        if (((Boolean)this.effectCheck.get()).booleanValue()) {
            if (class_1292.method_5576((class_1309)this.mc.field_1724)) {
                f = (float)((double)f * (1.0 + (double)((float)(class_1292.method_5575((class_1309)this.mc.field_1724) + 1) * 0.2f)));
            }
            if (this.mc.field_1724.method_6059(class_1294.field_5901)) {
                f = (float)((double)f * Math.pow(0.3, this.mc.field_1724.method_6112(class_1294.field_5901).method_5578() + 1));
            }
        }
        if (((Boolean)this.waterCheck.get()).booleanValue() && this.mc.field_1724.method_5869() && !class_1890.method_8200((class_1309)this.mc.field_1724)) {
            f = (float)((double)f / 5.0);
        }
        if (((Boolean)this.onGroundCheck.get()).booleanValue() && !this.mc.field_1724.method_24828()) {
            f = (float)((double)f / 5.0);
        }
        return f;
    }

    public void onStart(class_2338 pos, class_2350 direction) {
        if (this.target != null && this.target.manual && pos.equals((Object)this.target.pos)) {
            this.abort(this.target.pos);
            this.civPos = null;
            this.target = null;
            return;
        }
        if (this.target != null && this.breakPos == null && !this.mc.field_1687.method_22347(this.target.pos)) {
            this.breakPos = this.targetPos();
        }
        if (((Boolean)this.manualMine.get()).booleanValue() && this.getBlock(pos) != class_2246.field_9987) {
            this.started = false;
            this.target = new Target(pos, null, MineType.Manual, 0.0, (Boolean)this.manualInsta.get(), true);
        }
    }

    public void onAbort(class_2338 pos) {
    }

    public void onStop() {
        this.target = null;
        this.started = false;
    }

    private int fastestSlot() {
        int slot = -1;
        if (this.mc.field_1724 == null || this.mc.field_1687 == null) {
            return -1;
        }
        for (int i = 0; i < (this.pickAxeSwitchMode.get() == SwitchMode.Silent ? 9 : 35); ++i) {
            if (slot != -1 && !(this.mc.field_1724.method_31548().method_5438(i).method_7924(this.mc.field_1687.method_8320(this.target.pos)) > this.mc.field_1724.method_31548().method_5438(slot).method_7924(this.mc.field_1687.method_8320(this.target.pos)))) continue;
            slot = i;
        }
        return slot;
    }

    private int fastestSlotDouble() {
        int slot = -1;
        if (this.mc.field_1724 == null || this.mc.field_1687 == null) {
            return -1;
        }
        if (this.breakPos == null) {
            return -1;
        }
        for (int i = 0; i < (this.pickAxeSwitchMode.get() == SwitchMode.Silent ? 9 : 35); ++i) {
            if (slot != -1 && !(this.mc.field_1724.method_31548().method_5438(i).method_7924(this.mc.field_1687.method_8320(this.breakPos)) > this.mc.field_1724.method_31548().method_5438(slot).method_7924(this.mc.field_1687.method_8320(this.breakPos)))) continue;
            slot = i;
        }
        return slot;
    }

    private Color getColor(Color start, Color end, double progress, double alphaMulti) {
        return new Color(this.lerp(start.r, end.r, progress, 1.0), this.lerp(start.g, end.g, progress, 1.0), this.lerp(start.b, end.b, progress, 1.0), this.lerp(start.a, end.a, progress, alphaMulti));
    }

    private int lerp(double start, double end, double d, double multi) {
        return (int)Math.round((start + (end - start) * d) * multi);
    }

    private boolean crystalBlock(class_2338 pos) {
        return this.getBlock(pos) == class_2246.field_10540 || this.getBlock(pos) == class_2246.field_9987;
    }

    private class_238 getRenderBox(double progress) {
        return new class_238((double)this.target.pos.method_10263() + 0.5 - progress, (double)this.target.pos.method_10264() + 0.5 - progress, (double)this.target.pos.method_10260() + 0.5 - progress, (double)this.target.pos.method_10263() + 0.5 + progress, (double)this.target.pos.method_10264() + 0.5 + progress, (double)this.target.pos.method_10260() + 0.5 + progress);
    }

    private class_238 getRenderBoxDouble(double progress) {
        return new class_238((double)this.breakPos.method_10263() + 0.5 - progress, (double)this.breakPos.method_10264() + 0.5 - progress, (double)this.breakPos.method_10260() + 0.5 - progress, (double)this.breakPos.method_10263() + 0.5 + progress, (double)this.breakPos.method_10264() + 0.5 + progress, (double)this.breakPos.method_10260() + 0.5 + progress);
    }

    private boolean blocked(class_2338 pos) {
        class_238 box = new class_238((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), (double)(pos.method_10263() + 1), (double)(pos.method_10264() + (SettingUtils.cc() ? 1 : 2)), (double)(pos.method_10260() + 1));
        return EntityUtils.intersectsWithEntity((class_238)box, entity -> entity instanceof class_1657 && !entity.method_7325());
    }

    public class_2338 targetPos() {
        return this.target == null ? null : this.target.pos;
    }

    private class_2338 getPos(class_243 vec) {
        return new class_2338((int)Math.floor(vec.field_1352), (int)Math.round(vec.field_1351), (int)Math.floor(vec.field_1350));
    }

    private boolean isAir(class_2338 blockPos) {
        return this.mc.field_1687.method_22347(blockPos) || this.getBlock(blockPos).equals(class_2246.field_10036);
    }

    public static final class SwitchMode
    extends Enum<SwitchMode> {
        public static final /* enum */ SwitchMode Silent = new SwitchMode();
        public static final /* enum */ SwitchMode PickSilent = new SwitchMode();
        public static final /* enum */ SwitchMode InvSwitch = new SwitchMode();
        private static final /* synthetic */ SwitchMode[] $VALUES;

        public static SwitchMode[] values() {
            return (SwitchMode[])$VALUES.clone();
        }

        public static SwitchMode valueOf(String name) {
            return Enum.valueOf(SwitchMode.class, name);
        }

        private static /* synthetic */ SwitchMode[] $values() {
            return new SwitchMode[]{Silent, PickSilent, InvSwitch};
        }

        static {
            $VALUES = SwitchMode.$values();
        }
    }

    public static final class ListMode
    extends Enum<ListMode> {
        public static final /* enum */ ListMode Whitelist = new ListMode();
        public static final /* enum */ ListMode Blacklist = new ListMode();
        private static final /* synthetic */ ListMode[] $VALUES;

        public static ListMode[] values() {
            return (ListMode[])$VALUES.clone();
        }

        public static ListMode valueOf(String name) {
            return Enum.valueOf(ListMode.class, name);
        }

        private static /* synthetic */ ListMode[] $values() {
            return new ListMode[]{Whitelist, Blacklist};
        }

        static {
            $VALUES = ListMode.$values();
        }
    }

    public static final class silenttype
    extends Enum<silenttype> {
        public static final /* enum */ silenttype UpdateSelectedSlotC2SPacket = new silenttype();
        public static final /* enum */ silenttype selectedSlot = new silenttype();
        public static final /* enum */ silenttype ClientselectedSwap = new silenttype();
        private static final /* synthetic */ silenttype[] $VALUES;

        public static silenttype[] values() {
            return (silenttype[])$VALUES.clone();
        }

        public static silenttype valueOf(String name) {
            return Enum.valueOf(silenttype.class, name);
        }

        private static /* synthetic */ silenttype[] $values() {
            return new silenttype[]{UpdateSelectedSlotC2SPacket, selectedSlot, ClientselectedSwap};
        }

        static {
            $VALUES = silenttype.$values();
        }
    }

    public static final class Priority
    extends Enum<Priority> {
        public static final /* enum */ Priority Highest = new Priority(6);
        public static final /* enum */ Priority Higher = new Priority(5);
        public static final /* enum */ Priority High = new Priority(4);
        public static final /* enum */ Priority Normal = new Priority(3);
        public static final /* enum */ Priority Low = new Priority(2);
        public static final /* enum */ Priority Lower = new Priority(1);
        public static final /* enum */ Priority Lowest = new Priority(0);
        public static final /* enum */ Priority Disabled = new Priority(-1);
        public final int priority;
        private static final /* synthetic */ Priority[] $VALUES;

        public static Priority[] values() {
            return (Priority[])$VALUES.clone();
        }

        public static Priority valueOf(String name) {
            return Enum.valueOf(Priority.class, name);
        }

        private Priority(int priority) {
            this.priority = priority;
        }

        private static /* synthetic */ Priority[] $values() {
            return new Priority[]{Highest, Higher, High, Normal, Low, Lower, Lowest, Disabled};
        }

        static {
            $VALUES = Priority.$values();
        }
    }

    public static final class RenderMode
    extends Enum<RenderMode> {
        public static final /* enum */ RenderMode Box = new RenderMode();
        public static final /* enum */ RenderMode Normal = new RenderMode();
        public static final /* enum */ RenderMode Future = new RenderMode();
        public static final /* enum */ RenderMode Shrink = new RenderMode();
        public static final /* enum */ RenderMode Grow = new RenderMode();
        private static final /* synthetic */ RenderMode[] $VALUES;

        public static RenderMode[] values() {
            return (RenderMode[])$VALUES.clone();
        }

        public static RenderMode valueOf(String name) {
            return Enum.valueOf(RenderMode.class, name);
        }

        private static /* synthetic */ RenderMode[] $values() {
            return new RenderMode[]{Box, Normal, Future, Shrink, Grow};
        }

        static {
            $VALUES = RenderMode.$values();
        }
    }

    public record Target(class_2338 pos, class_2338 crystalPos, MineType type, double priority, boolean civ, boolean manual) {
    }

    public static final class MineType
    extends Enum<MineType> {
        public static final /* enum */ MineType Cev = new MineType();
        public static final /* enum */ MineType TrapCev = new MineType();
        public static final /* enum */ MineType SurroundCev = new MineType();
        public static final /* enum */ MineType SurroundMiner = new MineType();
        public static final /* enum */ MineType AutoCity = new MineType();
        public static final /* enum */ MineType AntiBurrow = new MineType();
        public static final /* enum */ MineType Manual = new MineType();
        private static final /* synthetic */ MineType[] $VALUES;

        public static MineType[] values() {
            return (MineType[])$VALUES.clone();
        }

        public static MineType valueOf(String name) {
            return Enum.valueOf(MineType.class, name);
        }

        private static /* synthetic */ MineType[] $values() {
            return new MineType[]{Cev, TrapCev, SurroundCev, SurroundMiner, AutoCity, AntiBurrow, Manual};
        }

        static {
            $VALUES = MineType.$values();
        }
    }
}
