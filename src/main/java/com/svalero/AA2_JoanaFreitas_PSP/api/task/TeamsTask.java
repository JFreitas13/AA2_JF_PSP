package com.svalero.AA2_JoanaFreitas_PSP.api.task;

import com.svalero.AA2_JoanaFreitas_PSP.api.model.Team;
import com.svalero.AA2_JoanaFreitas_PSP.api.service.BasketService;
import io.reactivex.functions.Consumer;
import javafx.concurrent.Task;



public class TeamsTask extends Task {

    public Consumer<Team> user;

    public TeamsTask(Consumer<Team> user) {
        this.user = user;
    }

    @Override
    protected Object call() throws Exception {
        BasketService basketService = new BasketService();
        basketService.getTeams().subscribe(user);
        return null;
    }

}
