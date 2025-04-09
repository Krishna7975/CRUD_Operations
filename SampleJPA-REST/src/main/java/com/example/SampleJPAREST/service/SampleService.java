package com.example.SampleJPAREST.service;
import com.example.SampleJPAREST.entities.Samples;
import com.example.SampleJPAREST.query.QueryConstant;
import com.example.SampleJPAREST.repository.SampleRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class SampleService
{

    private final ProducerTemplate template;
    private final ObjectMapper mapper;

    @Autowired
    private  SampleRepo sampleRepo;



    public List<Samples> getAllBooks(){
        return sampleRepo.findAll();
    }

    public  Optional<Samples> getBookById(int id)
    {
        Optional<Samples> book=null;
        book=sampleRepo.findById(id);
        return book;
    }
    public Samples addBook(Samples b){
        sampleRepo.save(b);
        return b;
    }

    public void deleteBook(int bid)
    {
         sampleRepo.deleteById(bid);
    }
    public void deleteAllBooks(){
        sampleRepo.deleteAll();
    }

    public ResponseEntity<String> updatebook(Samples book, int bookid){
        Optional<Samples> p = sampleRepo.findById(bookid);
        if (p==null)
            return null;
        book.setId(book.getId());
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        sampleRepo.save(book);
        return ResponseEntity.ok("data updated ");
    }



//    public boolean query(String id, String price) throws JsonProcessingException {
//
//        log.info("Checking the book with a range of price between . Id-{}, price-{}",id, price);
//        String query= QueryConstant.rangeOFPrice.replaceAll("#id",id)
//               .replaceAll("#price",price)+"?dataSource=#postgresDB&outputType=SelectOne";
//        log.info("Query- {}",query);
//        String response = template.requestBody("direct:executeSqlQuery", query, String.class);
//        Map map = mapper.readValue(response, Map.class);
//        return !map.isEmpty();
//    }

    public boolean getBookByName(String name) throws JsonProcessingException{
        log.info("getting the books whose author name starts with . Author-{}",name);
        String query= QueryConstant.nameStartsWith
                +"?" +"outputType=SelectOne";
        log.info("Query- {}",query);
        String response = template.requestBody("direct:executeSqlQuery", query, String.class);
        Map map = mapper.readValue(response, Map.class);
        return !map.isEmpty();

    }

}
