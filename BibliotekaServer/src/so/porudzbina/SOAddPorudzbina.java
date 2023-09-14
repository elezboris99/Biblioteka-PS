/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.porudzbina;

import db.DBBroker;
import domeni.AbstractDomainObject;
import domeni.Porudzbina;
import domeni.StavkaPorudzbine;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author Elez
 */
public class SOAddPorudzbina extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Porudzbina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Porudzbina!");
        }

        Porudzbina porudzbina = (Porudzbina) ado;

        if (!porudzbina.getDatumIsporuke().after(new Date())) {
            throw new Exception("Datum isporuke mora biti posle danasnjeg datuma!");
        }

        if (porudzbina.getStavkePorudzbine().isEmpty()) {
            throw new Exception("Porudzbina mora imati barem jednu stavku!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
      
        PreparedStatement ps = DBBroker.getInstance().insert(ado);


        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long porudzbinaID = tableKeys.getLong(1);

     
        Porudzbina porudzbina = (Porudzbina) ado;
        porudzbina.setPorudzbinaID(porudzbinaID);


        for (StavkaPorudzbine stavkaPorudzbine : porudzbina.getStavkePorudzbine()) {
            stavkaPorudzbine.setPorudzbina(porudzbina);
            DBBroker.getInstance().insert(stavkaPorudzbine);
        }

    }

}
