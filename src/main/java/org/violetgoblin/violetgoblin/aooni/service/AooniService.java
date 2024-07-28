package org.violetgoblin.violetgoblin.aooni.service;

import org.violetgoblin.violetgoblin.aooni.aggregate.AooniStatus;
import org.violetgoblin.violetgoblin.aooni.repository.AooniRepository;
import org.violetgoblin.violetgoblin.player.repository.PlayerRepository;
import org.violetgoblin.violetgoblin.player.service.PlayerService;

public class AooniService {
    AooniRepository pr = new AooniRepository();
    static AooniStatus aooni = new AooniStatus();

    public AooniService() {
    }

    /* 아오오니 생성 */
    public void makeAooni(AooniStatus aooni) {
        aooni.setRoom(PlayerService.room);
        int x = (int) (Math.random() * PlayerService.map.length - 3) + 1;
        int y = (int) (Math.random() * PlayerService.map[0].length - 3) + 1;
        aooni.setLoc(new int[]{x, y});
        PlayerService.map[aooni.getLoc()[0]][aooni.getLoc()[1]] = "A";
    }

    public int[] moveAooni(AooniStatus aooni) {
        int idx = (int) (Math.random() * 2);
        int wasd = (int) (Math.random() * 2);
        int[] UD = {-1, +1};
        int[] aTmpLoc;
        if (idx == 0) {
            aTmpLoc = new int[]{aooni.getLoc()[0] + UD[wasd], aooni.getLoc()[1]};
        } else {
            aTmpLoc = new int[]{aooni.getLoc()[0], aooni.getLoc()[1] + UD[wasd]};
        }
        return aTmpLoc;
    }

}
