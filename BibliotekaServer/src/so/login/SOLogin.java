/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import com.mysql.cj.Session;
import db.DBBroker;
import domeni.AbstractDomainObject;
import domeni.Administrator;
import java.util.ArrayList;
import kontroler.ServerKontroler;
import so.AbstractSO;

/**
 *
 * @author Elez
 */
public class SOLogin extends AbstractSO {
    
    Administrator ulogovani;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
        }
            ArrayList<Administrator> administratoriUlogovani = ServerKontroler.getInstance().getUlogovani();
            Administrator ad = (Administrator) ado;
            for (Administrator administrator : administratoriUlogovani) {
            if(ad.getUsername().equals(administrator.getUsername())&& ad.getPassword().equals(administrator.getPassword())){
            
            throw new Exception("Administrator je vec ulogovan!");
            }
        }
         if(ServerKontroler.getInstance().getUlogovani().size()>2){
         throw new Exception("Trenutno je ulogovano vise od 2 administratora!");
         }
       
        
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        Administrator a = (Administrator) ado;
    
        ArrayList<Administrator> administratori
                = (ArrayList<Administrator>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Administrator administrator : administratori) {
            if (administrator.getUsername().equals(a.getUsername())
                    && administrator.getPassword().equals(a.getPassword())) {
                ulogovani = administrator;
                return;
            }
        }

        throw new Exception("Ne postoji administrator sa tim kredencijalima.");
        
    }

    public Administrator getUlogovani() {
        return ulogovani;
    }
    
    

}
