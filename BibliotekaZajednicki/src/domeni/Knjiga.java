/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domeni;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elez
 */
public class Knjiga extends AbstractDomainObject {

    private Long knjigaID;
    private String nazivKnjige;
    private String pisac;
    private String opis;
    private double cenaKnjige;
    private int izdanje;
    private Zanr zanr;

    @Override
    public String toString() {
        return nazivKnjige + " (Cena: " + cenaKnjige + "din, Zanr: " + zanr.getNazivZanra() + ", Pisac: " + pisac + ")";
    }

    public Knjiga(Long knjigaID, String nazivKnjige, String pisac, String opis, double cenaKnjige, int izdanje, Zanr zanr) {
        this.knjigaID = knjigaID;
        this.nazivKnjige = nazivKnjige;
        this.pisac = pisac;
        this.opis = opis;
        this.cenaKnjige = cenaKnjige;
        this.izdanje = izdanje;
        this.zanr = zanr;
    }

    public Knjiga() {
    }

    @Override
    public String nazivTabele() {
        return " Knjiga ";
    }

    @Override
    public String alijas() {
        return " knj ";
    }

    @Override
    public String join() {
        return " JOIN ZANR Z ON (Z.ZANRID = KNJ.ZANRID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Zanr z = new Zanr(rs.getLong("zanrID"), rs.getString("NazivZanra"));

            Knjiga knj = new Knjiga(rs.getLong("knjigaID"), rs.getString("nazivKnjige"),
                    rs.getString("pisac"), rs.getString("opis"), rs.getDouble("cenaKnjige"),
                    rs.getInt("izdanje"), z);

            lista.add(knj);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String uslov() {
        return " knjigaID = " + knjigaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    public Long getKnjigaID() {
        return knjigaID;
    }

    public void setKnjigaID(Long knjigaID) {
        this.knjigaID = knjigaID;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public String getPisac() {
        return pisac;
    }

    public void setPisac(String pisac) {
        this.pisac = pisac;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCenaKnjige() {
        return cenaKnjige;
    }

    public void setCenaKnjige(double cenaKnjige) {
        this.cenaKnjige = cenaKnjige;
    }

    public int getIzdanje() {
        return izdanje;
    }

    public void setIzdanje(int izdanje) {
        this.izdanje = izdanje;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

}
