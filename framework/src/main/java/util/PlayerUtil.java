package util;

import domain.Player;

public class PlayerUtil {

    public static double getRPT(Player player){
        return player.getWins() / player.getBets();
    }
}
