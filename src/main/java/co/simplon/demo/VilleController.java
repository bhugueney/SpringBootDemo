package co.simplon.demo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/villes")
@CrossOrigin("*")
public class VilleController {

    @RequestMapping(method = RequestMethod.GET)
    public List<City> test(){
        List<City > res= new ArrayList<City>();
        res.add(new City("Paris", 2.333, 48.8666));
        res.add(new City("Montreuil", 2.448, 48.863812));
        return res;
    }
    // requête localhost:8090/villes/sub?measure-type=MaMesure
    @RequestMapping(value = "/sub"
            ,method = RequestMethod.GET)
    public String testSub(@RequestParam("measure-type") String measureType,
                          @RequestParam(value = "start-date", required = false) LocalDateTime begin,
                          @RequestParam(value = "end-date", required = false) LocalDateTime end){
        String res=  "measure-type: "+measureType+"\n"+"begin: "+ begin+"\n"+"end: "+ end;
        System.out.println(res);
        return "<H1> Test sub</H1>\n"+res;
    }

    @RequestMapping(method = RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    @ResponseStatus(HttpStatus.CREATED)
     public Long createForm(City resource) {
        System.out.println("Création par formulaire HTML de la resource :"+resource);
        return 1L;

    }
    @RequestMapping(method = RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createJson(@RequestBody City resource) {
        System.out.println("Création par javascript de la resource :"+resource);
        return 1L;
    }

    @RequestMapping(value = "/{identifiant}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("identifiant") Long id){
        System.out.println("Suppression de l'entité avec l'id :" +id);
    }

}
