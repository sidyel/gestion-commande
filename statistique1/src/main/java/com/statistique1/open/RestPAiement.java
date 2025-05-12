package com.statistique1.open;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PAIEMENT1")
public interface RestPAiement {
    @GetMapping("/montant-total")
    public Double getMontantTotalVentes() ;
}
