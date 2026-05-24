package px86.phantom;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.event.EventManager;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import wfqfvhrotalolctk.ndgrxkgsbanuggor;

public class PacketService {
   private static final PacketService INSTANCE;
   private boolean initialized;
   private PhantomPacketListener listener;
   private static int Ks5XvJ8xnz;
   private transient int wmvsp1OJ9L;
   private static String tvftgxxhku;

   public PacketService() {
      int var6 = 1242021226 ^ 1340542144;
      super();
      var6 = 2000976448 ^ var6;
      var6 = 1671321710 ^ 964968080 ^ Integer.parseInt("683584788");
      this.wmvsp1OJ9L = 1207846546 ^ Ks5XvJ8xnz;

      while(true) {
         switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var6)) {
            case 236927409:
               var6 ^= 46659612;
            case 1946050371:
               var6 = 375518145 ^ var6;
               boolean var2 = false;
               this.initialized = var2;
               return;
            case 502226184:
               break;
            case 812174306:
            default:
               throw new IOException();
         }
      }
   }

   public static PacketService getInstance(int var0) {
      int var3 = 1344517807 ^ 97464413 ^ 1941447568;
      var3 = 1655825863 ^ var3;
      PacketService var1 = INSTANCE;
      return var1;
   }

   public void init(Plugin var1, int var2) {
      int var23 = 919807637 ^ 735333147 ^ 877028610;
      var23 = 1224446679 ^ var23;
      byte var6 = this.initialized;
      if (var6 != (1639619163 ^ var23)) {
         var23 = 1860811906 ^ var23;
      } else {
         var23 = nqaczejydwlonnvu(var23, 2072015423);
         if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var23) != -774421728) {
            var23 = 492554728 ^ var23;
            throw new IllegalAccessException();
         } else {
            var23 = 490363125 ^ var23;
            PacketEventsAPI var8 = SpigotPacketEventsBuilder.build(var1);
            PacketEvents.setAPI(var8);
            var23 = 1917285365 ^ var23;
            PacketEventsAPI var9 = PacketEvents.getAPI();
            var9.load();
            var23 = 667977675 ^ var23;
            PhantomPlugin var21 = (PhantomPlugin)var1;
            PhantomPacketListener var4 = new PhantomPacketListener(var21, 1373198581);
            this.listener = var4;
            var23 = 1698579862 ^ var23;
            PacketEventsAPI var11 = PacketEvents.getAPI();
            EventManager var12 = var11.getEventManager();
            PhantomPacketListener var19 = this.listener;
            var12.registerListener(var19);
            var23 = 1362023535 ^ var23;
            PacketEventsAPI var14 = PacketEvents.getAPI();
            var14.init();
            var23 = 1645209999 ^ var23;
            PhantomPacketListener var16 = this.listener;
            var16.refreshTask(578113035);
            var23 = 709601953 ^ var23;
            byte var20 = (byte)(784569977 ^ var23);
            this.initialized = (boolean)var20;
            var23 = 390734169 ^ var23;
         }
      }
   }

   public void refreshListenerTask(int var1) {
      int var9 = 130032111 ^ 2006135031 ^ 877028610;
      var9 = 1743255782 ^ var9;
      byte var3 = this.initialized;
      if (var3 != (603098364 ^ var9)) {
         var9 = 1418578588 ^ var9;
         PhantomPacketListener var5 = this.listener;
         if (var5 == null) {
            var9 = 1317602209 ^ var9;
            return;
         }

         var9 = nqaczejydwlonnvu(var9, 35628891);
         if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var9) == -1425602085) {
            var9 = nqaczejydwlonnvu(var9, 562078070);
            PhantomPacketListener var7 = this.listener;
            var7.refreshTask(578113035);
            var9 = 1116767420 ^ var9;
            return;
         }

         var9 = nqaczejydwlonnvu(var9, 696326282);
      } else {
         label34:
         while(true) {
            switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var9)) {
               case 94753498:
                  var9 ^= 1438963452;
                  break label34;
               case 1415270065:
               default:
                  throw new IllegalAccessException();
               case 1635654961:
                  break;
               case 1865678227:
                  break label34;
            }
         }

         if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var9) == -1313681405) {
            var9 = nqaczejydwlonnvu(var9, 1337991105);
            return;
         }

         var9 = 718775217 ^ var9;
      }

      throw new IllegalAccessException();
   }

   public void onPlayerJoin(Player var1, int var2) {
      int var11 = 1339189518 ^ 1209482959 ^ 877028610;
      var11 = 1896777693 ^ var11;
      byte var5 = this.initialized;
      if (var5 != (1116583198 ^ var11)) {
         var11 = 1347256582 ^ var11;
         PhantomPacketListener var7 = this.listener;
         if (var7 == null) {
            var11 = 1751149092 ^ var11;
         } else {
            while(true) {
               switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var11)) {
                  case 72644142:
                     var11 ^= 1052360089;
                  case 2102187577:
                     if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var11) == 1674333193) {
                        var11 = nqaczejydwlonnvu(var11, 656892189);
                        PhantomPacketListener var9 = this.listener;
                        var9.handlePlayerJoin(var1, 2001884668);
                        var11 = 490805102 ^ var11;
                        return;
                     }

                     while(true) {
                        switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var11)) {
                           case 103503376:
                              var11 = 1847239196 ^ var11;
                              throw new IllegalAccessException();
                           case 170316708:
                           case 1384242591:
                           default:
                              throw new IllegalAccessException();
                           case 2143699869:
                        }
                     }
                  case 444915736:
                     break;
                  case 1531547745:
                  default:
                     throw new IllegalAccessException();
               }
            }
         }
      } else {
         var11 = 2013366455 ^ var11;
         if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var11) == -731779767) {
            var11 = 1076650901 ^ var11;
         } else {
            var11 = nqaczejydwlonnvu(var11, 2028934708);
            throw new IllegalAccessException();
         }
      }
   }

   public void shutdown(int var1) {
      int var14 = 1797428492 ^ 1420533314 ^ 877028610;
      var14 = 558811359 ^ var14;
      byte var4 = this.initialized;
      if (var4 == (713139859 ^ var14)) {
         var14 = 772501940 ^ var14;
      } else {
         var14 = nqaczejydwlonnvu(var14, 967663710);
         if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var14) != -1721354648) {
            while(true) {
               switch (ndgrxkgsbanuggor.zyrrjlwgnzsztevm(var14)) {
                  case 86430209:
                     var14 = 1640994539 ^ var14;
                     throw new IOException();
                  case 87826814:
                  case 580365229:
                  default:
                     throw new IOException();
                  case 1865132083:
               }
            }
         } else {
            var14 = 1499743604 ^ var14;
            PacketEventsAPI var5 = PacketEvents.getAPI();
            var5.terminate();
            var14 = 987780367 ^ var14;
            PhantomPacketListener var7 = this.listener;
            if (var7 != null) {
               var14 = 889790677 ^ var14;
               PhantomPacketListener var9 = this.listener;
               var9.shutdown(376614221);
               var14 = 1624744028 ^ var14;
               Object var3 = null;
               this.listener = (PhantomPacketListener)var3;
               var14 = 131112449 ^ var14;
            } else {
               var14 = nqaczejydwlonnvu(var14, 392486020);
               if (ndgrxkgsbanuggor.ogamyvfeabhmxmlr(var14) != 1046499731) {
                  var14 = 355424788 ^ var14;
                  throw new IOException();
               }

               var14 = nqaczejydwlonnvu(var14, 1164624396);
            }
         }

         byte var12 = (byte)(581355582 ^ var14);
         this.initialized = (boolean)var12;
         var14 = 1105504930 ^ var14;
      }
   }

   static {
      int var6 = 1498273335 ^ 1908532079 ^ Integer.parseInt("683584788");
      tvftgxxhku = ByteBuffer.wrap(bfnxqvzmftbhsjm()).asCharBuffer().toString();
      int var3 = (new Random(7171074641672118413L)).nextInt();
      Ks5XvJ8xnz = -1981636504 ^ var3;
      var6 = 1954917213 ^ var6;
      PacketService var0 = new PacketService();
      INSTANCE = var0;
   }

   public static String ijysuouxbp(byte[] var0, int var1) {
      String var13 = Integer.toString(var1);
      byte[] var14 = var13.getBytes();
      byte[] var8 = var14;
      byte var3 = 0;
      byte var16 = var0[var3];
      short var36 = 255;
      int var17 = var16 & var36;
      byte var37 = 24;
      int var18 = var17 << var37;
      byte var4 = 1;
      byte var39 = var0[var4];
      short var68 = 255;
      int var40 = var39 & var68;
      byte var69 = 16;
      int var41 = var40 << var69;
      int var19 = var18 | var41;
      byte var70 = 2;
      byte var43 = var0[var70];
      short var71 = 255;
      int var44 = var43 & var71;
      byte var72 = 8;
      int var45 = var44 << var72;
      int var20 = var19 | var45;
      byte var73 = 3;
      byte var47 = var0[var73];
      short var74 = 255;
      int var48 = var47 & var74;
      int var21 = var20 | var48;
      byte var49 = 4;
      byte var23 = var0[var49];
      short var50 = 255;
      int var24 = var23 & var50;
      byte var51 = 24;
      int var25 = var24 << var51;
      byte var75 = 5;
      byte var53 = var0[var75];
      short var76 = 255;
      int var54 = var53 & var76;
      byte var77 = 16;
      int var55 = var54 << var77;
      int var26 = var25 | var55;
      byte var78 = 6;
      byte var57 = var0[var78];
      short var79 = 255;
      int var58 = var57 & var79;
      byte var80 = 8;
      int var59 = var58 << var80;
      int var27 = var26 | var59;
      byte var81 = 7;
      byte var61 = var0[var81];
      short var82 = 255;
      int var62 = var61 & var82;
      int var28 = var27 | var62;
      String var29 = tvftgxxhku;
      int var84 = var28 + var21;
      String var30 = var29.substring(var28, var84);
      Charset var64 = StandardCharsets.UTF_16BE;
      byte[] var31 = var30.getBytes(var64);
      byte[] var11 = var31;
      byte var32 = 0;
      int var12 = var32;

      while(true) {
         int var66 = var11.length;
         if (var12 >= var66) {
            Charset var91 = StandardCharsets.UTF_16BE;
            String var35 = new String(var11, var91);
            return var35;
         }

         byte var85 = var11[var12];
         int var93 = var8.length;
         int var92 = var12 % var93;
         byte var90 = var8[var92];
         int var86 = var85 ^ var90;
         byte var87 = (byte)var86;
         var11[var12] = var87;
         ++var12;
      }
   }

   private static byte[] bfnxqvzmftbhsjm() {
      return new byte[0];
   }

   private static int nqaczejydwlonnvu(int var0, int var1) {
      return var1 ^ var0;
   }
}
