package me.robomwm.HotFix;

import net.minecraft.server.v1_11_R1.EntityLiving;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Robo on 2/12/2016.
 */
public class Main extends JavaPlugin implements Listener {
    boolean herp = false;
    boolean schedule = false;
    Set<Player> cancelVelocity = new HashSet<Player>();

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }



    //@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
//    void onEntityDerp(EntityDamageByEntityEvent event) {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(event.getEntityType().toString() + " Damages for " + String.valueOf(event.getFinalDamage()));
//    }

    //@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
//    void blep(EntityExplodeEvent event) {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(String.valueOf(event.blockList().size()));
//        Bukkit.broadcastMessage(String.valueOf(event.getYield()));
//    }

//    //@EventHandler
//    void derp(EntityChangeBlockEvent event) {
//        if (herp) {
//            if (event.getTo() == Material.AIR) {
//                return;
//            }
//            FallingBlock entity = (FallingBlock) event.getEntity();
//            Block block = event.getBlock();
//            Bukkit.broadcastMessage(String.valueOf(event.getEntity().getMetadata("me") != null));
//            Bukkit.broadcastMessage(String.valueOf(event.getEntity().getMetadata("we").isEmpty()));
//            event.setCancelled(true);
//            @SuppressWarnings("deprecation")
//            ItemStack itemStack = new ItemStack(entity.getMaterial(), 1, entity.getBlockData());
//            Item item = block.getWorld().dropItem(entity.getLocation(), itemStack);
//            item.setVelocity(new Vector());
//        }
//
//    }

    //@EventHandler
//    void blerp(PlayerMoveEvent event) {
//        if (herp) {
//            Material block = event.getPlayer().getLocation().getBlock().getType();
//            Bukkit.broadcastMessage(block.toString() + " " + block.isSolid() + block.isTransparent() + block.isOccluding());
//        }
//    }

//    @EventHandler(priority = EventPriority.MONITOR)
//    void entitydamagebyentity(EntityDamageByEntityEvent event)
//    {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(String.valueOf(i) + event.getCause().toString() + String.valueOf(event.isCancelled()));
//    }

//    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
//    void onDamageEvent(final EntityDamageEvent event) {
//        if (!herp)
//            return;
//        if (event.getEntityType() != EntityType.PLAYER)
//            return;
//        if (schedule)
//        {
//            final Player player = (Player)event.getEntity();
//            cancelVelocity.add(player);
//            Bukkit.broadcastMessage(String.valueOf(i));
//            new BukkitRunnable()
//            {
//                public void run()
//                {
//                    cancelVelocity.remove(player);
//                    i++;
//                    Bukkit.broadcastMessage(String.valueOf(i));
//                }
//            }.runTaskLater(this, 1L);
//            return;
//        }
//        final Vector vector = new Vector(0, 0, 0);
//        new BukkitRunnable() {
//            public void run() {
//                event.getEntity().setVelocity(vector);
//            }
//        }.runTaskLater(this, 1L);
//
//    }

//    @EventHandler
//    void velocityEvent(PlayerVelocityEvent event)
//    {
//        if (!herp)
//            return;
//        if (schedule)
//            event.setCancelled(true);
//        Bukkit.broadcastMessage(String.valueOf(i) + " velocity fired " + String.valueOf(event.isCancelled()));
//    }

//    @EventHandler
//    void resurrect(EntityResurrectEvent event)
//    {
//        if (!herp)
//            return;
//        event.setCancelled(false);
//    }

