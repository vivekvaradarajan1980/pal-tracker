package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

        private String port;
        private String memlimit;
        private String cfIndex;
        private String cfADDR;

        public EnvController(@Value("${port:8675}") String port,
                             @Value("${memory.limit:12G}") String memlimit,
                             @Value("${cf.instance.index:34}") String index,
                             @Value("${cf.instance.addr:123.sesame.street}") String addr)
        {
                this.port=port;
                this.memlimit=memlimit;
                this.cfADDR=addr;
                this.cfIndex=index;


        }
        @GetMapping("/env")
        public Map<String,String> getEnv(){
                Map envMap=new HashMap<String,String>();
                envMap.put("PORT",this.port);
                envMap.put("MEMORY_LIMIT",this.memlimit);
                envMap.put("CF_INSTANCE_INDEX",this.cfIndex);
                envMap.put("CF_INSTANCE_ADDR",this.cfADDR);

                return envMap;
        }

}
