/*
 *  Copyright (C) 2018 FlailoftheLord
 *
 *  This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package me.flail.ThrowableFireballs;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FireballExplosion implements Listener {

	private ThrowableFireballs plugin;

	private FileConfiguration config;

	@EventHandler
	public void fireballExplode(ProjectileHitEvent event) {

		plugin = JavaPlugin.getPlugin(ThrowableFireballs.class);

		config = plugin.getConfig();

		Entity entity = event.getEntity();

		boolean doesNaturalDamage = config.getBoolean("NaturalExplosion");

		if (doesNaturalDamage != true) {

			if (entity instanceof Fireball) {

				String fbName = entity.getCustomName();

				if (fbName.equals("HolyBalls")) {

					float power = config.getLong("FireballExplosionPower");

					boolean doesFire = config.getBoolean("FireballSetFire");

					Fireball fireball = (Fireball) entity;

					Location fbLoc = fireball.getLocation();

					World fbWorld = fireball.getWorld();

					fbWorld.createExplosion(fbLoc, power, doesFire);

				}

			}

		}

	}

}
