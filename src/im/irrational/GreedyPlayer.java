package im.irrational;

import nc.Game;
import nc.player.AbstractPlayer;

import java.util.Random;

/**
 * Created by Yingzhi on 13/01/2016.
 */
public class GreedyPlayer extends AbstractPlayer {
    private final Game game;
    private int action;

    public GreedyPlayer(Random random, Game game) {
        super(random);
        this.game = game;
        action = -1;
    }

    @Override
    public int getAction() {
        return 0;
    }
}
