package com.duvalhub.dummy.artifact2.rest;

import com.duvalhub.dummy.artifact2.mediator.Mediator;
import com.duvalhub.web.beans.TheBean;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.StringJoiner;

import static com.duvalhub.dummy.artifact2.rest.EndpointPaths.ENDPOINT_VERSION_V1;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.TEXT_PLAIN_VALUE;

//import org.springframework.beans.factory.config.EmbeddedValueResolver;
//import org.springframework.web.bind.annotation.GetMapping;

import static com.acme.Something.theLabe;
import com.acme.Something;

//import static com.duvalhub.roleaop.artifact2.aop.AlloBobo.ALLO_BOBO;

//import static com.duvalhub.roleaop.artifact2.aop.AlloBobo.ALLO_BOBO;
//import static com.duvalhub.roleaop.artifact2.AlloBobo.ALLO_BOBO;


//import static com.duvalhub.roleaop.
import static com.duvalhub.rolepermission .Df.TEST_STUFF;

@RestController
@RequestMapping(path = ENDPOINT_VERSION_V1)
public class TheController implements EndpointPaths {

    final TheBean theBean;

    final Mediator blobMediator;

    @Autowired
    public TheController(TheBean theBean, Mediator blobMediator) {
        this.theBean = theBean;
        this.blobMediator = blobMediator;
    }

    @GetMapping(path = PROFILES_PATH, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<String> selectOne() {

        return blobMediator.selectOne()
                .map(one -> ResponseEntity.ok(one))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping(path = HELLO_WORLD, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<String> selectHelloWorld() {

        return ResponseEntity.ok("hello world");

    }

    @SneakyThrows
    @GetMapping(path = SECRET_WORLD, produces = {TEXT_PLAIN_VALUE})
    public ResponseEntity<String> selectSecretHelloWorld() {

        return ResponseEntity.ok(new StringJoiner("\n")
                .add("test # 1")
                .add(TEST_STUFF)
                .add(theLabe)
                .add(new Something().getOtherThing())
                .add(Class.forName("org.springframework.web.bind.annotation.GetMapping").getName())
                .add(Integer.toString(theBean.getNumber()))
                .toString());

    }

//    private final Environment environment;
//
//    private final BlobMediator blobMediator;
//
//    public BlobController(
//            Environment environment,
//            BlobMediator blobMediator) {
//        this.environment = environment;
//        this.blobMediator = blobMediator;
//    }
//
//
////    @GetMapping("/test")
////    public String test() {
////        return "Welcome to Book Manager";
////    }
////
////    @PostMapping
////    public void add(@RequestBody @Valid AuthorResource request) {
////        log.info("Author adding api called");
////        authorService.addAuthor(requestAndParamBuilder.requestToParam(request));
////        log.info("Author added.");
////    }
//
//
//    public void postMethod() {
//
//
//    }
//
////    @GetMapping("/{id}")
////    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) {
////        Optional<User> user = userRepository.findById(id);
////
////        if(user.isPresent()) {
////            return ResponseEntity.ok().body(user.get());
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
//
//    /*
//     *
//     */
//
//    @GetMapping(path = SELECT_ONE_PATH, produces = {APPLICATION_JSON_VALUE})
//    public ResponseEntity<String> selectOne() {
//
//        return blobMediator.selectOne().map(one -> ResponseEntity.ok(one))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//
//    }
//
//    @GetMapping(path = PROFILES_PATH, produces = {APPLICATION_JSON_VALUE})
//    public ResponseEntity<List<String>> profiles() {
//
//        return ResponseEntity.ok(Arrays.asList(environment.getActiveProfiles()));
//
//    }



}
