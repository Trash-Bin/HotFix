package me.robomwm.HotFix;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.DoubleChest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
        //getServer().getMessenger().registerOutgoingPluginChannel(this, "MC|BOpen");
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

//    HashMap<Player, List<Location>> lastLocations = new HashMap<>();
//    @EventHandler(ignoreCancelled = true)
//    private void trackMoveHistory(PlayerMoveEvent event)
//    {
//        if (!herp)
//            return;
//        if (!lastLocations.containsKey(event.getPlayer()))
//            lastLocations.put(event.getPlayer(), new ArrayList<>());
//        List<Location> locations = lastLocations.get(event.getPlayer());
//        if (locations.size() > 60)
//            locations.remove(0);
//        locations.add(event.getTo());
//    }
//
//    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
//    private void onSwapHandsButton(PlayerSwapHandItemsEvent event)
//    {
//        if (!herp)
//            return;
//        World world = event.getPlayer().getWorld();
//        List<Location> locations = new ArrayList<>(lastLocations.get(event.getPlayer()));
//        Collections.reverse(locations);
//        new BukkitRunnable()
//        {
//            Iterator<Location> locationIterator = locations.iterator();
//            @Override
//            public void run()
//            {
//                if (!locationIterator.hasNext())
//                {
//                    cancel();
//                    return;
//                }
//                Location location = locationIterator.next();
//                if (location.getWorld() != world)
//                    return;
//                event.getPlayer().teleport(location);
//            }
//        }.runTaskTimer(this, 1L, 1L);
//        event.setCancelled(true);
//    }
//
//    @EventHandler
//    void onExplode(EntityExplodeEvent event)
//    {
//        if (!herp)
//            return;
//        if (event.getEntityType() != EntityType.PRIMED_TNT)
//            return;
//
//        TNTPrimed tnt = (TNTPrimed)event.getEntity();
//        System.out.println(tnt.hashCode());
//        Bukkit.broadcastMessage(tnt.getSource().toString());
//    }

//    @EventHandler
//    private void respawnEvent(PlayerRespawnEvent event)
//    {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(event.getEventName() + event.getPlayer().getName() + " Dead:" + event.getPlayer().isDead() + " location:" + event.getPlayer().getLocation().toString());
//    }
//
//    @EventHandler
//    private void teleports(PlayerTeleportEvent event)
//    {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(event.getEventName() + event.getPlayer().getName() + " Dead:" + event.getPlayer().isDead() + " cause:" + event.getCause().toString());
//
//    }
//
//    @EventHandler
//    private void changeWorld(PlayerChangedWorldEvent event)
//    {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(event.getEventName() + event.getPlayer().getName() + " Dead:" + event.getPlayer().isDead());
//    }

//    @EventHandler
//    private void death(PlayerDeathEvent event)
//    {
//        if (!herp)
//            return;
//        if (event.getEntity().getKiller() != null)
//            event.getEntity().sendMessage(event.getEntity().getKiller().getName());
//    }

//    @EventHandler(priority = EventPriority.MONITOR)
//    void onHurt(EntityDamageEvent event)
//    {
//        if (!herp)
//            return;
//        if (event.getEntityType() != EntityType.PLAYER)
//            return;
//        //Enum#values()? What's that?
//        Bukkit.broadcastMessage("getDamage(): " + String.valueOf(event.getDamage()));
//        Bukkit.broadcastMessage("getFinalDamage(): " + String.valueOf(event.getFinalDamage()));
//        Bukkit.broadcastMessage("Base: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.BASE)));
//        Bukkit.broadcastMessage("Armor: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.ARMOR)));
//        Bukkit.broadcastMessage("Absorption: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.ABSORPTION)));
//        Bukkit.broadcastMessage("Blocking: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.BLOCKING)));
//        Bukkit.broadcastMessage("Hard hat: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.HARD_HAT)));
//        Bukkit.broadcastMessage("Magic: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.MAGIC)));
//        Bukkit.broadcastMessage("Resistance: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.RESISTANCE)));
//    }
//
//    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
//    private void onPlayerDamage(EntityDamageEvent event)
//    {
//        if (!herp)
//            return;
//        if (event.getEntityType() != EntityType.PLAYER)
//            return;
//
//        if (!event.getEntity().isOp())
//            return;
//
//        CraftPlayer player = (CraftPlayer)event.getEntity();
//
//        EntityLiving nmsPlayer = player.getHandle();
//
//        final float originalShieldHealth = nmsPlayer.getAbsorptionHearts();
//
//        if (originalShieldHealth == 0)
//            return;
//        float shieldHealth = originalShieldHealth;
//        Bukkit.broadcastMessage("shieldHealth: " + String.valueOf(originalShieldHealth));
//        double armorDamage = event.getOriginalDamage(EntityDamageEvent.DamageModifier.ARMOR);
//
//        shieldHealth += armorDamage; //armordamage is negative
//
//        if (shieldHealth < 0)
//        {
//            event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, shieldHealth);
//            event.setDamage(EntityDamageEvent.DamageModifier.ABSORPTION, -originalShieldHealth);
//            return;
//        }
//
//        event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, -0.0);
//        event.setDamage(EntityDamageEvent.DamageModifier.ABSORPTION, event.getOriginalDamage(EntityDamageEvent.DamageModifier.ABSORPTION) + (shieldHealth - originalShieldHealth));
//    }

    int nodamage = 20;

