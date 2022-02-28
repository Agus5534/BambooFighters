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
            ItemStack ironboots = new ItemStackHelper(Material.IRON_BOOTS).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack leatherpant = new ItemStackHelper(Material.LEATHER_LEGGINGS).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack chainchest = new ItemStackHelper(Material.CHAINMAIL_CHESTPLATE).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack leatherhelm = new ItemStackHelper(Material.LEATHER_HELMET).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            Potion splash = new Potion(PotionType.INSTANT_HEAL,2);
            splash.splash();
            ItemStack splashpots = splash.toItemStack(3);
            items.add(new ItemStack(Material.GOLDEN_APPLE,1));
            items.add(ironboots);
            items.add(leatherpant);
            items.add(chainchest);
            items.add(leatherhelm);
            items.add(splashpots);
        } else if(kit == Kit.TANQUE) {
            items.add(new ItemStack(Material.WOODEN_SWORD,1));
            ItemStack shield = new ItemStack(Material.SHIELD,1);
            shield.setDurability((short) 292);
            ItemStack ironhelm = new ItemStackHelper(Material.IRON_HELMET).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack ironchest = new ItemStackHelper(Material.IRON_CHESTPLATE).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack ironleggings = new ItemStackHelper(Material.IRON_LEGGINGS).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack diamondboots = new ItemStackHelper(Material.DIAMOND_BOOTS).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
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
            ItemStack ironhelm = new ItemStackHelper(Material.IRON_HELMET).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack chainchest = new ItemStackHelper(Material.CHAINMAIL_CHESTPLATE).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack chainlegg = new ItemStackHelper(Material.CHAINMAIL_LEGGINGS).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            ItemStack leatherboots = new ItemStackHelper(Material.LEATHER_BOOTS).amount(1).enchants(Enchantment.PROTECTION_ENVIRONMENTAL,1);
            items.add(new ItemStack(Material.GOLDEN_APPLE,1));
            items.add(ironhelm);
            items.add(chainchest);
            items.add(chainlegg);
            items.add(leatherboots);
        } else if(kit == Kit.PYRO) {
            items.add(new ItemStack(Material.FLINT_AND_STEEL,2));
            ItemStack woodsword = new ItemStackHelper(Material.WOODEN_SWORD).amount(1).enchants(Enchantment.FIRE_ASPECT,1);
            ItemStack goldenhelm = new ItemStackHelper(Material.GOLDEN_HELMET).amount(1).enchants(Enchantment.PROTECTION_FIRE,1);
            ItemStack goldenchest = new ItemStackHelper(Material.GOLDEN_CHESTPLATE).amount(1).enchants(Enchantment.PROTECTION_FIRE,1);
            ItemStack goldenleggings = new ItemStackHelper(Material.GOLDEN_LEGGINGS).amount(1).enchants(Enchantment.PROTECTION_FIRE,1);
            ItemStack goldenboots = new ItemStackHelper(Material.GOLDEN_BOOTS).amount(1).enchants(Enchantment.PROTECTION_FIRE,1);
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
