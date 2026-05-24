package px86.phantom;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import px86.phantom.bstats.bukkit.Metrics;
import wfqfvhrotalolctk.ndgrxkgsbanuggor;

public class PhantomPlugin extends JavaPlugin implements Listener {
   private static PhantomPlugin instance;
   private PhantomSettings settings;
   private static int YegHtUO71m;
   private transient int ivUtcu9W3l;
   private static byte[] pytodqaaob = wcernufbjrdasbb();

   public PhantomPlugin() {
      int var4 = 781202472 ^ 1706744673;
      super();
      var4 = fpbdlqcpcutznkca(var4, 164983711);
      var4 = 1405423442 ^ 669290991 ^ Integer.parseInt("920519275");
      this.ivUtcu9W3l = 1255037689 ^ YegHtUO71m;

      while(true) {
         switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var4)) {
            case 30375201:
               var4 = 1386108256 ^ var4;
            case 1121735801:
               return;
            case 958023844:
            default:
               throw new IllegalAccessException();
            case 2011410798:
         }
      }
   }

   public void onLoad() {
      int var4 = 233042903 ^ 115616271 ^ 87825165;
      var4 = 1992757718 ^ var4;
      instance = this;
      var4 = 904862960 ^ var4;
   }

   public void onEnable() {
      int var36 = 1620665389 ^ 884425257 ^ 87825165;
      var36 = 1947483408 ^ var36;
      this.saveDefaultConfig();
      var36 = 1356355650 ^ var36;
      this.reloadSettings(1558302688);
      var36 = 870330460 ^ var36;
      short var8 = (short)(1178470038 ^ var36);
      var36 = 2002392418 ^ var36;
      Metrics var9 = new Metrics(this, var8);
      var36 = 337389747 ^ var36;
      Logger var31 = this.getLogger();
      DependencyLoader var10 = new DependencyLoader(var31, 1253215777);
      var36 = 1261876595 ^ var36;
      byte var12 = var10.ensureDependencies(45230927);
      if (var12 == (1850663077 ^ var36)) {
         var36 = 1925287695 ^ var36;
         Logger var20 = this.getLogger();
         String var28 = eabhbsbena(vcmqgbwugbckmmg(), var36);
         var20.severe(var28);
         var36 = 2123034049 ^ var36;
         Server var22 = this.getServer();
         PluginManager var23 = var22.getPluginManager();
         var23.disablePlugin(this);
         var36 = 1380802937 ^ var36;
      } else {
         var36 = fpbdlqcpcutznkca(var36, 655406093);
         if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var36) != 1257416002) {
            var36 = fpbdlqcpcutznkca(var36, 626486210);
            throw new IOException();
         } else {
            var36 = 444488293 ^ var36;
            String var24 = eabhbsbena(juuqeqasywbqmtl(), var36);
            PluginCommand var14 = this.getCommand(var24);
            PhantomCommand var25 = new PhantomCommand(this, 1586159169);
            var14.setExecutor(var25);
            var36 = 1558101278 ^ var36;
            PacketService var15 = PacketService.getInstance(1114095150);
            var15.init(this, 160518234);
            var36 = 507890113 ^ var36;
            Server var17 = this.getServer();
            PluginManager var18 = var17.getPluginManager();
            var18.registerEvents(this, this);
            var36 = 1898451759 ^ var36;
         }
      }
   }

   public void onDisable() {
      int var4 = 240304157 ^ 231742848 ^ 87825165;
      var4 = 354223262 ^ var4;
      PacketService var1 = PacketService.getInstance(1114095150);
      var1.shutdown(688304050);
      var4 = 1482642927 ^ var4;
   }

   @EventHandler
   public void onPlayerJoin(PlayerJoinEvent var1) {
      int var7 = 415143341 ^ 846010501 ^ 87825165;
      var7 = 1593449355 ^ var7;
      PacketService var2 = PacketService.getInstance(1114095150);
      Player var4 = var1.getPlayer();
      var2.onPlayerJoin(var4, 1282157782);
      var7 = 222744980 ^ var7;
   }

   public static PhantomPlugin getInstance() {
      int var3 = 322572249 ^ 1259647312 ^ 1341276660;
      var3 = 857812317 ^ var3;
      PhantomPlugin var0 = instance;
      return var0;
   }

   public PhantomSettings getSettings(int var1) {
      int var5 = 2092617754 ^ 1441700116 ^ 87825165;
      var5 = 846419239 ^ var5;
      PhantomSettings var3 = this.settings;
      return var3;
   }

   public void reloadSettings(int var1) {
      int var10 = 1032121372 ^ 1544766736 ^ 87825165;
      var10 = 1641003739 ^ var10;
      this.reloadConfig();
      var10 = 1533868000 ^ var10;
      FileConfiguration var6 = this.getConfig();
      var10 = 678772766 ^ var10;
      PhantomSettings var8 = PhantomSettings.fromConfig(var6, 233926248);
      this.settings = var8;
      var10 = 1073760011 ^ var10;
   }

   static {
      int var3 = (new Random(-7853075103802876956L)).nextInt();
      YegHtUO71m = 350263891 ^ var3;
   }

   public static String eabhbsbena(byte[] var0, int var1) {
      String var8 = Integer.toString(var1);
      byte[] var9 = var8.getBytes();
      byte[] var6 = var9;
      byte var10 = 0;
      int var7 = var10;

      while(true) {
         int var15 = var0.length;
         if (var7 >= var15) {
            Charset var29 = StandardCharsets.UTF_16;
            String var14 = new String(var0, var29);
            return var14;
         }

         byte var18 = var0[var7];
         int var33 = var6.length;
         int var30 = var7 % var33;
         byte var26 = var6[var30];
         int var19 = var18 ^ var26;
         byte var20 = (byte)var19;
         var0[var7] = var20;
         byte var21 = var0[var7];
         byte[] var27 = pytodqaaob;
         byte[] var34 = pytodqaaob;
         int var35 = var34.length;
         int var32 = var7 % var35;
         byte var28 = var27[var32];
         int var22 = var21 ^ var28;
         byte var23 = (byte)var22;
         var0[var7] = var23;
         ++var7;
      }
   }

   private static byte[] wcernufbjrdasbb() {
      return new byte[]{91, 7, 12, 98, 36, 66, 48, 83, 57, 74, 3, 16, 66, 100, 122, 53, 103, 68, 33, 7, 68, 31, 65, 76, 9, 81, 96, 91, 2, 65, 65, 64, 48, 34, 84, 105, 19, 48, 14, 105, 111, 121, 114, 46, 33, 110, 61, 17};
   }

   private static byte[] vcmqgbwugbckmmg() {
      return new byte[]{-111, -49, 53, 30, 18, 25, 2, 24, 11, 13, 52, 64, 115, 60, 72, 96, 95, 86, 21, 84, 125, 75, 119, 14, 59, 12, 82, 1, 53, 28, 112, 19, 2, 126, 108, 56, 39, 110, 55, 61, 89, 56, 64, 56, 19, 122, 10, 120, 106, 93, 62, 53, 28, 17, 4, 23, 0, 30, 53, 2, 112, 46, 72, 100, 80, 14, 16, 69, 118, 76, 121, 12, 61, 18, 89, 74, 52, 7, 115, 16, 2, 115, 99, 112, 34, 117, 60, 62, 87, 57, 70, 111, 24, 58, 11, 81, 105, 31, 62, 55, 19, 29, 1, 17, 11, 29, 59, 80, 118, 115, 67, 96, 81, 25, 19, 72, 118, 69, 118, 25, 56, 8, 82, 8, 58, 23, 117, 87, 9, 112, 98, 52, 33, 101, 60, 45, 88, 44, 67, 125, 19, 40, 5, 70, 111, 67, 53, 125};
   }

   private static byte[] juuqeqasywbqmtl() {
      return new byte[]{-108, -53, 53, 38, 18, 26, 9, 10, 15, 29, 50, 87, 123, 63, 76, 104};
   }

   private static int fpbdlqcpcutznkca(int var0, int var1) {
      return var1 ^ var0;
   }
}
