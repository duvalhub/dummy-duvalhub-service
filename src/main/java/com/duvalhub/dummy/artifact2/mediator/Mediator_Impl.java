package com.duvalhub.dummy.artifact2.mediator;

import com.duvalhub.dummy.artifact2.rest.EndpointPaths;
import com.duvalhub.dummy.artifact2.service.PrivilegedService;
import com.duvalhub.dummy.artifact2.service.SlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@PerformanceLogger
@Component
@Primary
public class Mediator_Impl implements Mediator, EndpointPaths {

    final SlowService slowService;

    final PrivilegedService privilegedService;

    @Autowired
    public Mediator_Impl(SlowService slowService, PrivilegedService privilegedService) {
        this.slowService = slowService;
        this.privilegedService = privilegedService;
    }

//    @Autowired
//    public BlobMediator_Impl(@Qualifier(SELECT_ONES_STUB) SelectOnes selectOnes) {
//        this.selectOnes = selectOnes;
//    }

    @Override
    public Optional<String> selectOne() {

        slowService.update();

        privilegedService.somethingProhibited();

        return Optional.of(PROFILES_PATH);

//        return selectOnes.selectOnes()
//                .stream()
//                .findAny()
//                .map(one -> Integer.toString(one));
    }


}
