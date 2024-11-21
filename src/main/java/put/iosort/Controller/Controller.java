package put.iosort.Controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import put.iosort.Service.Context;

import static put.iosort.Config.RestEndpoints.*;

@RestController
@RequestMapping(BASE)
@AllArgsConstructor
public class Controller {

    private final Context context;

    @GetMapping(value = GET + ARRAY + ORDER + STRATEGY_TYPE)
    public ResponseEntity<Object> getSortedArray(@RequestBody int[] numbers) {
        return ResponseEntity.ok(context.handleContext(numbers));
    }




}
