package dxc.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flug {

    private Rakete rakete;

    private List<Astronaut> astronauten = new ArrayList<>();

    private LocalDateTime geplanteAbflugzeit;

    private boolean kommunikationAufgebaut = false;

    private boolean wetterOkay = true;

    private boolean flugbahnOkay = true;

    public Flug(Rakete rakete) {
        this.rakete = rakete;
    }

    public void flugzeitVerzoegern(int minuten) {
        LocalDateTime zeit = getGeplanteAbflugzeit();
        zeit = zeit.plusMinutes(minuten);
        setGeplanteAbflugzeit(zeit);
    }

    public void astronautAustauschen(String schluesselAlt, String schluesselNeu) {
        // TODO: Map Austausch Astronaut
    }

    public void losfliegen() {
        rakete.setGeschwindigkeit(100);
    }

    public boolean isFlugbereit() {
        // TODO: nüchtern überprüfen?
        for (Astronaut astro : astronauten) {
            if (!astro.isNuechtern()) {
                return false;
            }
        }

        return Daten.bodenstation.isStartrampeSicher() && isWetterOkay() && isFlugbahnOkay() && isKommunikationAufgebaut();
    }

    public Rakete getRakete() {
        return rakete;
    }

    public List<Astronaut> getAstronauten() {
        return this.astronauten;
    }

    public LocalDateTime getGeplanteAbflugzeit() {
        return geplanteAbflugzeit;
    }

    public void setGeplanteAbflugzeit(LocalDateTime geplanteAbflugzeit) {
        this.geplanteAbflugzeit = geplanteAbflugzeit;
    }

    public boolean isKommunikationAufgebaut() {
        return kommunikationAufgebaut;
    }

    public void setKommunikationAufgebaut(boolean kommunikationAufgebaut) {
        this.kommunikationAufgebaut = kommunikationAufgebaut;
    }

    public boolean isWetterOkay() {
        return wetterOkay;
    }

    public boolean isFlugbahnOkay() {
        return flugbahnOkay;
    }

}
