package com.slurpy.glowfighter.guns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.slurpy.glowfighter.Core;
import com.slurpy.glowfighter.entities.Entity;
import com.slurpy.glowfighter.entities.Team;
import com.slurpy.glowfighter.entities.bullets.PiercingShot;
import com.slurpy.glowfighter.managers.AssetManager.SoundAsset;

public class SniperRifle extends Gun{
	
	private static final float cooldown = 1.33f;
	
	private float accumulator = cooldown;
	
	public SniperRifle(){
		super(20f);
	}
	
	@Override
	public void start(Entity entity) {
		
	}

	@Override
	public void update(boolean shoot, Vector2 pos, float rot) {
		accumulator += Gdx.graphics.getDeltaTime();
		if(shoot){
			while(accumulator >= cooldown){
				Core.entities.addEntity(new PiercingShot(pos, new Vector2(120, 0).rotateRad(rot), Color.FIREBRICK, Team.FRIENDLY, 300f, 6));
				Core.audio.playSound(SoundAsset.Shoot);
				accumulator -= cooldown;
			}
		}else{
			if(accumulator > cooldown)accumulator = cooldown;
		}
	}

	@Override
	public void end() {
		
	}

	@Override
	public String getName() {
		return "Sniper Rifle";
	}
}
