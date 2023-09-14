/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import kontroler.ServerKontroler;
import domeni.Administrator;
import domeni.Kupac;
import domeni.Porudzbina;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Zahtjev;
import transfer.Odgovor;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author Elez
 */
public class NitKlijent extends Thread {

    private Socket socket;

    NitKlijent(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Zahtjev zah = (Zahtjev) in.readObject();
                Odgovor odg = obradiZahtev(zah);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(odg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Odgovor obradiZahtev(Zahtjev zah) {
        Odgovor response = new Odgovor(null, null, ResponseStatus.Success);
        try {
            switch (zah.getOperation()) {
                case Operation.ADD_KUPAC:
                    ServerKontroler.getInstance().addKupac((Kupac) zah.getData());
                    break;
                case Operation.ADD_PORUDZBINA:
                    ServerKontroler.getInstance().addPorudzbina((Porudzbina) zah.getData());
                    break;
                case Operation.DELETE_KUPAC:
                    ServerKontroler.getInstance().deleteKupac((Kupac) zah.getData());
                    break;
                case Operation.DELETE_PORUDZBINA:
                    ServerKontroler.getInstance().deletePorudzbina((Porudzbina) zah.getData());
                    break;
                case Operation.UPDATE_KUPAC:
                    ServerKontroler.getInstance().updateKupac((Kupac) zah.getData());
                    break;
                case Operation.UPDATE_PORUDZBINA:
                    ServerKontroler.getInstance().updatePorudzbina((Porudzbina) zah.getData());
                    break;
                case Operation.GET_ALL_KUPAC:
                    response.setData(ServerKontroler.getInstance().getAllKupac());
                    break;
                case Operation.GET_ALL_KNJIGA:
                    response.setData(ServerKontroler.getInstance().getAllKnjiga());
                    break;
                case Operation.GET_ALL_PORUDZBINA:
                    response.setData(ServerKontroler.getInstance().getAllPorudzbina());
                    break;
                case Operation.GET_ALL_ZANR:
                    response.setData(ServerKontroler.getInstance().getAllZanr());
                    break;
                case Operation.GET_ALL_STAVKA_PORUDZBINE:
                    response.setData(ServerKontroler.getInstance().getAllStavkaPorudzbine((Porudzbina) zah.getData()));
                    break;
                case Operation.LOGIN:
                    Administrator administrator = (Administrator) zah.getData();
                    Administrator ulogovani = ServerKontroler.getInstance().login(administrator);
                    response.setData(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