//    @EventHandler
//    void deathlootcheck(PlayerDeathEvent event)
//    {
//        if (herp)
//            event.setKeepInventory(true);
//    }

    @EventHandler(priority = EventPriority.MONITOR)
    void onHurt(EntityDamageEvent event)
    {
        if (!herp)
            return;
        if (!event.getEntity().isOp())
            return;
        //Enum#values()? What's that?
        Bukkit.broadcastMessage("getDamage(): " + String.valueOf(event.getDamage()));
        Bukkit.broadcastMessage("getFinalDamage(): " + String.valueOf(event.getFinalDamage()));
        Bukkit.broadcastMessage("Base: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.BASE)));
        Bukkit.broadcastMessage("Armor: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.ARMOR)));
        Bukkit.broadcastMessage("Absorption: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.ABSORPTION)));
        Bukkit.broadcastMessage("Blocking: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.BLOCKING)));
        Bukkit.broadcastMessage("Hard hat: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.HARD_HAT)));
        Bukkit.broadcastMessage("Magic: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.MAGIC)));
        Bukkit.broadcastMessage("Resistance: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.RESISTANCE)));
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    private void onPlayerDamage(EntityDamageEvent event)
    {
        if (!herp)
            return;
        if (event.getEntityType() != EntityType.PLAYER)
            return;

        EntityLiving nmsPlayer = (EntityLiving)event.getEntity();

        final float originalShieldHealth = nmsPlayer.getAbsorptionHearts();
        if (originalShieldHealth == 0)
            return;
        float shieldHealth = originalShieldHealth;
        double armorDamage = event.getOriginalDamage(EntityDamageEvent.DamageModifier.ARMOR);

        shieldHealth += armorDamage; //armordamage is negative

        if (shieldHealth < 0)
        {
            event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, shieldHealth);
            event.setDamage(EntityDamageEvent.DamageModifier.ABSORPTION, -originalShieldHealth);
            return;
        }

        event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, -0.0);
        event.setDamage(EntityDamageEvent.DamageModifier.ABSORPTION, shieldHealth - originalShieldHealth);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("hotfix"))
        {
            if (args.length < 1)
            {
                herp = !herp;
                sender.sendMessage(String.valueOf(herp));
            }
            else if (args.length > 1)
            {
                Player player = (Player)sender;

                if (args[0].equalsIgnoreCase("uuid"))
                {
                    OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(UUID.fromString(args[1]));
                    sender.sendMessage(offlinePlayer.toString());
                    sender.sendMessage(offlinePlayer.getUniqueId().toString());
                    sender.sendMessage(offlinePlayer.getName());
                }
                else if (args[0].equalsIgnoreCase("bed"))
                {
                    player.sendMessage(player.getBedSpawnLocation().toString());
                }
                else if (args[0].equalsIgnoreCase("name"))
                {
                    OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[1]);
                    sender.sendMessage(offlinePlayer.toString());
                    sender.sendMessage(offlinePlayer.getUniqueId().toString());
                    sender.sendMessage(offlinePlayer.getName());
                }
                else if (args[0].equalsIgnoreCase("attack"))
                {
                    Bukkit.getPlayerExact(args[1]).damage(0.5D, (Player)sender);
                }
                else if (args[0].equalsIgnoreCase("schedule"))
                {
                    if (schedule)
                        schedule = false;
                    else
                        schedule = true;
                    sender.sendMessage("Schedule: " + String.valueOf(schedule));
                }
                else if (args[0].equalsIgnoreCase("rename"))
                {
                    ItemStack itemStack = player.getInventory().getItemInMainHand();
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    String name = args[1];
                    for (int i = 2; i < args.length; i++)
                        name = name + " " + args[i];
                    name = ChatColor.translateAlternateColorCodes('&', name);
                    itemMeta.setDisplayName(name);
                    itemStack.setItemMeta(itemMeta);
                }
                else if (args[0].equalsIgnoreCase("dura")) //durability
                {
                    ItemStack itemStack = player.getInventory().getItemInMainHand();
                    if (itemStack == null) return false;
                    sender.sendMessage(String.valueOf(itemStack.getDurability()));
                    sender.sendMessage(String.valueOf(itemStack.getType().getMaxDurability()));
                }
                else if (args[0].equalsIgnoreCase("health"))
                {
                    player.sendMessage(String.valueOf(player.getMaxHealth()));
                    player.sendMessage(String.valueOf(player.getHealth()));
                    player.sendMessage(String.valueOf(player.getHealthScale()));
                }
                else if (args[0].equalsIgnoreCase("fixhealth"))
                {
                    Player player1 = Bukkit.getPlayer(args[1]);
                    player1.setHealthScaled(false);
                }
            }

            return true;
        }
        return false;
    }

    // ProjectKorra hotfix: This code cancels Explosions from other plugins
    // https://github.com/ProjectKorra/ProjectKorra/issues/400
//    @EventHandler (priority = EventPriority.LOWEST)
//    public void onEntityDamageByBlock(EntityDamageByBlockEvent event)
//    {
//        if (!event.isCancelled())
//            return;
//
//        if (event.getCause().equals(DamageCause.BLOCK_EXPLOSION))
//        {
//            if (event.getDamager() == null)
//            {
//            	event.setCancelled(false);
//            }
//        }
//    }

//    @EventHandler
//    public void onEntityTeleport(EntityTeleportEvent event)
//    {
//        Bukkit.broadcastMessage("loud noises");
//        Entity entity = event.getEntity();
//        World world = entity.getWorld();
//        Bukkit.broadcastMessage(entity.getType().toString() + world.getName());
//    }
}
