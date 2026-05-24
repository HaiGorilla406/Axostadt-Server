package px86.phantom;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Set;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wfqfvhrotalolctk.ndgrxkgsbanuggor;

public class PhantomCommand implements CommandExecutor {
   private final PhantomPlugin plugin;
   private static int uQNmmaQ7ma;
   private transient int dErckXlAw7;
   private static byte[] rtklppwavp = ouwtibhghxjcsfb();

   public PhantomCommand(PhantomPlugin var1, int var2) {
      int var7 = 721515808 ^ 1960091302;
      super();
      var7 = 1533959427 ^ var7;
      var7 = 533682072 ^ 1496486118 ^ Integer.parseInt("1111912955");
      this.dErckXlAw7 = 784963186 ^ uQNmmaQ7ma;
      var7 = 1872494732 ^ var7;
      var7 = 2023529722 ^ var7;
      this.plugin = var1;
      var7 = 725597915 ^ var7;
   }

   public boolean onCommand(CommandSender var1, Command var2, String var3, String[] var4) {
      int var103 = 865894035 ^ 992722835 ^ 846514557;
      var103 = 690101424 ^ var103;
      int var9 = var4.length;
      if (var9 == (333518029 ^ var103)) {
         var103 = 1218128349 ^ var103;
         String var6 = aifqixdbfz(evbqxqtaprwiwff(), var103);
         var1.sendMessage(var6);
         var103 = 1084415883 ^ var103;
         String var52 = "§7/" + var3 + " reload §8- §fReload configuration";
         var1.sendMessage(var52);
         var103 = 2143589806 ^ var103;
         String var54 = "§7/" + var3 + " debug §8- §fToggle debug info (server-wide)";
         var1.sendMessage(var54);
         var103 = 382087491 ^ var103;
         byte var13 = (byte)(1926907511 ^ var103);
         return (boolean)var13;
      } else {
         label179: {
            label127:
            while(true) {
               switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var103)) {
                  case 109317036:
                     var103 ^= 554531102;
                  case 1299017926:
                     if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var103) != -1755091303) {
                        while(true) {
                           switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var103)) {
                              case 34525513:
                              case 1665062474:
                              default:
                                 throw new IOException();
                              case 44705316:
                                 var103 = 1450385343 ^ var103;
                                 throw new IOException();
                              case 1751645344:
                           }
                        }
                     }

                     var103 = 1362721234 ^ var103;
                     byte var55 = (byte)(1674908673 ^ var103);
                     String var15 = var4[var55];
                     String var56 = aifqixdbfz(vceggpfkjxbcrly(), var103);
                     byte var16 = var15.equalsIgnoreCase(var56);
                     if (var16 != (1674908673 ^ var103)) {
                        var103 = 460286016 ^ var103;
                        String var57 = aifqixdbfz(viukuwjeaoakmcm(), var103);
                        byte var18 = var1.hasPermission(var57);
                        if (var18 == (2025487425 ^ var103)) {
                           var103 = 841513028 ^ var103;
                           String var58 = aifqixdbfz(ggmujzuvesynexq(), var103);
                           var1.sendMessage(var58);
                           var103 = 699365926 ^ var103;
                           byte var20 = (byte)(1664974370 ^ var103);
                           return (boolean)var20;
                        }

                        label105:
                        while(true) {
                           switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var103)) {
                              case 60966793:
                              default:
                                 throw new IOException();
                              case 122072020:
                                 break;
                              case 166275079:
                                 var103 ^= 90632927;
                              case 1730569299:
                                 break label105;
                           }
                        }

                        if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var103) != -287017741) {
                           var103 = rtezdjdluillcdvm(var103, 423886066);
                           throw new IOException();
                        }

                        while(true) {
                           switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var103)) {
                              case 64694670:
                                 var103 ^= 968377801;
                              case 112007428:
                                 break label127;
                              case 442039939:
                                 break;
                              case 1274066506:
                              default:
                                 throw new IOException();
                           }
                        }
                     }

                     var103 = 1905659518 ^ var103;
                     if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var103) == -1843866632) {
                        var103 = 279170168 ^ var103;
                        byte var60 = (byte)(48289287 ^ var103);
                        String var27 = var4[var60];
                        String var61 = aifqixdbfz(qkwsrysdgndsnii(), var103);
                        byte var28 = var27.equalsIgnoreCase(var61);
                        if (var28 == (48289287 ^ var103)) {
                           while(true) {
                              switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var103)) {
                                 case 45271622:
                                    var103 ^= 1273554563;
                                 case 207724218:
                                    if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var103) == 1212253218) {
                                       var103 = 41533586 ^ var103;
                                       String var96 = "§cUnknown subcommand. Use /" + var3 + " for help.";
                                       var1.sendMessage(var96);
                                       var103 = 1778798201 ^ var103;
                                       byte var50 = (byte)(561495662 ^ var103);
                                       return (boolean)var50;
                                    }

                                    var103 = 764887784 ^ var103;
                                    throw new IOException();
                                 case 448218342:
                                 default:
                                    throw new IOException();
                                 case 1108104991:
                              }
                           }
                        }

                        var103 = 1297056503 ^ var103;
                        String var62 = aifqixdbfz(fvbguvyeyukqjbb(), var103);
                        byte var30 = var1.hasPermission(var62);
                        if (var30 == (1336890608 ^ var103)) {
                           var103 = 2087468431 ^ var103;
                           String var94 = aifqixdbfz(qzddhcyoxizcofa(), var103);
                           var1.sendMessage(var94);
                           var103 = 611082668 ^ var103;
                           byte var48 = (byte)(397347026 ^ var103);
                           return (boolean)var48;
                        }

                        var103 = rtezdjdluillcdvm(var103, 1996970567);
                        if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var103) == -985631303) {
                           label124:
                           while(true) {
                              switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var103)) {
                                 case 231056426:
                                    var103 ^= 1245417442;
                                 case 1128597135:
                                    break label124;
                                 case 1510732096:
                                    break;
                                 case 1576700607:
                                 default:
                                    throw new IOException();
                              }
                           }

                           PhantomPlugin var32 = this.plugin;
                           PhantomSettings var33 = var32.getSettings(75366031);
                           var103 = 384500066 ^ var103;
                           String var63 = aifqixdbfz(nhlrpffdodudrth(), var103);
                           var1.sendMessage(var63);
                           var103 = 2075453993 ^ var103;
                           String var7 = aifqixdbfz(ilrjpqigscpejvu(), var103);
                           boolean var65 = var33.isWorldEnabled(var7, 1850584998);
                           String var66 = "§7Worlds: §f" + var65;
                           var1.sendMessage(var66);
                           var103 = 587853466 ^ var103;
                           Set var68 = var33.getHiddenBlocks(942528473);
                           int var69 = var68.size();
                           String var70 = "§7Hidden blocks: §f" + var69;
                           var1.sendMessage(var70);
                           var103 = 1657930807 ^ var103;
                           Material var72 = var33.getMaskBlock(1616534387);
                           String var73 = String.valueOf(var72);
                           String var74 = "§7Mask block: §f" + var73;
                           var1.sendMessage(var74);
                           var103 = 1948435259 ^ var103;
                           double var76 = var33.getMaxRayDistance(312852745);
                           String var78 = "§7Max ray distance: §f" + var76;
                           var1.sendMessage(var78);
                           var103 = 1323776902 ^ var103;
                           int var80 = var33.getMaxRaytraceY(168363115);
                           String var81 = "§7Max raytrace Y: §f" + var80;
                           var1.sendMessage(var81);
                           var103 = 689462520 ^ var103;
                           boolean var83 = var33.isStrictLineOfSight(676039776);
                           String var84 = "§7Strict line-of-sight: §f" + var83;
                           var1.sendMessage(var84);
                           var103 = 369939679 ^ var103;
                           boolean var86 = var33.isDebugLogPackets(1723543762);
                           String var87 = "§7Debug packets: §f" + var86;
                           var1.sendMessage(var87);
                           var103 = 1083922755 ^ var103;
                           boolean var89 = var33.isDebugShowRays(1182425983);
                           String var90 = "§7Debug rays: §f" + var89;
                           var1.sendMessage(var90);
                           var103 = 40454881 ^ var103;
                           byte var44 = var1 instanceof Player;
                           if (var44 != (422896523 ^ var103)) {
                              var103 = 1488935177 ^ var103;
                              Player var98 = (Player)var1;
                              World var99 = var98.getWorld();
                              String var100 = var99.getName();
                              boolean var92 = var33.isWorldEnabled(var100, 1850584998);
                              String var93 = "§7Your world enabled: §f" + var92;
                              var1.sendMessage(var93);
                              var103 = 324976080 ^ var103;
                              break label179;
                           }

                           var103 = rtezdjdluillcdvm(var103, 1883416271);
                           if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var103) == 1269967395) {
                              var103 = 1000555030 ^ var103;
                              break label179;
                           }

                           while(true) {
                              switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var103)) {
                                 case 206917445:
                                    var103 = 233387816 ^ var103;
                                    throw new IOException();
                                 case 325224077:
                                 case 1528766848:
                                 default:
                                    throw new IOException();
                                 case 1624305188:
                              }
                           }
                        }

                        var103 = 1547140315 ^ var103;
                     } else {
                        var103 = 1994156051 ^ var103;
                     }

                     throw new IOException();
                  case 405298658:
                  default:
                     throw new IOException();
                  case 1076553820:
               }
            }

            PhantomPlugin var22 = this.plugin;
            var22.reloadSettings(1558302688);
            var103 = 498320751 ^ var103;
            PacketService var23 = PacketService.getInstance(1114095150);
            var23.refreshListenerTask(1618358190);
            var103 = 736388103 ^ var103;
            String var59 = aifqixdbfz(gbdedsdaahyomca(), var103);
            var1.sendMessage(var59);
            var103 = 1333995144 ^ var103;
            byte var25 = (byte)(1034964150 ^ var103);
            return (boolean)var25;
         }

         byte var46 = (byte)(1389692755 ^ var103);
         return (boolean)var46;
      }
   }

   static {
      int var3 = (new Random(2050579070910914404L)).nextInt();
      uQNmmaQ7ma = -1117037117 ^ var3;
   }

   public static String aifqixdbfz(byte[] var0, int var1) {
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
         byte[] var27 = rtklppwavp;
         byte[] var34 = rtklppwavp;
         int var35 = var34.length;
         int var32 = var7 % var35;
         byte var28 = var27[var32];
         int var22 = var21 ^ var28;
         byte var23 = (byte)var22;
         var0[var7] = var23;
         ++var7;
      }
   }

   private static byte[] ouwtibhghxjcsfb() {
      return new byte[]{1, 58, 125, 122, 112, 14, 94, 5, 31, 126, 125, 21, 94, 54, 99, 124, 14, 4, 57, 44, 86, 21, 4, 85, 97, 80, 107, 110, 9, 85, 121, 70, 15, 46, 17, 123, 116, 23, 92, 1, 27, 13, 79, 83, 99, 13, 108, 82, 31, 32, 121, 46, 59, 103, 93, 12, 103, 111, 41, 116, 1, 74, 17, 69, 18, 75, 66, 9, 45, 39, 83, 99, 99, 60, 57, 91, 29, 14, 92, 74, 62, 9, 90, 108, 79, 47, 11, 82, 17, 8, 125};
   }

   private static byte[] ggmujzuvesynexq() {
      return new byte[]{-50, -9, 72, -20, 64, 85, 109, 110, 41, 40, 76, 82, 107, 39, 83, 32, 61, 89, 15, 53, 103, 73, 49, 11, 81, 28, 88, 124, 63, 4, 72, 21, 58, 105, 33, 38, 71, 5, 106, 72, 42, 90, 122, 16, 83, 88, 95, 9, 41, 106, 72, 111, 14, 63, 109, 91, 84, 51, 31, 109, 48, 12, 36, 27, 34, 83, 113, 78, 27, 109, 98, 52, 86, 45, 9, 23, 46, 84, 106, 26, 15, 72, 111, 125, 127, 116, 56, 15, 39, 92, 76, 94, 15, 45, 74, 38, 61, 8, 51, 8};
   }

   private static byte[] vceggpfkjxbcrly() {
      return new byte[]{-50, -13, 74, 60, 73, 91, 102, 95, 40, 34, 76, 66, 105, 102};
   }

   private static byte[] nhlrpffdodudrth() {
      return new byte[]{-50, -13, 69, -24, 70, 93, 102, 98, 43, 37, 76, 66, 102, 109, 85, 57, 54, 92, 13, 114, 103, 3, 60, 36, 87, 4, 83, 59, 61, 19, 72, 23, 55, 33};
   }

   private static byte[] fvbguvyeyukqjbb() {
      return new byte[]{-50, -10, 78, 60, 72, 95, 110, 82, 47, 40, 76, 82, 109, 111, 91, 40, 62, 28, 9, 119, 103, 73, 55, 14, 89, 4, 91, 57, 57, 3, 72, 17};
   }

   private static byte[] evbqxqtaprwiwff() {
      return new byte[]{-50, -16, 78, -23, 71, 95, 105, 99, 39, 38, 76, 65, 109, 108, 84, 59, 57, 93, 1, 113};
   }

   private static byte[] ilrjpqigscpejvu() {
      return new byte[]{-54, -10, 78, 57, 73, 81, 108, 71, 41, 39, 78, 66};
   }

   private static byte[] viukuwjeaoakmcm() {
      return new byte[]{-51, -11, 79, 63, 68, 94, 105, 80, 45, 37, 79, 81, 108, 108, 87, 41, 57, 30, 11, 122, 100, 74, 54, 13, 85, 5, 92, 59, 59, 14, 75, 18};
   }

   private static byte[] gbdedsdaahyomca() {
      return new byte[]{-50, -4, 76, -24, 73, 88, 108, 100, 42, 47, 76, 77, 111, 109, 90, 63, 60, 90, 12, 120, 103, 12, 53, 3, 88, 8, 89, 49, 60, 10, 72, 22, 62, 124, 40, 57, 70, 84, 105, 89, 42, 64, 126, 15, 90, 85, 94, 13, 42, 57, 72, 101, 10, 55, 100, 87, 85, 49, 28, 44, 48, 23, 32, 21, 43, 24, 112, 22};
   }

   private static byte[] qzddhcyoxizcofa() {
      return new byte[]{-57, -13, 69, -23, 68, 89, 107, 104, 44, 41, 75, 88, 106, 34, 87, 45, 58, 88, 1, 58, 110, 79, 48, 14, 84, 16, 88, 118, 63, 5, 77, 19, 59, 109, 37, 45, 76, 1, 100, 69, 47, 92, 122, 21, 80, 88, 90, 3, 43, 103, 77, 104, 15, 61, 101, 85, 95, 53, 29, 96, 52, 10, 34, 18, 36, 83, 118, 72, 25, 97, 103, 53, 91, 42, 1, 27, 41, 82, 105, 23, 13, 66, 108, 116, 123, 120, 63, 8, 37, 86, 69, 90, 2, 40, 78, 42, 59, 14, 54, 9};
   }

   private static byte[] qkwsrysdgndsnii() {
      return new byte[]{-53, -3, 79, 38, 73, 89, 102, 80, 43, 51, 79, 74};
   }

   private static int rtezdjdluillcdvm(int var0, int var1) {
      return var0 ^ var1;
   }
}
