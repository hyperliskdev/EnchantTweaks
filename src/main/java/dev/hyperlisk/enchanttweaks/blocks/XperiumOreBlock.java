package dev.hyperlisk.enchanttweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class XperiumOreBlock extends Block {

    public XperiumOreBlock() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)

        );
        setRegistryName("xperiumoreblock");
    }






}
