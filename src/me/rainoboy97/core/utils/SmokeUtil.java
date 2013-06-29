package me.rainoboy97.core.utils;

import java.util.Collection;
import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.Location;

/** Class/methods taken and modified from MCore - MassiveCraft **/

public class SmokeUtil {

	public static Random random = new Random();

	public static void spawnSingle(Location location, int direction) {
		if (location == null)
			return;
		location.getWorld().playEffect(location, Effect.SMOKE, direction);
	}

	public static void spawnSingle(Location location) {
		spawnSingle(location, 4);
	}

	public static void spawnSingleRandom(Location location) {
		spawnSingle(location, random.nextInt(9));
	}

	public static void spawnCloudSimple(Location location) {
		for (int i = 0; i <= 8; i++) {
			spawnSingle(location, i);
		}
	}

	public static void spawnCloudSimple(Collection<Location> locations) {
		for (Location location : locations) {
			spawnCloudSimple(location);
		}
	}

	public static void spawnCloudRandom(Location location, float thickness) {
		int singles = (int) Math.floor(thickness * 9);
		for (int i = 0; i < singles; i++) {
			spawnSingleRandom(location);
		}
	}

	public static void spawnCloudRandom(Collection<Location> locations, float thickness) {
		for (Location location : locations) {
			spawnCloudRandom(location, thickness);
		}
	}

	public static void fakeExplosion(Location location) {
		fakeExplosion(location, 4F);
	}

	public static Boolean fakeExplosion = false;

	public static void fakeExplosion(Location location, float power) {
		synchronized (fakeExplosion) {
			fakeExplosion = true;
			location.getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), power, false, false);
			fakeExplosion = false;
		}
	}
}