//    @EventHandler
//    void onEntityDamage(EntityDamageEvent event)
//    {
//        if (!herp)
//            return;
//        if (!(event.getEntity() instanceof LivingEntity))
//            return;
//        ((LivingEntity)event.getEntity()).setNoDamageTicks(nodamage);
//    }

//    @EventHandler
//    private void chestNamer(PlayerInteractEvent event)
//    {
//        if (!herp)
//            return;
//        if (!event.getPlayer().isOp())
//            return;
//        if (event.getAction() != Action.LEFT_CLICK_BLOCK)
//            return;
//        Chest chest = (Chest)event.getClickedBlock().getState();
//        Bukkit.broadcastMessage(chest.getClass().getSimpleName());
//
//        DoubleChest doubleChest = (DoubleChest)(chest.getInventory().getHolder());
//        chest.getInventory().addItem(event.getItem());
//        //chest.update();
//
//        Bukkit.broadcastMessage(((Chest)doubleChest.getLeftSide()).getCustomName());
//        try
//        {
//            Bukkit.broadcastMessage(((Chest)doubleChest.getRightSide()).getLocation().toString());
//            Bukkit.broadcastMessage(doubleChest.getLocation().toString());
////            Chest leftChest = (Chest)((Chest)doubleChest.getLeftSide()).getBlock().getState();
////            leftChest.setCustomName("test");
////            Chest rightChest = (Chest)((Chest)doubleChest.getRightSide()).getBlock().getState();
////            rightChest.setCustomName("ing");
////            Bukkit.broadcastMessage( String.valueOf(leftChest.update()));
////            Bukkit.broadcastMessage( String.valueOf(rightChest.update()));
//        }
//        catch (Throwable rock)
//        {
//            rock.printStackTrace();
//            Bukkit.broadcastMessage(doubleChest.getLeftSide().getClass().getSimpleName());
//        }
//
//    }

//    @EventHandler
//    private void testCraft(InventoryCloseEvent event)
//    {
//        if (!herp)
//            return;
//        if (!event.getPlayer().isOp())
//            return;
//        CraftingInventory inventory = (CraftingInventory) event.getInventory();
//        Map<Material, Character> ingredients = new HashMap<>();
//        ingredients.put(null, 'a');
//        char i = 'b';
//        for (ItemStack item : inventory.getMatrix())
//        {
//            if (item == null || ingredients.containsKey(item.getType()))
//                continue;
//            ingredients.put(item.getType(), i++);
//        }
//        getShapedMatrix(ingredients, inventory.getMatrix());
//    }

