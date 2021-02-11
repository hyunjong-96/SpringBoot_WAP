package org.sopt.seminar8.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar8.domain.Item;
import org.sopt.seminar8.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class TestController {

    private final ItemRepository itemRepository;

    public TestController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/jpa")
    public ResponseEntity jpaTest(){
        try{
            Item item = new Item(2,"test");
            log.info("----------------jpa test start----------------");
            log.info(item.toString());
            log.info("----------------jpa insert data----------------");
            itemRepository.save(item);
            log.info("----------------jpa findOne data----------------");
            Optional<Item> content = itemRepository.findById(1);
            log.info("content:"+content.toString());
            log.info("----------------jpa findAll data----------------");
            Iterable<Item> contentList = itemRepository.findAll();
            List<Item> contentList2 = itemRepository.findAll();
            for(Item i : contentList2){
                log.info("test:"+i.getName()+"/"+i.getId());
            }
            contentList.forEach(str->{log.info("ttttt: "+str.getId());});
            log.info("listTest: "+contentList2);
            log.info(contentList.toString());
            log.info("----------------jpa findName data----------------");
            Optional<Item> testItem = itemRepository.findById(1);
            Iterable<Item> listItem = itemRepository.findByName("test");
            List<Item> convertItem = new ArrayList<>();
            listItem.forEach(convertItem::add);
            log.info("findName: "+testItem.get());
            return new ResponseEntity(convertItem,HttpStatus.OK);
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
