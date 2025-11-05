package org.iesch.ad.demoConsume.modelo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MiRespuesta {

    private List<Fact> factList = new ArrayList<>();

    public void annade(Fact fact){
        factList.add(fact);
    }
}
