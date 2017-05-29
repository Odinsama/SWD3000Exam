package controller;
public class RaceController {

    private static IRaceUI raceUI;

    public static void fileComplaint() {
        if (raceUI == null)return;
        raceUI.fileComplaint();
    }

    public static void init(IRaceUI raceUI) {
        RaceController.raceUI = raceUI;
    }

    public static void resetComplaints() {
        raceUI.resetComplaints();
    }

    public static void raceFinished() {
        raceUI.raceFinished();
    }
}
