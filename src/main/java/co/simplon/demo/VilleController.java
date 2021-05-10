package co.simplon.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    @RequestMapping(value = "/sub"
            ,method = RequestMethod.GET)
    public String testSub(@RequestParam("measure-type") String measureType){
        System.out.println("measure-type: "+measureType);
        return "<H1> Test sub</H1>";
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
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        System.out.println("Suppression de l'entité avec l'id :" +id);
        return ;
    }

}
