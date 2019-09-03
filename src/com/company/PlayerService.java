package com.company;

import com.company.RollingDicePlayMode.PlayMode;

public class PlayerService {

    private PlayMode playMode;

    public PlayerService() {
        super();
    }

    public PlayerService(PlayMode playMode) {
        this.playMode = playMode;
    }

    public PlayMode getPlayMode() {
        return playMode;
    }

    public void setPlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }

    public void play(){
        this.playMode.play();
    }

}