//    @EventHandler(priority = EventPriority.LOWEST)
//    private void onBlockBreak(BlockBreakEvent event)
//    {
//        if (!herp)
//            return;
//        if (event.getBlock().getType().equals(Material.WALL_SIGN))
//            for (String line : ((Sign)event.getBlock().getState()).getLines())
//                event.getPlayer().sendMessage(line.replaceAll(" ", "|"));
//        event.setCancelled(true);
//    }

    @EventHandler(priority = EventPriority.LOWEST)
    private void onBlockBreak(BlockPlaceEvent event)
    {
        if (!herp)
            return;
        Bukkit.broadcastMessage(event.getBlock().getState().getClass().getSimpleName());
        Bukkit.broadcastMessage(Boolean.toString(event.getBlock().getState() instanceof DoubleChest));
        for (BlockFace face : BlockFace.values())
            Bukkit.broadcastMessage(face.toString() + Boolean.toString(event.getBlock().getState() == event.getBlock().getRelative(face).getState()));
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                BlockState state = event.getBlock().getRelative(BlockFace.SELF).getState();
                for (BlockFace face : BlockFace.values())
                    Bukkit.broadcastMessage(face.toString() + Boolean.toString(event.getBlock().getState() == event.getBlock().getRelative(face).getState()));
            }
        }.runTask(this);
    }


    private Location firstLocation;

    private BukkitTask task;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("hotfix"))
        {
            if (task != null)
                task.cancel();
            task = null;
            if (args.length < 1)
            {
                herp = !herp;
                sender.sendMessage(String.valueOf(herp));
            }
            else if (args.length >= 1) //redundant
            {
                Player player = null;
                if (sender instanceof Player)
                    player = (Player)sender;

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
                else if (args[0].equalsIgnoreCase("nodamageticks"))
                {
                    Player player1 = Bukkit.getPlayer(args[1]);
                    player1.setMaximumNoDamageTicks(Integer.parseInt(args[2]));
                }
                else if (args[0].equalsIgnoreCase("setnodamage"))
                {
                    nodamage = Integer.parseInt(args[1]);
                }
                else if (args[0].equalsIgnoreCase("lag"))
                {
                    try
                    {
                        Thread.sleep(Long.parseLong(args[1]));
                    }
                    catch (Exception ignored) {}

                }
                else if (args[0].equalsIgnoreCase("destroyscheduler"))
                {
                    getServer().broadcastMessage("El ");
                    new BukkitRunnable()
                    {
                        public void run()
                        {
                            getServer().broadcastMessage("oh el");
                        }
                    }.runTaskTimer(this, 1L, ((long)Float.MAX_VALUE / 2));
                }
                else if (args[0].equalsIgnoreCase("permission"))
                {
                    Player player1 = Bukkit.getPlayer(args[1]);
                    player.sendMessage(player1.getName() + String.valueOf(player1.hasPermission(args[2])));
                }
//                else if (args[0].equalsIgnoreCase("shieldhealth"))
//                {
//                    toggleShieldDebug(player);
//                }
                else if (args[0].equalsIgnoreCase("damage"))
                {
                    player.damage(Double.valueOf(args[1]));
                }
                else if (args[0].equalsIgnoreCase("speed"))
                {
                    player.setWalkSpeed(Float.valueOf(args[1]));
                }
                else if (args[0].equalsIgnoreCase("perm"))
                {
                    Player player1 = Bukkit.getPlayer(args[1]);
                    sender.sendMessage(String.valueOf(player1.hasPermission(args[2])));
                }
                else if (args[0].equalsIgnoreCase("book"))
                {
                    TextComponent textComponent = new TextComponent(args[1]);
                    textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, args[2]));
                    if (args.length > 3)
                        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(args[3])));
                    player.sendMessage(getClickableChat(args[1], args[2], args[3]));
                    List<BaseComponent> baseComponents = new ArrayList<>();
                    baseComponents.add(getClickableChat(args[1], args[2], args[3]));
                    baseComponents.add(getClickableChat(args[1], args[2], args[3]));
                    baseComponents.addAll(Arrays.asList(TextComponent.fromLegacyText("testing")));
                    player.sendMessage(baseComponents.toArray(new BaseComponent[0]));
                    player.sendMessage(buildPage(getClickableChat(args[1], args[2], args[3]), getClickableChat(args[1], args[2], args[3])));
                }
                else if (args[0].equalsIgnoreCase("action"))
                {
                    player.sendActionBar('&', String.join(" ", args));
                }
                else if (args[0].equalsIgnoreCase("music"))
                {
                    for (int i = 0; i < 10; i++)
                        player.playSound(new Location(player.getWorld(), 2, 5, 298), args[1], SoundCategory.RECORDS, Float.valueOf(args[2]), 1.0f);
                }
                else if (args[0].equalsIgnoreCase("distance"))
                {

                    if (firstLocation == null)
                    {
                        Player finalPlayer = player;
                        firstLocation = player.getTargetBlock(null, 100).getLocation();
                        new BukkitRunnable()
                        {
                            @Override
                            public void run()
                            {
                                if (firstLocation == null)
                                {
                                    cancel();
                                    return;
                                }
                                finalPlayer.sendActionBar(Double.toString(firstLocation.distance(finalPlayer.getLocation())));
                            }
                        }.runTaskTimer(this, 40L, 40L);
                    }
                    else
                    {
                        firstLocation = null;
                    }
                }
                else if (args[0].equalsIgnoreCase("sentry"))
                {
                    if (firstLocation != null)
                    {
                        firstLocation = null;
                        return true;
                    }
                    firstLocation = player.getTargetBlock(null, 10).getLocation();
                    Player finalPlayer = player;
                    new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            if (firstLocation == null)
                            {
                                cancel();
                                return;
                            }


                            Vector vector = getClosestPlayer(firstLocation).getLocation().add(0, 1.5, 0).toVector().subtract(firstLocation.toVector());
                            Iterator<Block> blocks = new BlockIterator(firstLocation.getWorld(), firstLocation.toVector(), vector, 0, Math.min(100, (int)vector.length()));
                            blocks.next();
                            blocks.next();
                            while (blocks.hasNext())
                            {
                                Block block = blocks.next();
                                if (block.getType() != Material.AIR)
                                    finalPlayer.sendActionBar(block.toString());
                            }
                            firstLocation.getWorld().spawnArrow(firstLocation, vector, 2, 0).setGravity(false);
                        }
                    }.runTaskTimer(this, 20L, 20L);
                }
                else if (args[0].equalsIgnoreCase("glow"))
                {
                    player.sendMessage(String.valueOf(player.isGlowing()));
                    player.setGlowing(!player.isGlowing());
                }
                else if (args[0].equalsIgnoreCase("damagemob"))
                {
                    for (Entity entity : player.getNearbyEntities(5,5,5))
                    {
                        if (entity.getType() != EntityType.PLAYER && entity instanceof Damageable)
                            ((Damageable)entity).damage(Double.parseDouble(args[1]));
                    }
                }
                else if (args[0].equalsIgnoreCase("bounce"))
                {
                    Location location = player.getLocation().add(player.getLocation().getDirection());
                    Item grenade = location.getWorld().dropItem(location, new ItemStack(Material.TNT));
                    grenade.setCanMobPickup(false);
                    grenade.setPickupDelay(Integer.MAX_VALUE);
                    grenade.setVelocity(location.getDirection());
                    Player finalPlayer = player;

                    new BukkitRunnable()
                    {
                        int duration = 60;

                        @Override
                        public void run()
                        {
                            if (--duration <= 0)
                            {
                                grenade.remove();
                                grenade.getWorld().createExplosion(grenade.getLocation(), 1f, false, false);
                                cancel();
                            }
                            Vector vector = grenade.getVelocity();
                            int length = Math.max(2, (int)Math.round(vector.length()));
                            BlockIterator blockIterator = new BlockIterator(grenade.getWorld(), vector, vector, 0, length);
                            Block previousBlock = null;
                            Block collidingBlock = null;
                            while ((collidingBlock == null || collidingBlock.getType() != Material.AIR) && blockIterator.hasNext())
                            {
                                previousBlock = collidingBlock;
                                collidingBlock = blockIterator.next();
                            }

                            if (collidingBlock == null || collidingBlock.getType() == Material.AIR)
                                return;

                            switch (collidingBlock.getFace(previousBlock))
                            {
                                case UP:
                                case DOWN:
                                    vector.setY(-vector.getY());
                                    break;
                                case EAST:
                                case WEST:
                                    vector.setX(-vector.getX());
                                case NORTH:
                                case SOUTH:
                                    vector.setZ(-vector.getZ());
                            }
                            finalPlayer.sendActionBar(collidingBlock.getFace(previousBlock).toString());
                            grenade.setVelocity(vector);
                        }
                    }.runTaskTimer(this, 1L, 1L);
                }
                else if (args[0].equalsIgnoreCase("warpspeed"))
                {
                    task = new BukkitRunnable()
                    {
                        int speed = 1;

                        @Override
                        public void run()
                        {
                            //player.setVelocity(player.getLocation().getDirection().multiply(16));
                            //player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, speed++, true, false));
                            //player.getWorld().spawnParticle(Particle.SPIT, player.getLocation().add(player.getLocation().getDirection().multiply(16)), 20);
                        }
                    }.runTaskTimer(this, 1L, 1L);
                }
                else if (args[0].equalsIgnoreCase("version"))
                {
                    getServer().broadcastMessage(getServer().getVersion());
                    getServer().broadcastMessage(getServer().getBukkitVersion());
                    getServer().broadcastMessage(getServer().getServerName());
                }
                else if (args[0].equalsIgnoreCase("chat"))
                {
                    player.chat("" + args[1]);
                    return true;
                }
            }

            return true;
        }


