package io.github.agus5534.bamboofighters.utils.kits;

import io.github.agus5534.bamboofighters.utils.itemstack.ItemStackHelper;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class KitManager {
    Kit kit;
    Player player;

    public KitManager(Kit kit,Player player) {
        this.kit = kit;
        this.player = player;
    }
    public void giveKit() {
        player.getInventory().clear();
        for(int i = 0; i < kitItems().size(); i++) {
            player.getInventory().addItem(kitItems().get(i));
        }
    }


    private List<ItemStack> kitItems() {
        List<ItemStack> items = new ArrayList<>();
        items.clear();
        items.add(new ItemStack(Material.SHEARS,1));
        items.add(new ItemStack(Material.WHITE_WOOL,16));
        if(kit == Kit.ASESINO) {
            ItemStack swsharp1 = new ItemStackHelper(Material.STONE_SWORD).amount(1).enchants(Enchantment.DAMAGE_ALL,1);
            ItemStack leatherhelm = new ItemStack(Material.LEATHER_HELMET,1);
            ItemStack chainchest = new ItemStackHelper(Material.CHAINMAIL_CHESTPLATE).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack goldleggings = new ItemStackHelper(Material.GOLDEN_LEGGINGS).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack goldboots = new ItemStackHelper(Material.GOLDEN_BOOTS).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack gapp = new ItemStack(Material.GOLDEN_APPLE, 1);
            items.add(swsharp1);
            items.add(leatherhelm);
            items.add(chainchest);
            items.add(goldleggings);
            items.add(goldboots);
            items.add(gapp);
        } else if(kit == Kit.HEALER){
            items.add(new ItemStack(Material.WOODEN_SWORD,1));
            ItemStack ironboots = new ItemStack(Material.IRON_BOOTS);
            ItemStack leatherpant = new ItemStack(Material.LEATHER_LEGGINGS,1);
            ItemStack chainchest = new ItemStack(Material.CHAINMAIL_CHESTPLATE,1);
            ItemStack leatherhelm = new ItemStack(Material.LEATHER_HELMET,1);
            Potion splash = new Potion(PotionType.INSTANT_HEAL,2);
            splash.splash();
            ItemStack splashpots = splash.toItemStack(3);
            leatherhelm.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            chainchest.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            leatherpant.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            ironboots.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            items.add(new ItemStack(Material.GOLDEN_APPLE,1));
            items.add(ironboots);
            items.add(leatherpant);
            items.add(chainchest);
            items.add(leatherhelm);
            items.add(splashpots);
        } else if(kit == Kit.TANQUE) {
            items.add(new ItemStack(Material.WOODEN_SWORD,1));
            ItemStack shield = new ItemStack(Material.SHIELD,1);
            shield.setDurability((short) 293);
            ItemStack ironhelm = new ItemStack(Material.IRON_HELMET,1);
            ItemStack ironchest = new ItemStack(Material.IRON_CHESTPLATE);
            ItemStack ironleggings = new ItemStack(Material.IRON_LEGGINGS,1);
            ItemStack diamondboots = new ItemStack(Material.DIAMOND_BOOTS,1);
            diamondboots.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            ironleggings.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            ironchest.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            ironhelm.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            items.add(new ItemStack(Material.GOLDEN_APPLE,2));
            items.add(ironhelm);
            items.add(ironchest);
            items.add(ironleggings);
            items.add(diamondboots);
            items.add(shield);

        } else if(kit == Kit.ARCHER) {
            items.add(new ItemStack(Material.WOODEN_SWORD,1));
            items.add(new ItemStack(Material.BOW, 1));
            items.add(new ItemStack(Material.ARROW,16));
            ItemStack ironhelm = new ItemStack(Material.IRON_HELMET,1);
            ItemStack chainchest = new ItemStack(Material.CHAINMAIL_CHESTPLATE,1);
            ItemStack chainlegg = new ItemStack(Material.CHAINMAIL_LEGGINGS,1);
            ItemStack leatherboots = new ItemStack(Material.LEATHER_BOOTS,1);
            leatherboots.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            chainlegg.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            chainchest.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            ironhelm.getItemMeta().addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,false);
            items.add(new ItemStack(Material.GOLDEN_APPLE,1));
            items.add(ironhelm);
            items.add(chainchest);
            items.add(chainlegg);
            items.add(leatherboots);
        } else if(kit == Kit.PYRO) {
            items.add(new ItemStack(Material.FLINT_AND_STEEL,2));
            ItemStack woodsword = new ItemStack(Material.WOODEN_SWORD,1);
            ItemStack goldenhelm = new ItemStack(Material.GOLDEN_HELMET,1);
            ItemStack goldenchest = new ItemStack(Material.GOLDEN_CHESTPLATE,1);
            ItemStack goldenleggings = new ItemStack(Material.GOLDEN_LEGGINGS,1);
            ItemStack goldenboots = new ItemStack(Material.GOLDEN_BOOTS,1);
            goldenhelm.getItemMeta().addEnchant(Enchantment.PROTECTION_FIRE,1,false);
            goldenchest.getItemMeta().addEnchant(Enchantment.PROTECTION_FIRE,1,false);
            goldenleggings.getItemMeta().addEnchant(Enchantment.PROTECTION_FIRE,1,false);
            goldenboots.getItemMeta().addEnchant(Enchantment.PROTECTION_FIRE,1,false);
            woodsword.getItemMeta().addEnchant(Enchantment.FIRE_ASPECT,1,false);
            items.add(new ItemStack(Material.GOLDEN_APPLE,1));
            items.add(woodsword);
            items.add(goldenhelm);
            items.add(goldenchest);
            items.add(goldenleggings);
            items.add(goldenboots);

        }
        return items;
    }
}
