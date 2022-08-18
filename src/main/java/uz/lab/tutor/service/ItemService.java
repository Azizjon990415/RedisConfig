package uz.lab.tutor.service;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uz.lab.tutor.entity.Item;
import uz.lab.tutor.repository.ItemRepository;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Cacheable(value = "itemCache")
    public Item getItemForId(String id) {
        return itemRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

}