//        if (cmd.getName().equalsIgnoreCase("goldleggings"))
//        {
//            Player player = (Player)sender;
//            if (player.getWorld().getName().equalsIgnoreCase("CreativeParkourMaps"))
//                return false;
//            if (args.length < 2)
//                return false;
//            int levitation;
//            int jump;
//            try
//            {
//                levitation = Integer.parseInt(args[0]);
//                jump = Integer.parseInt(args[1]);
//            }
//            catch (Throwable rock)
//            {
//                return false;
//            }
//            for (PotionEffect potionEffect : player.getActivePotionEffects())
//                player.removePotionEffect(potionEffect.getType());
//            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 1200, levitation, true, false));
//            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200, jump, true, false));
//        }
        return false;
    }

    private Player getClosestPlayer(Location location)
    {
        Player player = null;
        double distance = Double.MAX_VALUE;
        for (Player onlinePlayer : location.getWorld().getPlayers())
        {
            double checkDistance = onlinePlayer.getLocation().distanceSquared(location);
            if (checkDistance < distance)
            {
                player = onlinePlayer;
                distance = checkDistance;
            }
        }
        return player;
    }

    private TextComponent getClickableChat(String message, String command, String hover)
    {
        TextComponent textComponent = new TextComponent(message);
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        if (hover != null)
            textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(hover)));
        return textComponent;
    }

    private BaseComponent[] buildPage(Object... strings)
    {
        List<BaseComponent> baseComponents = new ArrayList<>(strings.length);
        for (Object object : strings)
        {
            if (object instanceof TextComponent)
                baseComponents.add((TextComponent)object);
            else if (object instanceof String)
                baseComponents.addAll(Arrays.asList(TextComponent.fromLegacyText((String)object)));
        }
        return baseComponents.toArray(new BaseComponent[0]);
    }

    @EventHandler
    private void onWorldChange(PlayerChangedWorldEvent event)
    {
        if (event.getPlayer().getWorld().getName().equalsIgnoreCase("CreativeParkourMaps"))
            for (PotionEffect potionEffect : event.getPlayer().getActivePotionEffects())
                event.getPlayer().removePotionEffect(potionEffect.getType());
    }

    Player debugger = null;
//    ShieldUtils shieldUtils;
//
//    private void toggleShieldDebug(Player player)
//    {
//        if (debugger == null)
//            debugger = player;
//        else
//            debugger = null;
//        if (shieldUtils == null)
//            shieldUtils = ((AbsorptionShields)getServer().getPluginManager().getPlugin("AbsorptionShields")).getShieldUtils();
//    }

//    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
//    private void onDamage(EntityDamageEvent event)
//    {
//        if (debugger == null)
//            return;
//        if (event.getEntity() != debugger)
//            return;
//        debugger.sendMessage(event.getDamage() + "; " + event.getFinalDamage() + "; " + shieldUtils.getShieldHealth(debugger));
//    }
//
//    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
//    private void onHeal(EntityRegainHealthEvent event)
//    {
//        if (debugger == null)
//            return;
//        if (event.getEntity() != debugger)
//            return;
//        if (event.getRegainReason() != EntityRegainHealthEvent.RegainReason.CUSTOM)
//            return;
//        debugger.sendMessage("Shield " + shieldUtils.getShieldHealth(debugger));
//    }

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
