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

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Tools {

	private ThrowableFireballs plugin = ThrowableFireballs.getPlugin(ThrowableFireballs.class);

	public String chat(String s) {
		FileConfiguration config = plugin.getConfig();

		String prefix = config.getString("Prefix");

		String result = "";

		try {

			result = ChatColor.translateAlternateColorCodes('&', s.replace("%prefix%", prefix));

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}

}