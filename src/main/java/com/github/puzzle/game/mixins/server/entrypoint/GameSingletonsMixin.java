package com.github.puzzle.game.mixins.server.entrypoint;

import com.github.puzzle.game.ServerGlobals;
import com.github.puzzle.game.engine.ServerGameLoader;
import finalforeach.cosmicreach.GameSingletons;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GameSingletons.class)
public class GameSingletonsMixin {

    /**
     * @author
     * @reason
     */
    @Overwrite
    public static void postCreate() {
        new ServerGameLoader().create();
        while (!ServerGlobals.GameLoaderHasLoaded) {
            ServerGameLoader.INSTANCE.update();
        }
    }

}
