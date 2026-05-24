package px86.phantom;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import wfqfvhrotalolctk.ndgrxkgsbanuggor;

public class DependencyLoader {
   private static final String PACKETEVENTS_VERSION = "2.11.1";
   private static final String PACKETEVENTS_URL = "https://github.com/retrooper/packetevents/releases/download/v2.11.1/packetevents-spigot-2.11.1.jar";
   private static final String PACKETEVENTS_FILENAME = "packetevents-spigot-2.11.1.jar";
   private final Logger logger;
   private static int rO5WeaAzSE;
   private transient int cJLud4zbUw;

   public DependencyLoader(Logger var1, int var2) {
      int var7 = 803955501 ^ 936211304;
      super();

      while(true) {
         switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var7)) {
            case 248096675:
               var7 = 1271920580 ^ var7;
            case 1543944905:
               var7 = 1574373186 ^ 1321839706 ^ Integer.parseInt("1089948825");
               this.cJLud4zbUw = 1362816882 ^ rO5WeaAzSE;
               var7 = 163968072 ^ var7;
               var7 = 527767981 ^ var7;
               this.logger = var1;
               var7 = 472717182 ^ var7;
               return;
            case 545752683:
            default:
               throw new IOException();
            case 969052074:
         }
      }
   }

   public boolean ensureDependencies(int var1) {
      int var42 = 690830418 ^ 272928209 ^ 1892142988;
      var42 = 992588982 ^ var42;
      byte var8 = this.isPacketEventsPresent(1042000311);
      if (var8 != (1921501881 ^ var42)) {
         var42 = 1940503764 ^ var42;
         byte var32 = (byte)(19822188 ^ var42);
         return (boolean)var32;
      } else {
         var42 = thanntktjyhmlqqn(var42, 1889314442);
         if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var42) != 282812824) {
            while(true) {
               switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var42)) {
                  case 33142644:
                     var42 = 1622690283 ^ var42;
                     throw new IllegalAccessException();
                  case 759438740:
                     break;
                  case 1439640042:
                  case 1809123750:
                  default:
                     throw new IllegalAccessException();
               }
            }
         } else {
            while(true) {
               switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var42)) {
                  case 6067360:
                  default:
                     throw new IllegalAccessException();
                  case 33142644:
                     var42 ^= 724731510;
                  case 155826152:
                     Logger var10 = this.logger;
                     String var3 = exgnrxxxhy(xhlvhqsqqlwxfud(), wsfmbodmredyuhi(), var42);
                     var10.warning(var3);
                     var42 = 2108481309 ^ var42;
                     File var11 = Bukkit.getPluginsFolder();
                     var42 = 1542499142 ^ var42;
                     String var5 = exgnrxxxhy(qpoajxrzuyjxiiz(), wsfmbodmredyuhi(), var42);
                     File var12 = new File(var11, var5);
                     var42 = 682204078 ^ var42;
                     byte var14 = var12.exists();
                     if (var14 != (668730800 ^ var42)) {
                        var42 = 1600299099 ^ var42;
                        Logger var16 = this.logger;
                        String var33 = exgnrxxxhy(wgiwkmiqmgoruay(), wsfmbodmredyuhi(), var42);
                        var16.info(var33);
                        var42 = 1457360464 ^ var42;
                        boolean var18 = this.loadAndEnablePlugin(var12, 546217355);
                        return var18;
                     }

                     var42 = thanntktjyhmlqqn(var42, 1907961100);
                     if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var42) != -1289140766) {
                        var42 = thanntktjyhmlqqn(var42, 885394788);
                        throw new IllegalAccessException();
                     } else {
                        var42 = thanntktjyhmlqqn(var42, 1385465963);
                        byte var20 = this.downloadPacketEvents(var12, 1393851579);
                        if (var20 != (82944215 ^ var42)) {
                           var42 = 1542576506 ^ var42;
                           Logger var22 = this.logger;
                           String var36 = exgnrxxxhy(fzpllpqyusxmzbe(), wsfmbodmredyuhi(), var42);
                           var22.info(var36);
                           var42 = 854446090 ^ var42;
                           Logger var24 = this.logger;
                           String var37 = exgnrxxxhy(ssqtfwrbgsxpezy(), wsfmbodmredyuhi(), var42);
                           var24.info(var37);
                           var42 = 538115855 ^ var42;
                           boolean var26 = this.loadAndEnablePlugin(var12, 546217355);
                           return var26;
                        }

                        while(true) {
                           switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var42)) {
                              case 66386896:
                              default:
                                 throw new IllegalAccessException();
                              case 77759032:
                                 var42 ^= 1788684066;
                              case 1001490002:
                                 if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var42) == 1935949739) {
                                    var42 = 389115708 ^ var42;
                                    Logger var28 = this.logger;
                                    String var39 = exgnrxxxhy(vzinvpfqvafbfzy(), wsfmbodmredyuhi(), var42);
                                    var28.severe(var39);
                                    var42 = 214979153 ^ var42;
                                    Logger var30 = this.logger;
                                    String var40 = exgnrxxxhy(ydncwswwukdlgrd(), wsfmbodmredyuhi(), var42);
                                    var30.severe(var40);
                                    var42 = 1805949177 ^ var42;
                                    byte var31 = (byte)(506012257 ^ var42);
                                    return (boolean)var31;
                                 }

                                 var42 = thanntktjyhmlqqn(var42, 214934061);
                                 throw new IllegalAccessException();
                              case 1251221988:
                           }
                        }
                     }
                  case 1082540704:
               }
            }
         }
      }
   }

   private boolean loadAndEnablePlugin(File var1, int var2) {
      int var35 = 1148321673 ^ 952465042 ^ 1892142988;
      var35 = 1777749396 ^ var35;

      Exception var10000;
      label101: {
         Plugin var5;
         try {
            PluginManager var3 = Bukkit.getPluginManager();
            Plugin var6 = var3.loadPlugin(var1);
            var5 = var6;
            var35 = 319435836 ^ var35;
            if (var6 == null) {
               var35 = 1540275226 ^ var35;
               Logger var24 = this.logger;
               String var32 = exgnrxxxhy(tdhqsmckfljgacq(), wsfmbodmredyuhi(), var35);
               var24.severe(var32);
               var35 = 1361020020 ^ var35;
               byte var25 = (byte)(2086537041 ^ var35);
               var35 = 857422697 ^ var35;
               return (boolean)var25;
            }
         } catch (Exception var38) {
            var10000 = var38;
            switch (ndgrxkgsbanuggor.faedkcpobufxcypy(var35)) {
               case -1267074565 -> var35 = 239471042 ^ var35;
break label101;
               case -487572853 -> var35 = 77017516 ^ var35;
break label101;
               case 740841499 -> var35 = 491535870 ^ var35;
break label101;
               case 1779177769 -> var35 = 1435022808 ^ var35;
break label101;
               default -> throw new IOException("Error in hash");
            }
         }

         var35 = 657659358 ^ var35;
         if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var35) != -1914611958) {
            while(true) {
               switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var35)) {
                  case 240960175:
                     var35 = 220929721 ^ var35;
                     throw new IllegalAccessException();
                  case 1392874295:
                     break;
                  case 1629218810:
                  case 1860821917:
                  default:
                     throw new IllegalAccessException();
               }
            }
         } else {
            label92:
            while(true) {
               switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var35)) {
                  case 240960175:
                     var35 ^= 614700338;
                  case 76589105:
                     try {
                        var5.onLoad();
                        var35 = 891268180 ^ var35;
                        PluginManager var9 = Bukkit.getPluginManager();
                        var9.enablePlugin(var5);
                        var35 = 212527369 ^ var35;
                        byte var11 = var5.isEnabled();
                        if (var11 != (1286273678 ^ var35)) {
                           var35 = 1237268491 ^ var35;
                           Logger var13 = this.logger;
                           String var27 = exgnrxxxhy(cpxysoielenzngu(), wsfmbodmredyuhi(), var35);
                           var13.info(var27);
                           var35 = 1974378812 ^ var35;
                           byte var14 = (byte)(1891328952 ^ var35);
                           var35 = 1606549929 ^ var35;
                           return (boolean)var14;
                        }
                     } catch (Exception var37) {
                        var10000 = var37;
                        switch (ndgrxkgsbanuggor.faedkcpobufxcypy(var35)) {
                           case -2049237557 -> var35 = thanntktjyhmlqqn(var35, 141710660);
break label92;
                           case -1459749221 -> var35 = 232163630 ^ var35;
break label92;
                           case 39994 -> var35 = thanntktjyhmlqqn(var35, 952706426);
break label92;
                           case 682497064 -> var35 = 2111632504 ^ var35;
break label92;
                           case 1700254834 -> var35 = 878955635 ^ var35;
break label92;
                           default -> throw new RuntimeException("Error in hash");
                        }
                     }

                     while(true) {
                        switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var35)) {
                           case 76220889:
                              var35 ^= 1875363606;
                           case 841673211:
                              if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var35) == 459926721) {
                                 var35 = 592772449 ^ var35;

                                 try {
                                    Logger var21 = this.logger;
                                    String var31 = exgnrxxxhy(mfjjxyfuhfhtdik(), wsfmbodmredyuhi(), var35);
                                    var21.severe(var31);
                                    var35 = 82705469 ^ var35;
                                    byte var22 = (byte)(81018052 ^ var35);
                                    var35 = 1617340590 ^ var35;
                                    return (boolean)var22;
                                 } catch (Exception var36) {
                                    var10000 = var36;
                                    switch (ndgrxkgsbanuggor.faedkcpobufxcypy(var35)) {
                                       case 30279624 -> var35 = 2029057540 ^ var35;
break label92;
                                       case 648144416 -> var35 = thanntktjyhmlqqn(var35, 2082277945);
break label92;
                                       default -> throw new RuntimeException("Error in hash");
                                    }
                                 }
                              }

                              var35 = 2147092928 ^ var35;
                              throw new IllegalAccessException();
                           case 403885886:
                              break;
                           case 1570417231:
                           default:
                              throw new IllegalAccessException();
                        }
                     }
                  case 460375343:
                  default:
                     throw new IllegalAccessException();
                  case 1876720538:
               }
            }
         }
      }

      Exception var15 = var10000;
      var35 = 1433670703 ^ var35;
      Logger var17 = this.logger;
      String var29 = var15.getMessage();
      String var30 = "Failed to load PacketEvents: " + var29;
      var17.severe(var30);
      var35 = 325693631 ^ var35;
      var15.printStackTrace();
      var35 = 295549304 ^ var35;
      byte var19 = (byte)(793324309 ^ var35);
      return (boolean)var19;
   }

   private boolean isPacketEventsPresent(int var1) {
      int var7 = 240603487 ^ 1822659524 ^ 1892142988;
      var7 = 1881782656 ^ var7;
      PluginManager var2 = Bukkit.getPluginManager();
      String var3 = exgnrxxxhy(ygmabaucxgldbyq(), wsfmbodmredyuhi(), var7);
      Plugin var4 = var2.getPlugin(var3);
      byte var5;
      if (var4 != null) {
         var7 = 1814979944 ^ var7;
         var5 = (byte)(238342654 ^ var7);
         var7 = thanntktjyhmlqqn(var7, 2004724257);
         return (boolean)var5;
      } else {
         while(true) {
            switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var7)) {
               case 236183550:
                  var7 ^= 129100436;
               case 1251870195:
                  if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var7) == 760934427) {
                     var7 = thanntktjyhmlqqn(var7, 1856136658);
                     var5 = (byte)(185154513 ^ var7);
                     var7 = 1916813327 ^ var7;
                     return (boolean)var5;
                  }

                  var7 = 1486119348 ^ var7;
                  throw new RuntimeException();
               case 1247853339:
               default:
                  throw new RuntimeException();
               case 1949712956:
            }
         }
      }
   }

   private boolean downloadPacketEvents(File param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   static {
      int var3 = (new Random(2645177471824342782L)).nextInt();
      rO5WeaAzSE = 1292546800 ^ var3;
   }

   public static String exgnrxxxhy(byte[] var0, byte[] var1, int var2) {
      String var9 = Integer.toString(var2);
      byte[] var10 = var9.getBytes();
      byte[] var7 = var10;
      byte var11 = 0;
      int var8 = var11;

      while(true) {
         int var16 = var0.length;
         if (var8 >= var16) {
            Charset var30 = StandardCharsets.UTF_16;
            String var15 = new String(var0, var30);
            return var15;
         }

         byte var19 = var0[var8];
         int var34 = var7.length;
         int var31 = var8 % var34;
         byte var27 = var7[var31];
         int var20 = var19 ^ var27;
         byte var21 = (byte)var20;
         var0[var8] = var21;
         byte var22 = var0[var8];
         int var36 = var1.length;
         int var33 = var8 % var36;
         byte var29 = var1[var33];
         int var23 = var22 ^ var29;
         byte var24 = (byte)var23;
         var0[var8] = var24;
         ++var8;
      }
   }

   private static byte[] wsfmbodmredyuhi() {
      return new byte[]{19, 32, 82, 56, 29, 28, 120, 2, 53, 83, 115, 104, 11, 41, 1, 13, 90, 62, 37, 41, 127, 91, 64, 11, 56, 40, 48, 23, 83, 67, 19, 14, 41, 72, 77, 76, 81, 11, 72, 79, 25, 12, 43, 33, 108, 39, 14, 91, 55, 44, 3, 124, 38, 73, 83, 8, 29, 105, 64, 50, 2, 88, 13, 58, 10, 43, 111, 45, 105, 20, 71, 40, 16, 69, 74, 78, 104, 96, 8, 77, 121, 27, 127};
   }

   private static byte[] ssqtfwrbgsxpezy() {
      return new byte[]{-36, -25, 102, 77, 47, 81, 74, 70, 5, 1, 66, 61, 63, 109, 51, 64, 104, 103, 21, 112, 78, 4, 116, 31, 10, 101, 2, 72, 99, 84, 34, 90, 29, 19, 127, 20, 99, 95, 120, 88, 40, 100, 31, 116, 94, 125, 60, 0, 7, 126, 50, 48, 18, 56, 97, 71, 47, 60, 112, 107, 51, 20, 57, 125, 56, 60, 93, 51, 89, 13};
   }

   private static byte[] vzinvpfqvafbfzy() {
      return new byte[]{-33, -17, 97, 72, 44, 68, 79, 94, 2, 8, 65, 61, 56, 123, 48, 20, 109, 127, 18, 113, 77, 75, 115, 89, 9, 126, 7, 85, 100, 26, 33, 82, 26, 17, 124, 20, 102, 90, 127, 88, 43, 108, 24, 118, 93, 125, 57, 5, 0, 126, 49, 56, 21, 58, 98, 71, 42, 57, 119, 107, 48, 28, 62, 127, 59, 60, 88, 56, 94, 115, 117, 116, 35, 22, 123, 22, 95, 38, 63, 31, 75, 11, 76, 76, 17, 5, 15, 91, 43, 59, 48, 100, 96, 41, 89, 94, 30, 20, 58, 4, 12, 97, 26, 105, 106, 20, 60, 108, 31, 105, 37, 22, 112, 68, 63, 124, 127, 20, 123, 31, 57, 88, 124, 73, 61, 96, 22, 54, 16, 84, 105, 61};
   }

   private static byte[] wgiwkmiqmgoruay() {
      return new byte[]{-33, -17, 96, 93, 42, 75, 72, 83, 6, 13, 65, 61, 57, 104, 54, 126, 106, 122, 22, 121, 77, 5, 114, 74, 15, 109, 0, 5, 96, 28, 33, 95, 27, 15, 122, 90, 97, 92, 123, 2, 43, 85, 25, 103, 91, 101, 62, 26, 4, 53, 49, 108, 20, 29, 100, 74, 45, 47, 115, 98, 48, 5, 63, 127, 61, 105, 95, 118, 90, 79, 117, 127, 34, 80, 125, 12, 88, 61, 59, 88, 75, 71, 77, 73, 23, 5, 8, 75, 47, 109, 48, 108, 97, 50, 95, 19, 25, 29, 62, 65};
   }

   private static byte[] xhlvhqsqqlwxfud() {
      return new byte[]{-37, -26, 98, 94, 44, 79, 64, 81, 0, 14, 74, 61, 61, 108, 51, 112, 106, 125, 19, 117, 79, 3, 113, 77, 0, 107, 5, 1, 106, 29, 37, 80, 27, 4, 125, 89, 103, 84, 120, 22, 40, 75, 19, 127, 89, 117, 55, 74, 1, 61, 49, 5, 22, 8, 101, 69, 45, 58, 113, 109, 58, 24, 56, 120, 51, 114, 89, 114, 91, 75, 119, 61, 38, 8, 122, 23, 89, 114, 48, 25, 76, 66, 70, 84, 22, 13, 10, 73, 44, 34, 52, 109, 99, 33, 89, 23, 17, 31, 56, 66};
   }

   private static byte[] fzpllpqyusxmzbe() {
      return new byte[]{-36, -22, 107, 91, 37, 75, 78, 87, 3, 1, 66, 56, 50, 110, 57, 126, 108, 126, 19, 117, 78, 0, 121, 76, 0, 109, 6, 1, 101, 30, 34, 84, 16, 12, 117, 20, 103, 81, 126, 25, 40, 88, 18, 118, 84, 116, 56, 9, 1, 53, 50, 58, 31, 15, 107, 93, 43, 60, 118, 110, 51, 30, 52, 122, 50, 123, 89, 110, 95, 65, 118, 113, 41, 15, 114, 89};
   }

   private static byte[] ydncwswwukdlgrd() {
      return new byte[]{-36, -26, 101, 98, 47, 90, 74, 64, 4, 21, 66, 34, 60, 33, 51, 16, 104, 39, 20, 120, 78, 11, 119, 77, 10, 114, 2, 84, 98, 23, 34, 25, 30, 25, 127, 17, 99, 80, 121, 86, 40, 71, 28, 118, 94, 97, 60, 31, 6, 117, 50, 42, 17, 11, 97, 95, 47, 45, 113, 43, 51, 17, 58, 105, 56, 122, 93, 112, 88, 71, 118, 101, 39, 18, 120, 10, 90, 51, 57, 21, 72, 86, 72, 82, 18, 79, 10, 89, 45, 43, 51, 96, 100, 36, 90, 88, 27, 68, 60, 9, 15, 111};
   }

   private static byte[] qpoajxrzuyjxiiz() {
      return new byte[]{-33, -22, 107, 123, 43, 75, 76, 82, 5, 10, 70, 52, 56, 107, 55, 92, 105, 120, 23, 121, 70, 6, 118, 73, 12, 104, 0, 8, 102, 9, 32, 72, 31, 21, 126, 27, 99, 81, 113, 8, 47, 23, 31, 32, 92, 59, 59, 83, 4, 43, 53, 102, 21, 72, 97, 19, 36, 48, 118, 101, 54, 25};
   }

   private static byte[] mfjjxyfuhfhtdik() {
      return new byte[]{-34, -24, 106, 92, 36, 72, 75, 82, 2, 0, 71, 52, 62, 110, 50, 127, 98, 124, 28, 121, 76, 6, 119, 71, 12, 98, 5, 4, 96, 18, 43, 91, 16, 20, 126, 19, 102, 86, 124, 18, 44, 31, 24, 98, 84, 124, 55, 78, 4, 122, 52, 42, 18, 17, 102, 89, 46, 50, 120, 99};
   }

   private static byte[] tdhqsmckfljgacq() {
      return new byte[]{-38, -22, 107, 76, 43, 69, 73, 88, 6, 8, 70, 52, 57, 123, 57, 28, 105, 121, 18, 115, 70, 73, 118, 95, 9, 116, 3, 65, 102, 30, 33, 24, 17, 41, 126, 30, 102, 93, 113, 22, 47, 81, 26, 102, 95, 85, 59, 20, 5, 127, 59, 35, 21, 14, 100, 78, 36, 123, 118, 39, 51, 75, 62, 97, 63, 125, 93, 122, 81, 65, 116, 75, 39, 28, 115, 9, 94, 63, 57, 23, 74, 66, 74, 10, 18, 22, 0, 73, 47, 63, 53, 117, 106, 51, 94, 93, 24, 87, 62, 9, 11, 60, 27, 39, 99, 4, 56, 103, 31, 105};
   }

   private static byte[] cpxysoielenzngu() {
      return new byte[]{-43, -22, 97, 89, 47, 76, 75, 82, 13, 13, 64, 60, 57, 108, 50, 123, 98, 125, 22, 125, 77, 4, 115, 76, 0, 110, 3, 6, 97, 30, 32, 82, 17, 28, 126, 25, 99, 95, 123, 24, 33, 25, 24, 113, 94, 120, 61, 12, 15, 57, 48, 40, 20, 22, 96, 90, 37, 62, 115, 111, 48, 12, 62, 109, 50, 62, 92, 111, 91, 80, 116, 120, 40, 19, 121, 26, 90, 34, 59, 13, 65, 72, 76, 87, 18, 15, 11, 66, 36, 52, 49, 37};
   }

   private static byte[] ygmabaucxgldbyq() {
      return new byte[]{-36, -23, 102, 125, 36, 76, 79, 82, 6, 13, 66, 59, 63, 104, 56, 89, 109, 123, 22, 121, 78, 3, 116, 74, 1, 106};
   }

   private static byte[] zoytodkwenbqbws() {
      return new byte[]{-36, -20, 97, 68, 43, 65, 74, 69, 13, 11, 66, 55, 56, 126, 55, 94, 104, 106, 29, 118, 78, 6, 115, 84, 14, 58, 2, 119, 107, 20, 34, 94, 26, 27, 123, 27, 99, 79, 112, 60, 40, 73, 24, 124, 90, 123, 60, 31, 15, 105, 50, 111, 21, 23, 101, 72, 47, 54, 120, 105, 51, 81, 62, 34, 60, 113, 93, 105, 81, 86, 118, 107, 35, 14, 124, 70, 90, 127, 48, 84, 72, 79, 76, 66, 22, 20, 10, 69, 36, 59, 51, 100, 96, 101, 94, 90, 27, 94, 53, 1, 15, 57, 26, 53, 109, 23, 57, 124, 16, 116, 38, 15, 112, 68, 56, 107, 122, 24, 116, 21, 58, 84, 124, 81, 58, 120, 19, 63, 31, 83, 106, 97, 31, 79, 74, 113, 123, 21, 48, 78, 88, 29, 1, 78, 110, 76, 8, 21, 19, 43, 28, 63, 39, 19, 30, 71, 119, 27, 118, 45, 81, 94, 126, 50, 45, 98, 33, 116, 106, 97, 44, 88, 75, 84, 3, 13, 65, 55, 51, 126, 48, 90, 105, 41, 19, 109, 77, 89, 120, 19, 9, 42, 3, 30, 101, 95, 33, 15, 17, 81, 124, 15, 98, 82, 126, 30, 43, 87, 19, 114, 93, 96, 61, 6, 1, 104, 49, 41, 30, 17, 98, 79, 46, 34, 118, 45, 48, 27, 53, 124, 59, 113, 92, 114, 95, 73, 117, 108, 40, 94, 123, 79, 91, 118, 62, 78, 75, 26, 71, 11, 17, 80, 11, 11, 42, 32, 48, 100, 107, 55};
   }

   private static byte[] qwtuvzihdxhxmsw() {
      return new byte[]{-36, -20, 102, 102, 41, 80, 78, 69, 4, 21, 66, 40, 63, 37, 53, 26, 108, 34, 20, 120, 78, 1, 116, 73, 12, 120, 6, 81, 98, 23, 34, 19, 29, 29, 121, 27, 103, 85, 121, 86, 40, 77, 31, 114, 88, 107, 56, 26, 6, 117, 50, 32, 18, 15, 103, 85, 43, 40, 113, 43, 51, 27, 57, 109, 62, 112, 89, 117, 88, 71, 118, 111, 36, 22, 126, 0, 94, 54, 57, 21, 72, 92, 75, 86, 20, 69, 14, 92, 45, 43, 51, 106, 103, 32, 92, 82, 31, 65, 60, 9, 15, 101, 29, 102, 111, 28, 61, 100, 25, 113, 38, 14, 119, 73, 58, 126, 126, 31, 125, 3, 58, 84, 123, 89, 56, 33, 23, 113, 22, 9, 106, 53, 24, 27, 72, 47, 127, 79, 57, 91, 88, 18, 6, 87, 108, 94, 12, 92, 26, 45, 28, 63, 32, 7, 28, 77, 115, 23, 127, 42, 81, 72, 121, 98, 47, 52, 37, 99, 99, 103, 44, 72, 76, 91, 1, 31, 69, 118, 58, 45, 48, 16, 110, 57, 17, 32, 73, 70, 113, 12, 9, 53, 4, 75, 103, 26, 37, 79};
   }

   private static int thanntktjyhmlqqn(int var0, int var1) {
      return var1 ^ var0;
   }
}
