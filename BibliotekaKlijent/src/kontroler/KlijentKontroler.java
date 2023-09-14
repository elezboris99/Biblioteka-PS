/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domeni.Administrator;
import domeni.Knjiga;
import domeni.Kupac;
import domeni.Porudzbina;
import domeni.StavkaPorudzbine;
import domeni.Zanr;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Zahtjev;
import transfer.Odgovor;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author Elez
 */
public class KlijentKontroler {

    private static KlijentKontroler instance;

    private KlijentKontroler() {
    }

    public static KlijentKontroler getInstance() {
        if (instance == null) {
            instance = new KlijentKontroler();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) posaljiZahtev(Operation.LOGIN, administrator);
    }

    public void addKupac(Kupac kupac) throws Exception {
        posaljiZahtev(Operation.ADD_KUPAC, kupac);
    }

    public void addPorudzbina(Porudzbina porudzbina) throws Exception {
        posaljiZahtev(Operation.ADD_PORUDZBINA, porudzbina);
    }

    public void deleteKupac(Kupac kupac) throws Exception {
        posaljiZahtev(Operation.DELETE_KUPAC, kupac);
    }

    public void deletePorudzbina(Porudzbina porudzbina) throws Exception {
        posaljiZahtev(Operation.DELETE_PORUDZBINA, porudzbina);
    }

    public void updateKupac(Kupac kupac) throws Exception {
        posaljiZahtev(Operation.UPDATE_KUPAC, kupac);
    }

    public void updatePorudzbina(Porudzbina porudzbina) throws Exception {
        posaljiZahtev(Operation.UPDATE_PORUDZBINA, porudzbina);
    }

    public ArrayList<Kupac> getAllKupac() throws Exception {
        return (ArrayList<Kupac>) posaljiZahtev(Operation.GET_ALL_KUPAC, null);
    }

    public ArrayList<Porudzbina> getAllPorudzbina() throws Exception {
        return (ArrayList<Porudzbina>) posaljiZahtev(Operation.GET_ALL_PORUDZBINA, null);
    }

    public ArrayList<Zanr> getAllZanr() throws Exception {
        return (ArrayList<Zanr>) posaljiZahtev(Operation.GET_ALL_ZANR, null);
    }

    public ArrayList<Knjiga> getAllKnjiga() throws Exception {
        return (ArrayList<Knjiga>) posaljiZahtev(Operation.GET_ALL_KNJIGA, null);
    }

    public ArrayList<StavkaPorudzbine> getAllStavkaPorudzbine(Porudzbina p) throws Exception {
        return (ArrayList<StavkaPorudzbine>) posaljiZahtev(Operation.GET_ALL_STAVKA_PORUDZBINE, p);
    }

    private Object posaljiZahtev(int operation, Object data) throws Exception {
        Zahtjev zah = new Zahtjev(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(zah);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Odgovor odg = (Odgovor) in.readObject();

        if (odg.getResponseStatus().equals(ResponseStatus.Error)) {
            throw odg.getException();
        } else {
            return odg.getData();
        }

    }
}
