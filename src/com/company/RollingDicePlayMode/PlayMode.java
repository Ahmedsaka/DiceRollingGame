package com.company.RollingDicePlayMode;

import com.company.Player;

public interface PlayMode {
    int [] dieFace = {1,2,3,4,5,6};

    Player createPlayer();
    int[] play();
    int[] rollResult();

}
