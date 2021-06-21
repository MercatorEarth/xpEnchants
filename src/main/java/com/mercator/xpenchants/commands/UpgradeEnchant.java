package com.mercator.xpenchants.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class UpgradeEnchant implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (args.length == 1) {
            upgradeEnchant(p, args[0]);
        }
        else {
            p.sendMessage("Incorrect number of arguments! Usage: /enchantupgrade <enchantname>");
        }

        return true;
    }

    public void upgradeEnchant(Player p, String e) {
        ItemStack itemHeld = p.getInventory().getItemInMainHand();

        if (itemHeld != null) {
            Map<Enchantment, Integer> enchantments = itemHeld.getEnchantments();

            if (e.equals("sharpness") && enchantments.containsKey(Enchantment.DAMAGE_ALL)) {
                if (enchantments.get(Enchantment.DAMAGE_ALL) >= 5 && p.getLevel() >= 10 * upgradeEquation(enchantments.get(Enchantment.DAMAGE_ALL) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.DAMAGE_ALL)));
                    itemHeld.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, enchantments.get(Enchantment.DAMAGE_ALL) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Sharpness V), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.DAMAGE_ALL) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("smite") && enchantments.containsKey(Enchantment.DAMAGE_UNDEAD)) {
                if (enchantments.get(Enchantment.DAMAGE_UNDEAD) >= 5 && p.getLevel() >= 10 * upgradeEquation(enchantments.get(Enchantment.DAMAGE_UNDEAD) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.DAMAGE_UNDEAD)));
                    itemHeld.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, enchantments.get(Enchantment.DAMAGE_UNDEAD) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Smite V), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.DAMAGE_UNDEAD) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("baneofarthropods") && enchantments.containsKey(Enchantment.DAMAGE_ARTHROPODS)) {
                if (enchantments.get(Enchantment.DAMAGE_ARTHROPODS) >= 5 && p.getLevel() >= 10 * upgradeEquation(enchantments.get(Enchantment.DAMAGE_ARTHROPODS) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.DAMAGE_ARTHROPODS)));
                    itemHeld.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, enchantments.get(Enchantment.DAMAGE_ARTHROPODS) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Bane of Arthropods V), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.DAMAGE_ARTHROPODS) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("sweepingedge") && enchantments.containsKey(Enchantment.SWEEPING_EDGE)) {
                if (enchantments.get(Enchantment.SWEEPING_EDGE) >= 3 && p.getLevel() >= 10 * upgradeEquation(enchantments.get(Enchantment.SWEEPING_EDGE) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.SWEEPING_EDGE)));
                    itemHeld.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, enchantments.get(Enchantment.SWEEPING_EDGE) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Sweeping Edge III), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.SWEEPING_EDGE) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("power") && enchantments.containsKey(Enchantment.ARROW_DAMAGE)) {
                if (enchantments.get(Enchantment.ARROW_DAMAGE) >= 5 && p.getLevel() >= 10 * upgradeEquation(enchantments.get(Enchantment.ARROW_DAMAGE) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.ARROW_DAMAGE)));
                    itemHeld.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, enchantments.get(Enchantment.ARROW_DAMAGE) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Power V), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.ARROW_DAMAGE) + 1) + "levels)" + ChatColor.RED + "!");
                }            }
            else if (e.equals("featherfalling") && enchantments.containsKey(Enchantment.PROTECTION_FALL)) {
                if (enchantments.get(Enchantment.PROTECTION_FALL) >= 4 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.PROTECTION_FALL) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.PROTECTION_FALL)));
                    itemHeld.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, enchantments.get(Enchantment.PROTECTION_FALL) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Feather Falling IV), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.PROTECTION_FALL) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("blastprotection") && enchantments.containsKey(Enchantment.PROTECTION_EXPLOSIONS)) {
                if (enchantments.get(Enchantment.PROTECTION_EXPLOSIONS) >= 4 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.PROTECTION_EXPLOSIONS) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.PROTECTION_EXPLOSIONS)));
                    itemHeld.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, enchantments.get(Enchantment.PROTECTION_EXPLOSIONS) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Blast Protection IV), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.PROTECTION_EXPLOSIONS) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("fireprotection") && enchantments.containsKey(Enchantment.PROTECTION_FIRE)) {
                if (enchantments.get(Enchantment.PROTECTION_FIRE) >= 4 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.PROTECTION_FIRE) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.PROTECTION_FIRE)));
                    itemHeld.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, enchantments.get(Enchantment.PROTECTION_FIRE) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Fire Protection IV), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.PROTECTION_FIRE) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("projectileprotection") && enchantments.containsKey(Enchantment.PROTECTION_PROJECTILE)) {
                if (enchantments.get(Enchantment.PROTECTION_PROJECTILE) >= 4 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.PROTECTION_PROJECTILE) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.PROTECTION_PROJECTILE)));
                    itemHeld.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, enchantments.get(Enchantment.PROTECTION_PROJECTILE) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Projectile Protection IV), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.PROTECTION_PROJECTILE) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("protection") && enchantments.containsKey(Enchantment.PROTECTION_ENVIRONMENTAL)) {
                if (enchantments.get(Enchantment.PROTECTION_ENVIRONMENTAL) >= 4 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.PROTECTION_ENVIRONMENTAL) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.PROTECTION_ENVIRONMENTAL)));
                    itemHeld.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, enchantments.get(Enchantment.PROTECTION_ENVIRONMENTAL) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Protection IV), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.PROTECTION_ENVIRONMENTAL) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("respiration") && enchantments.containsKey(Enchantment.OXYGEN)) {
                if (enchantments.get(Enchantment.OXYGEN) >= 3 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.OXYGEN) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.OXYGEN)));
                    itemHeld.addUnsafeEnchantment(Enchantment.OXYGEN, enchantments.get(Enchantment.OXYGEN) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Respiration III), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.OXYGEN) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("thorns") && enchantments.containsKey(Enchantment.THORNS)) {
                if (enchantments.get(Enchantment.THORNS) >= 3 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.THORNS) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.THORNS)));
                    itemHeld.addUnsafeEnchantment(Enchantment.THORNS, enchantments.get(Enchantment.THORNS) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Thorns III), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.THORNS) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("efficiency") && enchantments.containsKey(Enchantment.DIG_SPEED)) {
                if (enchantments.get(Enchantment.DIG_SPEED) >= 5 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.DIG_SPEED) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.DIG_SPEED)));
                    itemHeld.addUnsafeEnchantment(Enchantment.DIG_SPEED, enchantments.get(Enchantment.DIG_SPEED) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Efficiency V), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.DIG_SPEED) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("fortune") && enchantments.containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
                if (enchantments.get(Enchantment.LOOT_BONUS_BLOCKS) >= 3 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.LOOT_BONUS_BLOCKS) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.LOOT_BONUS_BLOCKS)));
                    itemHeld.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, enchantments.get(Enchantment.LOOT_BONUS_BLOCKS) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Fortune III), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.LOOT_BONUS_BLOCKS) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("luckofthesea") && enchantments.containsKey(Enchantment.LUCK)) {
                if (enchantments.get(Enchantment.LUCK) >= 3 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.LUCK) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.LUCK)));
                    itemHeld.addUnsafeEnchantment(Enchantment.LUCK, enchantments.get(Enchantment.LUCK) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Luck of the Sea III), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.LUCK) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("lure") && enchantments.containsKey(Enchantment.LURE)) {
                if (enchantments.get(Enchantment.LURE) >= 3 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.LURE) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.LURE)));
                    itemHeld.addUnsafeEnchantment(Enchantment.LURE, enchantments.get(Enchantment.LURE) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Lure III), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.LURE) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("unbreaking") && enchantments.containsKey(Enchantment.DURABILITY)) {
                if (enchantments.get(Enchantment.DURABILITY) >= 3 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.DURABILITY) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.DURABILITY)));
                    itemHeld.addUnsafeEnchantment(Enchantment.DURABILITY, enchantments.get(Enchantment.DURABILITY) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Unbreaking III), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.DURABILITY) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("impaling") && enchantments.containsKey(Enchantment.IMPALING)) {
                if (enchantments.get(Enchantment.IMPALING) >= 5 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.IMPALING) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.IMPALING)));
                    itemHeld.addUnsafeEnchantment(Enchantment.IMPALING, enchantments.get(Enchantment.IMPALING) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Impaling V), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.IMPALING) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else if (e.equals("piercing") && enchantments.containsKey(Enchantment.PIERCING)) {
                if (enchantments.get(Enchantment.PIERCING) >= 4 && p.getLevel() >= upgradeEquation(enchantments.get(Enchantment.PIERCING) + 1)) {
                    p.giveExpLevels((int) upgradeEquation(enchantments.get(Enchantment.PIERCING)));
                    itemHeld.addUnsafeEnchantment(Enchantment.PIERCING, enchantments.get(Enchantment.PIERCING) + 1);
                }
                else {
                    p.sendMessage(ChatColor.RED + "Unable to upgrade the enchantment! You do not have the necessary enchantment " + ChatColor.WHITE + "(Piercing IV), " + ChatColor.RED + "or, you do not meet the level requirement " + ChatColor.WHITE + "(" + upgradeEquation(enchantments.get(Enchantment.PIERCING) + 1) + "levels)" + ChatColor.RED + "!");
                }
            }
            else {
                p.sendMessage(ChatColor.RED + "Your item is not enchanted with any compatible enchantment, or the enchantment you entered is invalid!");
            }
        }
        else {
            p.sendMessage(ChatColor.RED + "You are currently not holding an item!");
        }
    }

    public double upgradeEquation(double value) {
        return -Math.pow(5.0, Math.floor(value - 11));
    }
}
