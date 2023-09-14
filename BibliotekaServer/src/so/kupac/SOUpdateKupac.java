/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kupac;

import db.DBBroker;
import domeni.AbstractDomainObject;
import domeni.Kupac;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Elez
 */
public class SOUpdateKupac extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Kupac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kupac!");
        }

        Kupac k = (Kupac) ado;

        ArrayList<Kupac> kupci = (ArrayList<Kupac>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Kupac kupac : kupci) {
            if (!kupac.getKupacID().equals(k.getKupacID())) {
                if (kupac.getEmail().equals(k.getEmail())) {
                    throw new Exception("Vec postoji kupac sa tim emailom!");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }

}
