package com.fgtxray.client;

import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import com.fgtxray.FgtXRay;
import com.fgtxray.client.gui.GuiSettings;

public class KeyBindingHandler
{
	private Minecraft mc = Minecraft.getMinecraft();
	
	@SubscribeEvent
	public void onKeyInput( KeyInputEvent event )
    {
		if( (!FMLClientHandler.instance().isGUIOpen( GuiChat.class )) && (mc.currentScreen == null) && (mc.world != null) )
        {
			if (OresSearch.searchList.isEmpty()) // Populate the OresSearch.searchList
			{
				OresSearch.get();
			}
			if( FgtXRay.keyBind_keys[ FgtXRay.keyIndex_toggleXray ].isPressed() )
			{
				FgtXRay.drawOres = !FgtXRay.drawOres;
				RenderTick.ores.clear();
			}
			else if( FgtXRay.keyBind_keys[ FgtXRay.keyIndex_showXrayMenu ].isPressed() )
			{
				mc.displayGuiScreen( new GuiSettings() );
			}
		}
	}
}
