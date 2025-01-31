/**
 * Copyright 2021 Markus Bordihn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.markusbordihn.materialelements.item;

import java.util.function.Supplier;
import de.markusbordihn.materialelements.Constants;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModTiers implements Tier {
  STEEL(2, 500, 7.0F, 2.5F, 14, () -> {
    return Ingredient.of(ModItems.STEEL_INGOT.get());
  });

  private final int level;
  private final int uses;
  private final float speed;
  private final float damage;
  private final int enchantmentValue;
  private final LazyLoadedValue<Ingredient> repairIngredient;

  private ModTiers(int tierLevel, int maxUses, float speedValue, float attackDamageBonus, int p_43336_,
      Supplier<Ingredient> p_43337_) {
    this.level = tierLevel;
    this.uses = maxUses;
    this.speed = speedValue;
    this.damage = attackDamageBonus;
    this.enchantmentValue = p_43336_;
    this.repairIngredient = new LazyLoadedValue<>(p_43337_);
  }

  public int getUses() {
    return this.uses;
  }

  public float getSpeed() {
    return this.speed;
  }

  public float getAttackDamageBonus() {
    return this.damage;
  }

  public int getLevel() {
    return this.level;
  }

  public int getEnchantmentValue() {
    return this.enchantmentValue;
  }

  public Ingredient getRepairIngredient() {
    return this.repairIngredient.get();
  }

  @javax.annotation.Nullable
  public net.minecraft.tags.Tag<net.minecraft.world.level.block.Block> getTag() {
    return Constants.NEEDS_STEEL_TOOL;
  }
}
