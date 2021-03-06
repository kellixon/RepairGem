package cn.davidma.repairgem;

import java.util.List;

import javax.annotation.Nullable;

import cn.davidma.repairgem.reference.GemConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class Gem extends ItemSimpleFoiled {
	
	public Gem(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		setMaxStackSize(1);
		setMaxDamage(GemConfig.durability);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		
		// Dynamic tooltip.
		if (GuiScreen.isShiftKeyDown()) {
			tooltip.add("Repair items in the holder's inventory.");
		} else {
			tooltip.add(TextFormatting.ITALIC + "<Hold SHIFT>");
		}
	}
	
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
