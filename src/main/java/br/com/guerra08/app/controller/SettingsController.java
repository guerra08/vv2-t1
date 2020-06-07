package br.com.guerra08.app.controller;

import br.com.guerra08.app.constant.CSpaces;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SettingsController {

    public SettingsController(){}

    @PostMapping("/set-constants")
    public ResponseEntity<String> setConstants(@RequestParam Map<String, String> updatedValues){
        CSpaces.PRICE_PER_SEAT = Double.parseDouble(updatedValues.get("seatValue"));
        CSpaces.PRICE_PER_SQUARE = Double.parseDouble(updatedValues.get("sqmValue"));
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/get-constants")
    public ResponseEntity<Map<String, Double>> getCurrentConstants(){
        Map<String, Double> currentConst = new HashMap<>();
        currentConst.put("sqmValue", CSpaces.PRICE_PER_SQUARE);
        currentConst.put("seatValue", CSpaces.PRICE_PER_SEAT);
        return ResponseEntity.ok(currentConst);
    }

}
