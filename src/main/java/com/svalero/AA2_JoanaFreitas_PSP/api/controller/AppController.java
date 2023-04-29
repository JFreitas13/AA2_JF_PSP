package com.svalero.AA2_JoanaFreitas_PSP.api.controller;

import com.svalero.AA2_JoanaFreitas_PSP.api.model.Team;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class AppController {
    @FXML
    private Button btAllTeams;

    @FXML
    private TextArea teamsArea;

    private List<String> teams;

    Team newTeam;

    public void showAllTeams(ActionEvent event) {
        this.teams = new ArrayList<String>();
        teamsArea.setText("");

        Consumer<Team> user = (team) -> {
            String previousText;
            previousText = teamsArea.getText() + "\n";
            //Thread.sleep(100);
            this.teamsArea.setText(teamsArea.getText() + "\n" + team.getId() + "\n" + team.getAbbreviation() + "\n" + team.getCity() + "\n" + team.getConference() + "\n" + team.getDivision() + "\n" + team.getFull_name() + "\n" + team.getName());
            this.teams.add(team.getId() + team.getAbbreviation() + team.getCity() + team.getConference() + team.getDivision() + team.getFull_name() + team.getName());
        };
    }
}
