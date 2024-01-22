package seth.rdPartyIntergration11jan.service;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class PostServiceImpl implements PostService {

    String baseUrl = "https://jsonplaceholder.typicode.com/";

    StringBuilder stringBuilder = new StringBuilder(baseUrl);

    String POST = "/posts";
    @Autowired
    private RestTemplate   restTemplate;
    @Override
    public List<Map<String, Object>> getPosts() {
        HttpEntity <Void> httpEntity  = new HttpEntity<>(getHttpHeaders());
        String url = stringBuilder.append(POST).toString();
        val response  =  restTemplate.exchange(url , HttpMethod.GET ,httpEntity,List.class);
        return  response.getBody();
    }


    private HttpHeaders getHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return  headers;
    }
}
