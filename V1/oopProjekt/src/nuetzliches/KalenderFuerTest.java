package nuetzliches;

import java.time.LocalDate;

public class KalenderFuerTest {

    private LocalDate heute;

    public KalenderFuerTest(LocalDate heute) {
        this.heute = nuetzliches.Kalender.getHeutigesDatum();
    }

    public void setHeutigesDatum(LocalDate heute) {
        this.heute = heute;
    }
}
