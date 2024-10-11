package com.example.kiosk.kiosk;

import com.example.kiosk.store.exception.StoreNotFoundException;
import com.example.kiosk.store.util.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kiosks")
@RestController
public class KioskController {
    @GetMapping
    public List<KioskResponse> getAllKiosks() {
        List<KioskResponse> list = Utils.kiosks
                .stream()
                .map(KioskResponse::from)
                .toList();
        return list;
    }
    @PostMapping
    public Kiosk addKiosk(@RequestBody KioskRequest request) {
        Kiosk kiosk = request.toKiosk();
        Utils.kiosks.add(kiosk);
        return kiosk;
    }
    @GetMapping("/{kioskId}")
    public Kiosk getKioskById(@PathVariable int kioskId) {
        return Utils.kiosks
                .stream()
                .filter(el -> el.getKioskId() == kioskId)
                .findFirst()
                .orElseThrow(()->new StoreNotFoundException(kioskId));
    }
    @DeleteMapping("/{kioskId}")
    public void deleteKioskById(@PathVariable int kioskId) {
        Kiosk kiosk = getKioskById(kioskId);
        Utils.kiosks.remove(kiosk);
    }

}
