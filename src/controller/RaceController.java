package controller;

/**
 * Created by odins on 5/28/2017.
 * Unless it is poorly made, then it must
 * have been someone else.
 */
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
}
